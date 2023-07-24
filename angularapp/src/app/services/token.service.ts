import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  setToken(token: any) {
    localStorage.setItem('token', token);
  }
  getToken() {
    return localStorage.getItem('token');
  }
  clearToken() {
    localStorage.removeItem('token');
  }

  getHeader() {
    const requestOptions = {
      headers: new HttpHeaders({
        "Content-Type": "application/json",
        'Authorization': `Bearer ${this.getToken()}`
      }),
    };
    return requestOptions;
  }
}
