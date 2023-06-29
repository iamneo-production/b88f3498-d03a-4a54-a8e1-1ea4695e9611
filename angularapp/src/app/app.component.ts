import { Component } from '@angular/core';
import { UserAuthService } from './services/user-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angularapp';
  userAuthenticated: boolean=false;
  // constructor(private userAuthService: UserAuthService){
  //   userAuthService.isUserAuthenticatedSubject.subscribe(isLogged =>{
  //     next: this.userAuthenticated = isLogged;
  //   })
  // }
}
