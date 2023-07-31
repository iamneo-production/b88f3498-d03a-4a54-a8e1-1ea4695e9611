import { Component, OnInit } from '@angular/core';
import { Works } from '../listworks/listworks.component';
import { ActivatedRoute, Router } from '@angular/router';
import { WorksdataService } from 'src/app/services/worksdata.service';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-works',
  templateUrl: './works.component.html',
  styleUrls: ['./works.component.scss']
})
export class WorksComponent implements OnInit {

  id! : number;
  todo!: Works;
  userEmail!:string;
  constructor(private workService: WorksdataService, private route: ActivatedRoute, private router: Router, private userService:UserService){
    userService.userSubject.subscribe(user =>{
      this.userEmail = user.email;
      this.id = user.id;
    })
  }

  ngOnInit(){
    this.id = this.route.snapshot.params['id'];
    this.todo = new Works(this.id,'',false, new Date())
    if(this.id!=-1){
      this.workService.retrieveTodo(this.userEmail, this.id)
      .subscribe(
        data => this.todo = data
      )
    }
    
  }

  saveTodo(){
    if(this.id === -1){
      this.workService.createTodo(this.userEmail, this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['exertracking/workoutstracking']);
        }
      )
    }
    else{
      this.workService.updateTodo(this.userEmail, this.id, this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['exertracking/workoutstracking']);
        }
      )
    }
    
  }
  
}

