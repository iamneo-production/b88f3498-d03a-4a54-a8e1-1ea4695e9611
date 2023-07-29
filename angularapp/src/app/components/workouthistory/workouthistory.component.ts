import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TitleService } from 'src/app/services/title.service';
import { TokenService } from 'src/app/services/token.service';
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

  displayedColumns: string[] = ['ExerciseName', 'Duration', 'Date', 'Sets', 'Reps','Weight','Notes','Action'];
  ds:any[] = [];


  constructor(private titleService: TitleService, private workout: WorkoutService,private http: HttpClient,private userService:UserService,private tokenService: TokenService) {
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
    return this.http.get<PeriodicElement>(environment.baseUrl+'/workout/history?userId='+this.userService.getUser().id,this.tokenService.getHeader());
  }
  async deleteHistory(id:number){
    console.log(id);
    this.http.delete(`${this.userService.baseUrl}/workout/history/delete/${id}`, this.tokenService.getHeader()).subscribe({
      next:  (data:any) => {
        console.log('Delete request successful:', data);
        this.getAllHistory(); 
      },
      error: (error) => {
        console.error('Error while making delete request:', error);
      }
    });  
    
  }

  deleteObjectsWithId(arr: any[], idToDelete: number): any[] {
    const filteredArray = arr.filter((obj) => obj.id !== idToDelete);
    return filteredArray;
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
  id!:number
}

