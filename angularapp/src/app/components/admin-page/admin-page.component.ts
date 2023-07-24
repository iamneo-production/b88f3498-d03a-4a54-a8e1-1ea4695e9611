import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TitleService } from 'src/app/services/title.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent {

  users!:any;
  constructor(private http:HttpClient,private titleService: TitleService,private userService: UserService){
    titleService.setTitle("Admin Page");
    this.users = http.get(`${this.userService.baseUrl}/user`);
  }
  
  
}
