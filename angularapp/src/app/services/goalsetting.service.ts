import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { environment } from 'src/environment';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class GoalsettingService {

  private goalData: any = null;
  private responseBody: any = null;

  constructor(private http: HttpClient,private userService : UserService,private tokenService: TokenService) { }

  setGoalData(requestData: any): string {
    console.log("In");
    this.http.post<any>(environment.baseUrl+"/goal/set", requestData,this.tokenService.getHeader()).subscribe(response =>{
      console.log(response);
      this.responseBody=response;
    });
    return this.responseBody;

  }
}
