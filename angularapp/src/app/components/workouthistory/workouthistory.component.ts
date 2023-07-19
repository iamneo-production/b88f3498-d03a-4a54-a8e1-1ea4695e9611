import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TitleService } from 'src/app/services/title.service';
import { UserService } from 'src/app/services/user.service';
import { WorkoutService } from 'src/app/services/workout.service';
import { environment } from 'src/environment';




@Component({
  selector: 'app-workouthistory',
  templateUrl: './workouthistory.component.html',
  styleUrls: ['./workouthistory.component.scss'],
  providers: [WorkoutService]
})

export class WorkouthistoryComponent implements OnInit {

  displayedColumns: string[] = ['ExerciseName', 'Duration', 'Date', 'Sets', 'Reps','Weight','Notes'];
  ds = [];


  constructor(private titleService: TitleService, private workout: WorkoutService,private http: HttpClient,private userService:UserService) {
    this.titleService.setTitle("Workout History");
  }

  ngOnInit(): void {
    console.log(this.userService.getUser().id);
    this.getAllHistory();
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }
  getAllHistory(){
    this.getData().subscribe(response=>{
      console.log(response);
      this.ds = response;
    })
  }
  getData(): Observable<any> {
    return this.http.get<PeriodicElement>(environment.baseUrl+'/workout/history?userId='+this.userService.getUser().id);
  }

}
export class PeriodicElement {
  name!: string;
  duration!: string;
  date!: number;
  exerciseName!: string;
  reps!:number;
  notes!:string;
  sets!:string;
  weight!:string;
}

