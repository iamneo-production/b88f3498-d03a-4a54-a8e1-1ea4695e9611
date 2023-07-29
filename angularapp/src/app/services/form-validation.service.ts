import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormValidationService {

  myform = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@.$!%*?&])[A-Za-z\d@.$!%*?&]+$/), Validators.minLength(8)]),
    height: new FormControl('', [Validators.required]),
    weight: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    goals: new FormControl('', [Validators.required]),
    role: new FormControl("USER", [Validators.required]),
  })

}
