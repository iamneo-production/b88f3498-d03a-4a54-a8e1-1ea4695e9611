import { Component } from '@angular/core';
import { TitleService } from 'src/app/services/title.service';

@Component({
  selector: 'app-exercisetracking',
  templateUrl: './exercisetracking.component.html',
  styleUrls: ['./exercisetracking.component.scss']
})
export class ExercisetrackingComponent {
  constructor(private titleService:TitleService){
    this.titleService.setTitle("Exercise Tracking");
  }
}
