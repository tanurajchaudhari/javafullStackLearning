import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../../../service/quiz';
import Swal from 'sweetalert2';
import { Material_Imports } from '../../../importMaterial';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-instructions',
  imports: [
    Material_Imports,
    FormsModule,
    CommonModule
  ],
  templateUrl: './instructions.html',
  styleUrl: './instructions.css',
})
export class Instructions implements OnInit{
  qid:number=-1;
  //quiz!:any;
  quiz={
    title:'',
    description:'',
    maxmarks:0,
    numberOfQuestions:0,
    active:'',
    category:{
      cid:''
    }
  }

 constructor(private _router:Router, private _route : ActivatedRoute,private _quiz:Quiz,private cdr:ChangeDetectorRef){}

  ngOnInit(): void {
      this.qid= this._route.snapshot.params['qid'];
      console.log(this.qid);

      this._quiz.getQuiz(this.qid).subscribe(
          (data:any)=>{
            console.log(data)
            this.quiz=data;
            // this.cdr.detectChanges()
            
          },
          (error)=>{
            console.log(error)
            Swal.fire("Error!!","Error in loading data","error")
          }
      )
  
  }
  startQuiz(){
    Swal.fire({
      title:'Do you want to start the quiz??',
      // showDenyButton:true,
      showCancelButton:true,
      confirmButtonText:`start`,
      // denyButtonText:`dont start`,
      icon:'info'
    }).then((result)=>{
      if(result.isConfirmed){
        this._router.navigate(['/start/'+this.qid]);
      }
      else if(result.isDenied){
        Swal.fire('Changes are not save','','info')
      }
    })
  }

}
