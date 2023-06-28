import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PeriodicElement {
  workoutName!: string;
  workoutType!: string;
  workoutDuration!: number;
  date!: string;
  sets!:number
}

const ELEMENT_DATA: PeriodicElement[] = [
  {workoutName: 'Push-Up Challeng', workoutType: 'Push-ups', workoutDuration: 1, date: '13-05-2023',sets:1},
  {workoutName: 'Squat Power', workoutType: 'Squats', workoutDuration: 2.34, date: '13-05-2023',sets:1},
  {workoutName: 'Cardio Blast', workoutType: 'Jumping jacksn', workoutDuration: 5, date: '13-05-2023',sets:1},

  
];
const wt: WorkoutTypes[] = [
  { workoutName: 'Push-Up Challenge', exercise: ['Push-ups','Diamond' ,'push-ups', 'Wide-push-ups'], addWorkout: 'H' },
  { workoutName: 'Squat Power', exercise: ['Squats', 'Jump squats', 'Barbell squats'], addWorkout: 'H' },
  { workoutName: 'Cardio Blast', exercise: ['Jumping jacks', 'High knees', 'Burpees'], addWorkout: 'H' },


];
export class WorkoutTypes {
  workoutName!: string;
  exercise!: any[];
  // workoutVideo: number;
  addWorkout!: string;
}

export class WorkoutService {

  constructor() { 

  }
  getData(){
    return ELEMENT_DATA;
  }
  getWorkoutTypes(){
    console.log(wt);
    return wt;
  }
}
