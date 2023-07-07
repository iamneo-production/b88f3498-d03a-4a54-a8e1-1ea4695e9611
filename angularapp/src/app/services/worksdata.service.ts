import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Works } from '../components/listworks/listworks.component';
import { UserService } from './user.service';
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
  ){ 
    this.userService.userSubject.subscribe(user =>{
      this.userEmail = user.email;
      this.id = user.id;
    });
   }
  
  retrieveAllTodos(userEmail:any){
    return this.http.get<Works[]>(`${this.url}/users/${userEmail}/todos`);
    // console.log("Execute Hello World Bean Service  .")
  }

  deleteTodo(userEmail: any,id: any){
    return this.http.delete(`${this.url}/users/${userEmail}/todos/${id}`);
  }

  retrieveTodo(userEmail: any,id: any){
    return this.http.get<Works>(`${this.url}/users/${userEmail}/todos/${id}`);
  }

  updateTodo(userEmail: any,id: any, todo: any){
    return this.http.put(`${this.url}/users/${userEmail}/todos/${id}`, todo);
  }

  createTodo(userEmail: any, todo: any){
    return this.http.post(`${this.url}/users/${userEmail}/todos`, todo);
  }
}

