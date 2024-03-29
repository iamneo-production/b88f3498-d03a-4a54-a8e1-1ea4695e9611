import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { environment } from 'src/environment';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnDestroy {
  constructor(private http: HttpClient, private tokenService: TokenService) {

  }

 async getCurrentUser() {
    let activeUser = this.user;
    console.log("token in userService", this.tokenService.getToken());
    
    this.http.get(`${this.baseUrl}/user/getCurrentUser`, this.tokenService.getHeader()).subscribe({
      next: (currUser: any) => {
        this.setUser(currUser);
        activeUser = currUser;
        console.log("currUser: ", activeUser);

      }
    })
    return activeUser;
  }

  baseUrl: string = environment.baseUrl;
  user: any = { email: '', name: 'DefaultUser', password: '', height: 67, weight: 56, age: 20, gender: 'Female', imagePath: "./../../../assets/icon/user.png" };
  userCalorie: number = 2000;
  userSubject = new BehaviorSubject(this.user);

  ngOnDestroy(): void {
    this.userSubject.unsubscribe();
  }

  setUser(user: any) {
    this.userSubject.next(user);
  }
  getUser() {
    this.userSubject.subscribe(newUser => {
      this.user = newUser;
    });
    return this.user;
  }


  getUserWorkout(){
    let workouts:any = [];
    this.http.get(`${this.baseUrl}/workout/userId`, { headers: {'Authorization': 'Bearer ' + this.tokenService.getToken() }, params : {'userId': this.getUser().id} }).subscribe({
      next: (workout:any)=>{
        workouts = workout;
      }
    })
    return workouts;
  
  }
  getUserCalorie(weight: number) {
    let BMR = 0;
    let activity_factor = 1.2;

    this.userSubject.subscribe((userData) => {
      if (userData.gender == "Male") {
        BMR = (10 * weight) + (6.25 * userData.height) - (5 * userData.age) + 5;
      } else {
        BMR = (10 * weight) + (6.25 * userData.height) - (5 * userData.age) - 161;
      }
      // getting activity_factor if one workout allowed perday
      if (this.getUserWorkout() && (this.getUserWorkout().length > 0 && this.getUserWorkout().length <= 3))
        activity_factor = 1.375;
      else if (this.getUserWorkout().length > 3 && this.getUserWorkout().length <= 5)
        activity_factor = 1.55;
      else if (this.getUserWorkout().length > 5 && this.getUserWorkout().length <= 7)
        activity_factor = 1.725;
      else if (this.getUserWorkout().length > 7)
        activity_factor = 1.9;
      // calorie calculation
    })
    return this.userCalorie = BMR * activity_factor;
  }

}
