import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { TitleService } from 'src/app/services/title.service';
import { TokenService } from 'src/app/services/token.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user!: any;
  allowEdit = false;
  id!: string;
  message: string = ""
  saved: boolean = false;
  file!: File;
  imageName: string = "assets/icon/user.png";


  constructor(private http: HttpClient, private formValidationService: FormValidationService, private titleService: TitleService, private userService: UserService, private tokenService: TokenService) {
    this.titleService.setTitle("Profile");
    this.userService.userSubject.subscribe(userData => {
      this.user = userData;
    })

  }
  ngOnInit() {
    this.id = this.user.id;
    console.log(this.id);
   

  }


  updateProfileImage(event: any) {
    console.log(this.file);
  }

  enableEdit() {
    this.allowEdit = true;
  }

  UpdateProfile() {
    this.saved = true;
   
    this.http.put(`${this.userService.baseUrl}/user/${this.id}`,  this.user, this.tokenService.getHeader() ).subscribe(updatedUser => {
      this.message = "Profile Updated Successfully!"
      console.log(updatedUser);
      this.userService.setUser(updatedUser);
      this.allowEdit = false;
      setTimeout(() => {
        this.saved = false;
      }, 3000);
    })
  }


}
