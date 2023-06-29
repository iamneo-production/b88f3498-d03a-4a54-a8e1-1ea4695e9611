import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { TitleService } from 'app/services/title.service';
import { WorkoutService } from 'app/workout.service';

@Component({
  selector: 'app-workoutplan',
  templateUrl: './workoutplan.component.html',
  styleUrls: ['./workoutplan.component.scss'],
  providers:[WorkoutService]
})
export class WorkoutplanComponent implements OnInit {
  show: string = "btns";
  panelOpenState = false;
  displayedColumns: string[] = ['workoutName', 'exercise', 'addWorkout'];
  
  isOpen = false;
  isSubmitted: boolean = false;
  dataList: any[] = ['Arms', 'Leg', 'Abs', 'Back'];
  ds = this.workout.getWorkoutTypes();
  constructor(private titleService: TitleService,private router : Router,private workout:WorkoutService) {
    this.titleService.setTitle("Workout Plan");
  }
  // operation(name: string) {
  //   this.show = name;
  // }


  showDiv() {
    this.isOpen = true;
  }
  closeDiv() {
    this.isOpen = false;
  }

  ngOnInit(): void {
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  AddToHistory() {
    this.isSubmitted = true;
  }
  goBack(){
    window.location.reload();
  }

}
