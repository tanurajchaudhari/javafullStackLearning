import { Component } from '@angular/core';

@Component({
  selector: 'app-tanu',
  imports: [],
  templateUrl: './tanu.html',
  styleUrl: './tanu.css',
})
export class Tanu {

imgURL="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFot8lrohYGLn8QyQZBsQW3fnW0-ljFVMf_TxiOsd4oTt0kgtUgErclDCWkT4qjqVRhOLaYLLepOFiaGbv-9JLeUM_BIq0wskw2Qe3jHd8fQ&s=10"
color="Red"
bgcolor="black"
  KeyUp(value:any){
    console.log(value)
  }
  KeyDown(value:any){
    console.log(value)
  }

}
