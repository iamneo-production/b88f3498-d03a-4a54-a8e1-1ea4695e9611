import { Component, OnInit } from '@angular/core';
import { Works } from '../listworks/listworks.component';
import { ActivatedRoute, Router } from '@angular/router';
import { WorksdataService } from 'src/app/services/worksdata.service';
@Component({
  selector: 'app-works',
  templateUrl: './works.component.html',
  styleUrls: ['./works.component.scss']
})
export class WorksComponent implements OnInit {

  id! : number;
  todo!: Works;
  constructor(private workService: WorksdataService, private route: ActivatedRoute, private router: Router){}

  ngOnInit(){
    this.id = this.route.snapshot.params['id'];
    this.todo = new Works(this.id,'',false, new Date())
    if(this.id!=-1){
      this.workService.retrieveTodo('in28minutes', this.id)
      .subscribe(
        data => this.todo = data
      )
    }
    
  }

  saveTodo(){
    if(this.id === -1){
      this.workService.createTodo('in28minutes', this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['exertracking/workoutstracking']);
        }
      )
    }
    else{
      this.workService.updateTodo('in28minutes', this.id, this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['exertracking/workoutstracking']);
        }
      )
    }
    
  }
  
}

