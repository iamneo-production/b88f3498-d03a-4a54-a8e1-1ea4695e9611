import { Component, OnInit } from '@angular/core';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss']
})
export class ContainerComponent {
  title = 'admin-panel-layout';
  sideBarOpen = true;
  isAuthenticated:boolean=false;

  constructor(private authService: UserAuthService){
    authService.isUserAuthenticatedSubject.subscribe(
    {
      next: (isValid:boolean)=>{this.isAuthenticated = isValid;}
    }
    )
  }

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }
}