import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Material_Imports } from '../../importMaterial';
import { CommonModule } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from '../../service/login-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    CommonModule,
    Material_Imports,
   
  ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  constructor(private snack:MatSnackBar,private login:LoginService,private router:Router){

  }

  loginData={
    username:'',
    password:'',
  }


  formSubmit(){
    console.log("login button clicked ")
    //for username check
    if (this.loginData.username.trim()=='' || this.loginData.username==null){
              this.snack.open('Username is required !!','',{
                duration:3000,
              });
              return;
    }

    //for password check

    if (this.loginData.password.trim()=='' || this.loginData.password==null){
              this.snack.open('password is required !!','',{
                duration:3000,
              });
              return;
    }

    //request to server to generate token
  this.login.generateToken(this.loginData).subscribe(
    (data:any)=>{
      console.log("success");
      console.log(data);

      //login...
      this.login.loginUser(data.token);
      this.login.getCurrentUser().subscribe(
        (user:any)=>{
        this.login.setUser(user);
        console.log(user);
        //redirect  ... ADMIN :admin dashboard
        //redirect  ...NORMAL:normal-dashboard
        if(this.login.getUserRole()=="Admin"){
          //Admin-dashboard
          // window.location.href="/admin";
          this.router.navigate(['admin'])
          this.login.loginStatusSubject.next(true);
        }else if(this.login.getUserRole()=="Normal"){
          //user-dashboard
          // window.location.href="/user";
          this.router.navigate(['user'])
          this.login.loginStatusSubject.next(true);

        }else{
          this.login.logout();
        }

      });

    },
    (error:any)=>{
      console.log("Error !!!");
      console.log(error);
      this.snack.open("Invalid credentials !! Try again",'',{
        duration:3000,
      })
    }
  )
    
  }

}
