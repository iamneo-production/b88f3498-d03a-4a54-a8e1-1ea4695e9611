import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TitleService } from 'src/app/services/title.service';
import { TokenService } from 'src/app/services/token.service';
import { UserService } from 'src/app/services/user.service';
import { WorkoutService } from 'src/app/services/workout.service';
import { environment } from 'src/environment';


@Component({
  selector: 'app-workoutplan',
  templateUrl: './workoutplan.component.html',
  styleUrls: ['./workoutplan.component.scss'],
  providers: [WorkoutService]
})
export class WorkoutplanComponent implements OnInit {
  show: string = "btns";
  panelOpenState = false;
  displayedColumns: string[] = ['workoutName', 'exercise', 'addWorkout'];

  isOpen = false;
  isSubmitted: boolean = false;
  dataList: any[] = [];
  ds = this.workout.getWorkoutTypes();
  //goalForm: any;
  exerciseType: string = ''; 
  sets: number = 0;
  reps: number = 0;
  notes: string = '';
  weight: number = 0;
  duration: number = 0;
  date: string = '';
  userId:number = 0;

  constructor(private titleService: TitleService, private router: Router, private workout: WorkoutService,private userService: UserService,private http :HttpClient, private tokenService: TokenService) {
    this.titleService.setTitle("Workout Plan");
  }
  // operation(name: string) {
  //   this.show = name;
  // }
 

  showDiv(element:any) {
    console.log(element);
    this.dataList = element.exercise;
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

  AddToHistory(formData:any) {
    this.userId = this.userService.getUser().id;
    formData.id = this.userId;
    console.log(formData);
    this.postData(environment.baseUrl+'/workout/addToHistory',formData);
    this.isSubmitted = true;
  }

  postData(url: string, requestData: any){
    console.log("In");
    this.http.post<any>(url, requestData,this.tokenService.getHeader()).subscribe(
      (response) => {
        console.log(response);
        console.log(1);
      },
      (error) => {
        if (error instanceof Error) {
          alert("Error occurred: " + error.message);
        } else {
          alert("An error occurred. Please try again later.");
        }
      }
    );
  }
  goBack() {
    this.isOpen = false;
  }

}
