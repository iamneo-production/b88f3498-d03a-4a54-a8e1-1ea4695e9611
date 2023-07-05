import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() {   }
  userAuthenticated: boolean = false;
  isUserAuthenticatedSubject = new BehaviorSubject(this.userAuthenticated);
  setAuthentication(logged: boolean) {
    this.isUserAuthenticatedSubject.next(logged);
  }
}
