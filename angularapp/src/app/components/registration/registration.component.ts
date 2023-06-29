import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { FormValidationService } from 'app/services/form-validation.service';
import { UserService } from 'app/services/user.service';
import { TitleService } from '../../services/title.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {
  constructor(private formValiadtionService: FormValidationService,private userService: UserService, private router: Router, private title: TitleService, private http: HttpClient) {
    console.log(this.user);
    this.title.setTitle("Register");
  }
  user:object= {};
  myform: FormGroup = this.formValiadtionService.myform;
 ngOnInit(){
 
 }
  // to navigate to Login Page
  goToLogin() {
    this.router.navigate(['login'])
    
  }

  // to send data to backend
  onSubmit() {
    this.user = this.myform.value;  
    console.log(this.myform);
    if(this.myform.valid){
      this.http.post('http://localhost:8080/user/register', this.user).subscribe(response => {
        console.log(response);
      });
      this.router.navigate(['login']);
    }
  }
}
