import { HttpClient } from '@angular/common/http';
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

  async OnLoginSubmit() {
    this.user.email = this.myform.value.email;
    this.user.password = this.myform.value.password;

    try {
      var response:any;
      this._http.post("https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io/user/login", this.user).subscribe((res:any)=>{
        response = res;
        }

      );

      if (response.message === "Login Successful") {
        // Creating image blob
        const img: string = "assets/icon/user.png";
        this.imageBlob = await this._http.get(img, { responseType: 'blob' }).toPromise();

        // Use ID
        this.setUsertoUserService();
      }
    } catch (error: any) {
      console.log(error);
      this.loginError = "Invalid Email or password";
    }
  }

  // Check user based on their ID
  async setUsertoUserService() {
    try {
      const response: any = await this._http.get("https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io/users").toPromise();

      for (const loginUser of response as any[]) {
        if (loginUser.email == this.user.email) {
          this.loggedIn = true;
          this.id = loginUser.id;

          // Setting authentication to true when user logs in
          this.authService.setAuthentication(this.loggedIn);

          // Giving all details of logged user in userService
          this.userService.setUser(loginUser);

          // Set default dp
          if (loginUser.content == null) {
            const formData: FormData = new FormData();
            if (this.imageBlob) {
              formData.append('file', this.imageBlob);
              const updatedUser: any = await this._http.put(`https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io/update/${this.id}`, formData, loginUser).toPromise();
              this.userService.setUser(updatedUser);
              console.log("updatedUser:", updatedUser);
            } else {
              console.log("Image blob is undefined");
            }
          }

          this._route.navigate(['home']); // User login successful
        }
      }
    } catch (error: any) {
      console.log(error);
    }
  }

  sendToRegisterPage() {
    this._route.navigate(['']);
  }
}
