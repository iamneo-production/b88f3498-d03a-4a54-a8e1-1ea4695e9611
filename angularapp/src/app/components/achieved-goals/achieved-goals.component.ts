import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';
import { environment } from 'src/environment';


interface Goal {
  id: number;
  name: string;
  notes: string;
  intensity: string;
  date: any;
  duration: number;
  status: string;
}

@Component({
  selector: 'app-achieved-goals',
  templateUrl: './achieved-goals.component.html',
  styleUrls: ['./achieved-goals.component.scss']
})
export class AchievedGoalsComponent implements OnInit{

constructor(private http:HttpClient, private tokenService: TokenService){}

  ngOnInit(): void {
    this.getAchievedGoals();
  }


  achievedGoals: any;

  getAchievedGoals(){
    this.http.get<any>(environment.baseUrl+'/goal/all?status=complete',this.tokenService.getHeader()).subscribe(response=>{
      const date = response[0].date;
      console.log(date);
      console.log('------');
      response = this.formatDate(response);
      console.log(response);
      this.achievedGoals = response;
    })
  }

  formatDate(exercises: Goal[]): Goal[] {
    for (const exercise of exercises) {
      console.log(exercise.date+'inFormatDate');
      let date:any[] = exercise.date.split('-');
      console.log(date[0]);
      const formattedDate = date[2]+'-'+date[1]+'-'+date[0];
      exercise.date = formattedDate;
      console.log(exercise.date+'inFormatDate-----');
    }
    console.log(exercises);
    return exercises;
  }

  // padZero(value: number): string {
  //   console.log(value);
  //   if(value<10){
  //     return '0'+value
  //   }
  //   return value+'';
  // }

}
