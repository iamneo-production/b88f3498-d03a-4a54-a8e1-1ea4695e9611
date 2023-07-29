import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { FormValidationService } from 'src/app/services/form-validation.service';
import { UserAuthService } from 'src/app/services/user-auth.service';
import { TitleService } from '../../services/title.service';
import { UserService } from 'src/app/services/user.service';
import { TokenService } from 'src/app/services/token.service';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(
    private userService: UserService,
    private formValidationService: FormValidationService,
    private _http: HttpClient,
    private _route: Router,
    private title: TitleService,
    private userAuthService: UserAuthService,
    private tokenService: TokenService

  ) { this.title.setTitle("Login"); }

  id!: number;
  // imageBlob: Blob | undefined;
  loginError!: any;
  loggedIn: boolean = false;
  myform: FormGroup = this.formValidationService.myform;
  user = { email: '', password: '' };

  OnLoginSubmit() {
    this.user.email = this.myform.value.email;
    this.user.password = this.myform.value.password;

    this.loginError = this.userAuthService.login(this.user.email, this.user.password);
    
    console.log(this.loginError);

  }
  

  

  sendToRegisterPage() {
    this._route.navigate(['register']);
  }


  getUserByEmail(email: string) {
    return this._http.get(`${this.userService.baseUrl}/user/${this.user.email}`, this.tokenService.getHeader())
  }

}

