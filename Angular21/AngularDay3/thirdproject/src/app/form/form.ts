import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './form.html',
  styleUrl: './form.css',
})
export class Form {
  registerForm: FormGroup;
  // use to validate form at backend
  constructor(fb:FormBuilder){  //use  to validate  form at backend 
    

    this. registerForm= fb.group({
      name:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required,Validators.pattern('^[A-Za-z0-9]{8,}$')]],
    //  gender:['',Validators.required],
      MobileNo:['',[Validators.required,Validators.pattern('^[0-9]{10}$')]]
    })

  }
  onSubmit(){
    if(this.registerForm.invalid){
      return
    }
    console.log(this.registerForm.value)
  }
 

}
