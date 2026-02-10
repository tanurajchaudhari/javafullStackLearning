import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule,CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})

export class Login {
 username=''
 password=''

  constructor(private userService:User,private router:Router){
    
  }
  login(){
     this.userService.loginUser(this.username,this.password).subscribe(data=>{
           
     
            console.log(this.username);
            console.log(this.password);
            console.log(data);
            this.router.navigate(['/employees'])
       


     })
  }

}
