import { Component, OnInit } from '@angular/core';
import { TitleService } from 'src/app/services/title.service';
import { WorkoutService } from 'src/app/services/workout.service';




@Component({
  selector: 'app-workouthistory',
  templateUrl: './workouthistory.component.html',
  styleUrls: ['./workouthistory.component.scss'],
  providers: [WorkoutService]
})

export class WorkouthistoryComponent implements OnInit {

  displayedColumns: string[] = ['workoutName', 'workoutType', 'workoutDuration', 'date', 'sets'];
  ds = this.workout.getData();


  constructor(private titleService: TitleService, private workout: WorkoutService) {
    this.titleService.setTitle("Workout History");
  }

  ngOnInit(): void {
    
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

}

