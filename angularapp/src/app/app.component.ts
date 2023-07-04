import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { UserAuthService } from './services/user-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angularapp';
  sideBarOpen = true;
  isAuthenticated:boolean=false;

  constructor(private authService: UserAuthService){
    
    this.authService.isUserAuthenticatedSubject.subscribe(
      {
        next: (isValid:boolean)=>{
          this.isAuthenticated = isValid;
          console.log(this.isAuthenticated);
        }
        
      }
      )
  }



  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }
}
//
