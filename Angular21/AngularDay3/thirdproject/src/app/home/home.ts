import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
   username="Tanuraj"
    msg=""
    age=0
    gm=""
    getValue(value:string){

      console.log(value)
      this.gm=value

    }

    getAge(age:number){
      this.age=age

    }
   fun(message: string){
           console.log("Fun function is callled...")
           
          this. msg=message
          console.log(message)

  }



























}
