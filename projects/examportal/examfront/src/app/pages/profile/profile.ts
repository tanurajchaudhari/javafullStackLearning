import { Component, OnInit } from '@angular/core';
import { Material_Imports } from '../../importMaterial';
import { LoginService } from '../../service/login-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  imports: [
    CommonModule,
    Material_Imports
  ],
  templateUrl: './profile.html',
  styleUrl: './profile.css',
})
export class Profile implements OnInit {
  user:any=null;
  constructor(private login: LoginService){

  }
  ngOnInit(): void {
    //get data from localStorage
    this.user=this.login.getUser();
    
    // get data from server
  //  this.login.getCurrentUser().subscribe(
  //   (user:any)=>{
  //     this.user=user;
  //   },
  //   (error)=>{
  //     alert("error");

  //   }
  //  )
    console.log(this.user);
  }

}
