import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { email } from '@angular/forms/signals';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {

  user={
    name:"",
    email:"",
    password:"",
    mobileNo:"",
    gender:"",
    city:""
  }

  userData :any
  
  onSubmit(formdata:any){
    alert("user register succesffully")
    console.log(formdata)
    this.userData=formdata
  }
}
