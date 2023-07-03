import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TitleService } from '../../services/title.service';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { UserService } from 'src/app/services/user.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {
  constructor(private formValiadtionService: FormValidationService, private router: Router, private title: TitleService, private http: HttpClient, private userService: UserService) {
    console.log(this.user);
    this.title.setTitle("Register");
  }
  user:object= {};
  myform: FormGroup = this.formValiadtionService.myform;

  // to navigate to Login Page
  goToLogin() {
    this.router.navigate(['login'])
    
  }

  // to send data to backend
  onSubmit() {
    this.user = this.myform.value;  
    console.log("form:", this.myform.value);
    if(this.myform.valid){
      let regUser = this.registerUser(this.user);
      regUser.subscribe(dbUser=>{this.user = dbUser});
      this.router.navigate(['login']);
    }
  }

  registerUser(user: any){
    return this.http.post(`${this.userService.baseUrl}/user/register`, this.user);
  }
}
