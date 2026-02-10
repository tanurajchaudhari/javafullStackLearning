import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../user';
import { CommonModule } from '@angular/common';
import { Employee } from '../employee';

@Component({
  selector: 'app-register',
  imports: [FormsModule,CommonModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  constructor(private userService: User,private cdr:ChangeDetectorRef){


  }
  showPopup=false;
  serverError:any={};
  

 

  register(employee:any){
    console.log(employee)
    this.serverError={};
     this.userService.saveEmployee(employee) .subscribe({
    next: (data: any) => {
      console.log(data);
      this.showPopup = true;
      this.cdr.detectChanges();
      setTimeout(() => {
        this.showPopup = false;
        this.cdr.detectChanges();
      }, 2000);
    },
    error: (err) => {
      console.error("API ERROR ", err);
      if (err.status === 400) {
        this.serverError = err.error;
        this.cdr.detectChanges();
      }
    }
 });
    
  }
}
