import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/services/user-auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  name!:string;
  constructor(private userAuth: UserAuthService, private router: Router, private userService: UserService) {
    this.userService.userSubject.subscribe(user =>{
      this.name = user.name;
    })
  }

  ngOnInit(): void {}

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }
  
  showUserProfile() {
    this.router.navigate(['profile']);
  }
  logout(){
    this.userAuth.setAuthentication(false);
    this.router.navigate(['landingPage']);
  }
}
