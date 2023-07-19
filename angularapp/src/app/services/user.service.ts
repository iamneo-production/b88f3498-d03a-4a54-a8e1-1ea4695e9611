import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnDestroy {
  constructor(private http: HttpClient){

  }

  baseUrl:string = 'https://8080-caffdebdbbfedaaaccdcddcffebdffccbebc.project.examly.io';
  user: any = { email: '',  name: 'DefaultUser', password: '', height: 67, weight: 56, age: 20, gender: 'Female', imagePath:  "./../../../assets/icon/user.png" };
  userCalorie: number = 2000;
  userSubject = new BehaviorSubject(this.user);

  ngOnDestroy(): void {
    this.userSubject.unsubscribe();
  }

  setUser(user: any) {
    this.userSubject.next(user);
  }
  getUser() {
    this.userSubject.subscribe(newUser =>{
      this.user = newUser;
    });
    return this.user;
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
      if (userData.workouts.length > 0 && userData.workouts.length <= 3)
        activity_factor = 1.375;
      else if (userData.workouts.length > 3 && userData.workouts.length <= 5)
        activity_factor = 1.55;
      else if (userData.workouts.length > 5 && userData.workouts.length <= 7)
        activity_factor = 1.725;
      else if (userData.workouts.length > 7)
        activity_factor = 1.9;
      // calorie calculation
    })
    return this.userCalorie = BMR * activity_factor;
  }

  getBasicAuthHeader(email: string, password: string): string {
    const credentials = email + ':' + password;
    const encodedCredentials = btoa(credentials); // Base64 encode the credentials
    return 'Basic ' + encodedCredentials;
  }
  


}
