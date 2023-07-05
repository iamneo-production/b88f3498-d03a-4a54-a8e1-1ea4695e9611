import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private workService: WorksdataService, private router: Router) { }

  ngOnInit() {
    this.refreshTodos()
  }

  refreshTodos(){
    this.workService.retrieveAllTodos('in28minutes').subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    )
  }
  deleteTodo(id: any){
    console.log(`delete todo ${id}`);
    this.workService.deleteTodo('in28minutes',id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete of Exercise ${id} is Successful`;
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

