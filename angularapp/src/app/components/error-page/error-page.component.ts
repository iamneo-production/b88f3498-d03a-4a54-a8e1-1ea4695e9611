import { Component } from '@angular/core';
<<<<<<< HEAD
import { TitleService } from '../../services/title.service';
=======
import { TitleService } from 'src/app/services/title.service';
>>>>>>> a978b8f9bbbe58a909423e450545f778df239390

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
