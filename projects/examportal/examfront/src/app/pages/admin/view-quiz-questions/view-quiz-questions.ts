import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Question } from '../../../service/question';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-view-quiz-questions',
  imports: [
    Material_Imports,
    CommonModule,
    MatCardModule,
  ],
  templateUrl: './view-quiz-questions.html',
  styleUrl: './view-quiz-questions.css',
})
export class ViewQuizQuestions implements OnInit{

  qId:number=-1;
  qTitle:string='';
  questions:any[]=[];
  constructor(private _route:ActivatedRoute,private _snack:MatSnackBar,private _question:Question,private cdr:ChangeDetectorRef){

  }


  ngOnInit(): void {
     this.qId=  this._route.snapshot.params['qid']
     this.qTitle=this._route.snapshot.params['title']
     this._question.getQuestionsOfQuiz(this.qId).subscribe(
      (data:any)=>{
        this.questions=data;
       // this.cdr.detectChanges();
        console.log(this.questions)
      },
      (error: any)=>{
        console.log(error)
      }
     )

  }

  //delete question
  deleteQuestion(quesId:any){
    
     Swal.fire(
          {
            icon: 'warning',
            title: 'Are you sure? want to delete?',
            confirmButtonText: 'Delete',
            showCancelButton: true,
    
          }
        ).then((result)=>{
                if(result.isConfirmed){
                  this._question.deleteQuestion(quesId).subscribe(
                    (data:any)=>{
                      this._snack.open('Question deleted','',{
                        duration:3000
                      });
                      this.questions=this.questions.filter((q)=>q.quesId!=quesId)
                        //  this.cdr.detectChanges();
                    },
                    (error)=>{
                        this._snack.open('error in deleteing question','',{
                          duration:3000
                        })
                        console.log(error)
                    }
                  )
                }
        })

  }

}
