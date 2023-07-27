package com.example.springapp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springapp.exception.CustomDataAccessException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidInputException;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.model.Exercise;
import com.example.springapp.model.Set;
import com.example.springapp.model.User;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.ExerciseRepository;
import com.example.springapp.repository.SetRepository;
import com.example.springapp.repository.WorkoutRepository;


@Service
public class WorkoutService extends RuntimeException implements WorkoutServiceInterface {
  
    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private SetRepository setRepository;


    @Override
    public Iterable<Workout> getAllWorkout() throws CustomDataAccessException{
        try {
            return workoutRepository.findAll();
        } catch (Exception e) {
            throw new CustomDataAccessException("Error occurred while retrieving all workouts", e);
        }
    }
    @Override
    public Workout getWorkoutById(long id) throws WorkoutNotFoundException{
        Optional<Workout> optionalworkout = workoutRepository.findWorkoutById(id);
        if(optionalworkout.isEmpty()){
            throw new WorkoutNotFoundException("Workout does not exists for Particular ID");
        }
        return optionalworkout.get();
    }
     
    @Override
    public List<Workout> getWorkOutByUserId(long userId) throws UserNotFoundException{
       return workoutRepository.findAllByUserId(userId);
    }
    public ResponseEntity<String> createWorkout( Workout workout) {
        long userId = workout.getUser().getId();
        User newUser = new User();
        newUser.setId(userId);
        workout.setUser(newUser);
        Workout createdWorkout = workoutRepository.save(workout);
        if (createdWorkout != null) {
            return ResponseEntity.ok("Workout Created");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   }
   @Override
   public ResponseEntity<String> updateWorkout(Workout workout)  throws InvalidInputException {
        if (workout == null || workout.getUser() == null || workout.getUser().getId() <= 0) {
            throw new InvalidInputException("Invalid input provided for updating the workout.");
        }
        long userId = workout.getUser().getId();
        User newUser = new User();
        newUser.setId(userId);
        workout.setUser(newUser);
        Workout createdWorkout;
        try{
            createdWorkout = workoutRepository.save(workout);
        }catch (Exception e) {
            throw new InvalidInputException("Error occurred while updating the workout.");
        }
        if(createdWorkout != null) {
            return ResponseEntity.ok("workout Updated");
        } 
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<String> deleteWorkoutById(long id) throws InvalidDeleteException {
    try {
        workoutRepository.deleteById(id);
        return new ResponseEntity<>("Workout deleted", HttpStatus.OK);
    } catch (Exception e) {
        throw new InvalidDeleteException("Error occurred while deleting the workout.");
    }
}

    @Transactional
    public ResponseEntity<HashMap<String,Object>> addToWorkoutHistory(HashMap<String,Object> body) throws InvalidDeleteException{
        try {
            long userId = (Integer) body.get("id");
            String date = (String) body.get("date");
            String duration = (String) body.get("duration");
            int sets = (Integer) body.get("sets");
            int reps = (Integer) body.get("reps");
            int weight = (Integer) body.get("weight");
            String notes = (String) body.get("notes");
            String exerciseType = (String) body.get("exerciseType");

            //Create a User object for adding workout
            User user = new User();
            user.setId(userId);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(date, formatter);

            Workout workout = new Workout(0,user,localDate,duration,notes);
            Workout createdWorkout = workoutRepository.save(workout);
            
            //for adding exercise
            Exercise exercise = new Exercise(0,createdWorkout.getId(),exerciseType,notes);
            Exercise createdExercise = exerciseRepository.save(exercise);

            //for adding set
            Set set = new Set((long)0,(long)reps,createdExercise.getId(),weight+"",sets+"");
            setRepository.save(set);

            return new ResponseEntity<>(body, HttpStatus.OK);
            // return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            throw new InvalidDeleteException("Error occurred while adding data to workout history.");
        }
    }

    public ResponseEntity<List<HashMap<String,Object>>> getHistory(long id){
        List<HashMap<String,Object>> response = new ArrayList<HashMap<String,Object>>();
        List<Workout> allWorkouts = workoutRepository.findAllByUserId(id);
        Iterator<Workout> workoutIterator = (Iterator) allWorkouts.iterator();
        while(workoutIterator.hasNext()){
            Workout workout = workoutIterator.next();
            long workoutId = workout.getId();
            // System.out.println(workoutId);
            List<Exercise> allExercises = exerciseRepository.findAllByWorkoutId(workoutId);
            Iterator<Exercise> exerciseIterator = (Iterator) allExercises.iterator();
            while(exerciseIterator.hasNext()){
                HashMap<String,Object> map = new HashMap<>();
                Exercise exercise = exerciseIterator.next();
                long exerciseId = exercise.getId();
                List<Set> allSets = setRepository.findByExerciseId(exerciseId);
                Iterator<Set> setIterator = (Iterator) allSets.iterator();
                while (setIterator.hasNext()) {
                    Set set = setIterator.next();
                    map.put("sets",set.getDuration());
                    map.put("weight", set.getWeight());
                    map.put("reps" ,set.getReps());
                    map.put("exerciseName" ,exercise.getName());
                    map.put("date" ,workout.getDate().toString());
                    map.put("duration", workout.getDuration());
                    map.put("notes" ,workout.getNotes());
                    map.put("id",workoutId);
                    response.add(map);
                }
                
            }
        }
        return new ResponseEntity<List<HashMap<String,Object>>>(response,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteHistoryById(long id) throws InvalidDeleteException{
        Optional<Workout> optWorkout = workoutRepository.findWorkoutById(id);
        System.out.println("in1");
        if(optWorkout.isEmpty()){
            throw new InvalidDeleteException("Error occurred while deleting data from workout history.");
        }
        System.out.println("in2");
        Optional<Exercise> optionalExercise = exerciseRepository.findByWorkoutId(id);
        if(optionalExercise.isEmpty()){
            throw new InvalidDeleteException("Error occurred while deleting data from workout history.");
        }
        System.out.println("in3");
        long exerciseId = ((Exercise)optionalExercise.get()).getId();
        Set optSet = setRepository.findByExerciseId(exerciseId).get(0);
        if(optSet==null){
            throw new InvalidDeleteException("Error occurred while deleting data from workout history.");
        }
        System.out.println("in4");
        setRepository.deleteById(optSet.getId());
        exerciseRepository.deleteById(exerciseId);
        workoutRepository.deleteById(id);
        System.out.println("in5");

        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
  
   
}
