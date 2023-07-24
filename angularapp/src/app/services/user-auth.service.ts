import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, lastValueFrom } from 'rxjs';
import { TokenService } from './token.service';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {
  token!: String;

  constructor(private http: HttpClient, private _route: Router, private userService: UserService, private tokenService: TokenService) {

  }
  userAuthenticated: any = false;
  isUserAuthenticatedSubject = new BehaviorSubject(this.userAuthenticated);
  async setAuthentication(logged: boolean) {
    this.userAuthenticated = logged;
    this.isUserAuthenticatedSubject.next(this.userAuthenticated);
    console.log("user authenticated?=>", this.userAuthenticated);


  }

  login(email: string, password: string) {
    let loginStatus;
    this.http.post(`${this.userService.baseUrl}/login`, { email: email, password: password }, { responseType: 'json' }).subscribe(
      {
        next: (data: any) => {
          if (data != null) {
            console.log(data.token);
            this.tokenService.setToken(data.token);
            this.setAuthentication(true);
            loginStatus = "Login Success";
            this.userService.setUser(this.userService.getCurrentUser())
            this._route.navigate(['home']);
          }
        },
        error: (error: any) => {
          loginStatus = "Wrong Email or Password!!!"
          console.log(error);
        },
      });
    return loginStatus;

  }




}
