import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Works } from '../components/listworks/listworks.component';
@Injectable({
  providedIn: 'root'
})
export class WorksdataService {

  constructor(
    private http:HttpClient
  ){  }
  
  retrieveAllTodos(username:any){
    return this.http.get<Works[]>(`https://8080-fcdeefeecdaaaccdcddcffebdffccbebc.project.examly.io/users/${username}/todos`);
    // console.log("Execute Hello World Bean Service  .")
  }

  deleteTodo(username: any,id: any){
    return this.http.delete(`https://8080-fcdeefeecdaaaccdcddcffebdffccbebc.project.examly.io/users/${username}/todos/${id}`);
  }

  retrieveTodo(username: any,id: any){
    return this.http.get<Works>(`https://8080-fcdeefeecdaaaccdcddcffebdffccbebc.project.examly.io/users/${username}/todos/${id}`);
  }

  updateTodo(username: any,id: any, todo: any){
    return this.http.put(`https://8080-fcdeefeecdaaaccdcddcffebdffccbebc.project.examly.io/users/${username}/todos/${id}`, todo);
  }

  createTodo(username: any, todo: any){
    return this.http.post(`https://8080-fcdeefeecdaaaccdcddcffebdffccbebc.project.examly.io/users/${username}/todos`, todo);
  }
}

