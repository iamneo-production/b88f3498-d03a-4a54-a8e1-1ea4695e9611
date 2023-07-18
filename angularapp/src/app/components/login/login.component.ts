import { HttpClient} from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { TitleService } from '../../services/title.service';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { UserAuthService } from 'src/app/services/user-auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(
    private authService: UserAuthService,
    private formValidationService: FormValidationService,
    private _http: HttpClient,
    private _route: Router,
    private title: TitleService,
    private userService: UserService
    ) { this.title.setTitle("Login"); }

  id!: number;
  imageBlob: Blob | undefined;
  loginError!: string;
  loggedIn: boolean = false;
  myform: FormGroup = this.formValidationService.myform;
  user = { email: '', password: '' };

  OnLoginSubmit() {
    this.user.email = this.myform.value.email;
    this.user.password = this.myform.value.password;


    this._http.post(`${this.userService.baseUrl}/user/login`, this.user).subscribe(loggedUser=>{
      if(loggedUser!=null){
        console.log(loggedUser);
        this.authService.setAuthentication(true);
        this.userService.setUser(loggedUser);
        this._route.navigate(['home']);
      }
    },
    error =>{
      this.loginError = "Wrong Email or Password!!!"
      console.log(error);   
    });
  }
  sendToRegisterPage() {
    this._route.navigate(['register']);
  }
}
