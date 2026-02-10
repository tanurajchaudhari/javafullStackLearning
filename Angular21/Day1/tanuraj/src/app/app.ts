import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Tanu } from './tanu/tanu';
import { Rohit } from './rohit/rohit';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Tanu,Rohit,CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('tanuraj');

  admin="Aadiandjava"
  isloggedIn=false
   age=2
  name="My name is Tanuraj";
  user={
    id:101,
    name:"Tanuraj",
    profession:"Tech",
    adresses:["Pune","Haveli","sortapwadi"]
  }
  employees=[
    {id:1,name:"Tanuraj",age:23,email:"tanuraj169179@gmail.com"},

     {id:2,name:"Bhushan",age:25,email:"bhushan@gmail.com"},

     {id:3,name:"rushi",age:27,email:"rushi@gmail.com"},
      {id:4,name:"jaydeep",age:26,email:"munna@gmail.com"},
  ]

  

    


}
