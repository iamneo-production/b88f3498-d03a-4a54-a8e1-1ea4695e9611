import { Component } from '@angular/core';
import { TitleService } from 'src/app/services/title.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-error-page',
  templateUrl: './error-page.component.html',
  styleUrls: ['./error-page.component.scss']
})
export class ErrorPageComponent {
  constructor(private titleServices:TitleService , private _route: Router,){
    titleServices.setTitle("Error Page")
  }

  goToLogin() {
    this._route.navigate(['login']);
  }

  goToRegister() {
    this._route.navigate(['register']);
  }
}
