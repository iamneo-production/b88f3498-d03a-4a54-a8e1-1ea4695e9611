import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';

import { TitleService } from 'src/app/services/title.service';
import { UserService } from 'src/app/services/user.service';
import { WorksdataService } from 'src/app/services/worksdata.service';

export class Works {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ){

  }
}
@Component({
  selector: 'app-listworks',
  templateUrl: './listworks.component.html',
  styleUrls: ['./listworks.component.scss']
})
export class ListworksComponent implements OnInit {

  todos : Works[] | undefined
  message!: string;
  userEmail!:string;
  // id!:number;

  constructor(private workService: WorksdataService, private router: Router, private userService: UserService, private titleService:TitleService) {
    this.titleService.setTitle("Exercise Tracker");
this.userService.userSubject.subscribe(user=>{
  this.userEmail= user.email;
  // this.id = user.id;
})
   }

  ngOnInit() {
    this.refreshTodos()
  }

  async refreshTodos(){
    let response:any = await lastValueFrom(this.workService.retrieveAllTodos(this.userEmail));
    this.todos =  response;
    
  }
  deleteTodo(id: any){
    console.log(`delete todo ${id}`);
    this.workService.deleteTodo(this.userEmail,id).subscribe(
      response => {
        // this.message = `Delete of Exercise ${id} is Successful`;
        this.refreshTodos();
      }
      )
  }
  updateTodo(id:any){
    console.log (`update ${id}`);
    this.router.navigate(['exertracking/workoutstracking',id]);
  }

  addTodo(){
    this.router.navigate(['exertracking/workoutstracking',-1]);
  }
}

