import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormValidationService {

  constructor() { }

  myform = new FormGroup({
    email : new FormControl('', [Validators.required, Validators.email]),
    username : new FormControl('', [Validators.required, Validators.minLength(3)]),
    password: new FormControl('', [Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/), Validators.minLength(8)]),
    height : new FormControl('', [Validators.required]),
    weight : new FormControl('', [Validators.required]),
    age : new FormControl('', [Validators.required]),
    gender : new FormControl(''),
   })

}
