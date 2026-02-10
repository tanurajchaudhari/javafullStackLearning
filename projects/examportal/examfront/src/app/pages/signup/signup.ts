import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { User } from '../../service/user';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import Swal from 'sweetalert2'
import { Material_Imports } from '../../importMaterial';

@Component({
  standalone: true,
  selector: 'app-signup',
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    MatSnackBarModule,
    Material_Imports



  ],
  templateUrl: './signup.html',
  styleUrl: './signup.css',
})
export class Signup {

  constructor(private userService: User, private snack: MatSnackBar) { }
  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',

  }
  formSubmit() {
    console.log("in signup.ts")
    console.log(this.user)
    if (this.user.username == '' || this.user.username == null) {
      //  alert('User is Required !!!');
      this.snack.open("Username is required!!!", "okk", {
        duration: 3000
      })
      return;
    }

    if (this.user.password == '' || this.user.password == null) {
      //  alert('User is Required !!!');
      this.snack.open("password is required!!!", "okk", {
        duration: 3000,

      })
      return;
    }
    //
    this.userService.addUser(this.user).subscribe(
      (data) => {
        //sucess function
        console.log(data)
        // alert("success")
       // Swal.fire('success', 'user is registered ',)
        Swal.fire({
          title: 'success!',
          text: 'user register successfully of id  '+data.id,
          icon: 'success',
          confirmButtonText: 'Cool'
        })
      },
      (error) => {
        //error
        // alert("something went wrong") 
        this.snack.open("Something went wrong...")
      }
    )




  }

}
