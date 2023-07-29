import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Works } from '../components/listworks/listworks.component';
import { UserService } from './user.service';
import { TokenService } from './token.service';
@Injectable({
  providedIn: 'root'
})
export class WorksdataService {
  url:string = this.userService.baseUrl;
  userEmail!:string;
  id!: number;
  

  constructor(
    private http:HttpClient, 
    private userService: UserService,
    private tokenService: TokenService
  ){ 
    this.userService.userSubject.subscribe(user =>{
      this.userEmail = user.email;     
      this.id = user.id;
    });
   }
  
  retrieveAllTodos(userEmail:any){
    return this.http.get<Works[]>(`${this.url}/users/${userEmail}/todos`,this.tokenService.getHeader());
    // console.log("Execute Hello World Bean Service  .")
  }

  deleteTodo(userEmail: any,id: any){
   
    return this.http.delete(`${this.url}/users/${userEmail}/todos/${id}`,this.tokenService.getHeader());
  }

  retrieveTodo(userEmail: any,id: any){
    return this.http.get<Works>(`${this.url}/users/${userEmail}/todos/${id}`,this.tokenService.getHeader());
  }

  updateTodo(userEmail: any,id: any, todo: any){
    return this.http.put(`${this.url}/users/${userEmail}/todos/${id}`, todo,this.tokenService.getHeader());
  }

  createTodo(userEmail: any, todo: any){
    console.log(this.userEmail);
    return this.http.post(`${this.url}/users/${userEmail}/todos`, todo,this.tokenService.getHeader());
  }
}

