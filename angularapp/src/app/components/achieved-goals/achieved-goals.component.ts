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
      console.log(response);
      response = this.formatDate(response);
      console.log(response);
      this.achievedGoals = response;
    })
  }

  formatDate(exercises: Goal[]): Goal[] {
    for (const exercise of exercises) {
      const [year, month, day] = exercise.date;
      const formattedDate = `${this.padZero(day)}-${this.padZero(month)}-${year}`;
      exercise.date = formattedDate;
    }
    return exercises;
  }

  padZero(value: number): string {
    return value.toString().padStart(2, '0');
  }

}
