import { Component } from '@angular/core';
import { TitleService } from 'app/services/title.service';

@Component({
  selector: 'app-error-page',
  templateUrl: './error-page.component.html',
  styleUrls: ['./error-page.component.scss']
})
export class ErrorPageComponent {
  constructor(private titleServices:TitleService){
    titleServices.setTitle("Error Page")
  }

}
