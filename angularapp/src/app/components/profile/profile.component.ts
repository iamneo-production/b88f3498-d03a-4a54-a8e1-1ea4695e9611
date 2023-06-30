import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormValidationService } from 'src/app/services/form-validation.service';
import { TitleService } from 'src/app/services/title.service';
import { UserService } from 'src/afpp/services/user.service';

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
  labelGender: string = "Gender"
  file!: File;
  imageName!: string;


  constructor(private http: HttpClient, private formValidationService: FormValidationService, private titleService: TitleService, private userService: UserService) {
    this.titleService.setTitle("Profile");
    this.userService.userSubject.subscribe(userData => {
      this.user = userData;
      if (this.user.imagePath == null) {
        this.user.imagePath = "data:image/png;base64," + userData.content;
      }
    })

  }
  ngOnInit() {
    this.id = this.user.id;
    console.log(this.id);
   

  }


  updateProfileImage(event: any) {
    this.file = event.target.files[0];
    // console.log(event);

    console.log(this.file);
    if (this.file.type.match("image")) {
      const formData: FormData = new FormData();
      formData.append('file', this.file);

      this.http.put(`http://localhost:8080/update/${this.id}`, formData, this.user).subscribe((response: any) => {
        next: console.log("response:", response);
        const type = this.file.type;
        console.log(type);
        try {
          this.user.imagePath = `data:${type};base64,` + response.content;

        } catch (error) {
          console.log(error);

        }
        this.userService.setUser(this.user);
      })

    }

  }

  enableEdit() {
    this.allowEdit = true;
    this.labelGender = "Select Gender";
  }

  UpdateProfile() {
    this.saved = true;

    this.http.put(`http://localhost:8080/users/${this.id}`, this.user).subscribe(response => {
      this.message = "Profile Updated Successfully!"
      this.allowEdit = false;
      setTimeout(() => {
        this.saved = false;
        this.labelGender = "Gender";
      }, 3000);
    })
  }

  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }



}
