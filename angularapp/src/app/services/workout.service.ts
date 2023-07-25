import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class WorkoutTypes {
  workoutName!: string;
  exercise!: any[];
  // workoutVideo: number;
  addWorkout!: string;
}

const wt: WorkoutTypes[] = [
  { workoutName: 'Push-Up Challenge', exercise: ['Push-ups','Diamond-push-ups', 'Wide-push-ups'], addWorkout: 'H' },
  { workoutName: 'Squat Power', exercise: ['Squats', 'Jump squats', 'Barbell squats'], addWorkout: 'H' },
  { workoutName: 'Cardio Blast', exercise: ['Jumping jacks', 'High knees', 'Burpees'], addWorkout: 'H' },
  { workoutName: 'Bices and trices', exercise: ['Curls', 'Pull-ups', 'Boxing'], addWorkout: 'H' },
  { workoutName: 'Abs control', exercise: ['Crunches', 'Russian twist', 'Leg rise'], addWorkout: 'H' },
];

export class WorkoutService {

  constructor() {}

  getData(){
    return wt;
  }
  getWorkoutTypes(){
    console.log(wt);
    return wt;
  }
}
