import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TitleService } from '../../services/title.service';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { UserService } from 'src/app/services/user.service';


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
      this.http.post('https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io/user/register', this.user).subscribe(response => {
        console.log(response);
      });
      this.router.navigate(['login']);
    }
  }
}
