import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { UserService } from 'src/app/services/user.service';
import { TitleService } from '../../services/title.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {
  constructor(private formValiadtionService: FormValidationService,
    private router: Router,
    private title: TitleService,
    private http: HttpClient,
    private userService: UserService) {
    console.log(this.user);
    this.title.setTitle("Register");
  }
  user: object = {};
  timoutId: any = null;
  myform: FormGroup = this.formValiadtionService.myform;
  server_side_validation_errors: String[] = []
  // to navigate to Login Page
  goToLogin() {
    this.router.navigate(['login'])

  }



  // to send data to backend
  onSubmit() {
    this.user = this.myform.value;
    console.log("form:", this.myform.value);
    if (this.myform.valid) {
      let regUser = this.registerUser(this.user);

      regUser.subscribe({
        next: dbUser => {
          console.log(dbUser);

          this.user = dbUser;
          this.router.navigate(['login']);
        },
        error: (error: any) => {
          this.showError(error);
        }



      });
    }
  }
  showError(error: any) {
    if (this.timoutId != null) {
      clearTimeout(this.timoutId);
      this.server_side_validation_errors = [];
    }
    error.error.errors.forEach((message: any) => {
      console.log(message.defaultMessage);
      this.server_side_validation_errors.push(message.defaultMessage);
      this.timoutId = setTimeout(() => {
        this.server_side_validation_errors = [];
      }, 5000);


    });

  }

  registerUser(user: any) {
    return this.http.post(`${this.userService.baseUrl}/register`, this.user);
  }
}
