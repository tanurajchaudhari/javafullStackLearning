import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Material_Imports } from '../../importMaterial';
import { LoginService } from '../../service/login-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  imports: [
    // MatToolbarModule,
    // MatIconModule,
    Material_Imports,
    CommonModule

    
  ],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar implements OnInit{
  isLoggedIn=false;
  user=null;
  constructor(public login:LoginService){

  }
  ngOnInit(): void {
    this.isLoggedIn=this.login.isLoggedIn();
    this.user=this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data)=>{
      this.isLoggedIn=this.login.isLoggedIn();
      this.user=this.login.getUser();
    })
  }
  
  public logout(){
    this.login.logout();
    
    window.location.reload();
  }

}
