import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Question } from '../../../service/question';
import { ActivatedRoute, Route, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-question',
  imports: [
    Material_Imports,
        CommonModule,
        MatSelectModule,
        FormsModule
  ],
  templateUrl: './update-question.html',
  styleUrl: './update-question.css',
})
export class UpdateQuestion implements OnInit {

  questId:any;
  qId:any;
  quizTitle:any;
  question:any={
        content:'',
        option1:'',
        option2:'',
        option3:'',
        option4:'',
        answer:'',
        quiz:{
          qId:''
        }
  }

 constructor(
  private _question:Question,private _route:ActivatedRoute,
  private cdr:ChangeDetectorRef,private _router:Router,){}

  ngOnInit(): void {
    this.questId=this._route.snapshot.params['questId']
   this.qId= this._route.snapshot.params['qId']

    this._question.getSingleQuestion(this.questId).subscribe(
      (data:any)=>{
        this.question=data
        console.log(this.question)
        console.log("this is quiz id ",this.question.quiz.qId)
        console.log("this is quiz id ",this.question.quiz.title)
        // this.cdr.detectChanges()


      },
      (error)=>{
        Swal.fire('Error!!','Error while fetching data','error')
        console.log(error)
      }

    )

  }

  formSubmit(){
     this._question.updateQuestion(this.question).subscribe(
      (data)=>{
        Swal.fire('Updated','Question updated succesfully','success').then(
          (e)=>{
            this._router.navigate(['/admin/view-questions',this.question.quiz.qId,this.question.quiz.title])

          }
        )
      },
      (error)=>{
        Swal.fire('Error!!!','Error in updating question','error')
        console.log(error)
      }
     )
  }

}
