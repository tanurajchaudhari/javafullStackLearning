import { ChangeDetectorRef, Component } from '@angular/core';
import { User } from '../user';
import { Employee } from '../employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empdetails',
  imports: [],
  templateUrl: './empdetails.html',
  styleUrl: './empdetails.css',
})
export class Empdetails {
   constructor(private userService: User,private cdr:ChangeDetectorRef, private router:Router){

    this.getAllEmployees();

  }
  employees:Employee[]=[];
   getAllEmployees(){
    this.userService.getAllEmp().subscribe((data:any)=>{
      this.employees=data;
      this.cdr.detectChanges();
    });
  }

  edit(id:number){
    console.log("edit called")
    this.router.navigate(['/edit-page/',id]);

  }
  delete(id:number){

  }

}
