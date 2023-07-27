import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TitleService } from 'src/app/services/title.service';
import { TokenService } from 'src/app/services/token.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent {

  users!: any;
  header!: any;
  role!:string;

  constructor(private http: HttpClient, private titleService: TitleService, private userService: UserService, private tokenService: TokenService, private snackBar: MatSnackBar) {
    titleService.setTitle("Admin Page");
    userService.userSubject.subscribe({
      next: (currUser:any)=>{
        this.role = currUser.role;
      }
    })
    this.header = this.tokenService.getHeader();
    console.log("heD: ", this.tokenService.getToken());

    this.getAllUser();
  }
  getAllUser() {
    this.http.get(`${this.userService.baseUrl}/user`, { headers: { "Authorization": "Bearer " + this.tokenService.getToken() } }).subscribe({
      next: (usersData: any) => {
        this.users = usersData;
      }
    });
  }



  activateUser(email: string, currStatus: boolean) {
    let changeStatusTo = !currStatus;
    this.http.put(`${this.userService.baseUrl}/admin/status/${email}/${changeStatusTo}`, {}, { headers: { "Authorization": "Bearer " + this.tokenService.getToken(), "Content-Type": "Application/text" } }).subscribe(error => {

      this.snackBar.open(currStatus? 'Activated':'Deactivated' , '' , {duration: 3000});
      console.log(error);

      this.getAllUser();
    });

  }

  deleteUser(email: string) {
    this.http.delete(`${this.userService.baseUrl}/admin/deleteUser/${email}`, { headers: { "Authorization": "Bearer " + this.tokenService.getToken() }, responseType: "text" }).subscribe(error => {

      this.snackBar.open(`${email} deleted Successfully`, '' , {duration: 3000});
      console.log(error);

      this.getAllUser();
    });

  }


  setNewRole(event:any, email: string) {
    let role = event.target.value;
    this.http.put(`${this.userService.baseUrl}/admin/changeRole/${email}/${role}`, {},  { headers: { "Authorization": "Bearer " + this.tokenService.getToken() }, responseType: "text" }).subscribe(error => {

      this.snackBar.open(`New Role`, `${role}` , {duration: 3000});

      this.getAllUser();
    });

  }


}
