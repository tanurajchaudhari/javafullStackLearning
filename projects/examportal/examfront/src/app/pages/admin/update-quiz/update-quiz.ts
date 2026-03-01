import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../../../service/quiz';
import Swal from 'sweetalert2';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { Category } from '../../../service/category';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

@Component({
  selector: 'app-update-quiz',
  imports: [
    Material_Imports,
    CommonModule,
    FormsModule,
    MatSelectModule,
    MatSlideToggleModule

  ],
  templateUrl: './update-quiz.html',
  styleUrl: './update-quiz.css',
})
export class UpdateQuiz implements OnInit {


  constructor(private _route:ActivatedRoute,
    private _quiz:Quiz,private _cat:Category,
    private cdr:ChangeDetectorRef,private _router:Router){}
  
  qId=0;
  //quizData:any={};
  quizData:any = {
  title:'',
  description:'',
  maxmarks:'',
  numberOfQuestions:'',
  active:false,
  category:{
    cid:''
  }
};


  categories:any[]=[];
  ngOnInit(): void {
    this.qId=  this._route.snapshot.params['qid'];
    this._quiz.getQuiz(this.qId).subscribe(
      (data:any)=>{
        this.quizData=data;
        console.log(this.quizData)
      //  this.cdr.detectChanges()

      },
      (error)=>{
        Swal.fire('Error !!','Error while loading quiz data','error');
        console.log(error);
      }
    )
     this._cat.categories().subscribe(
      (data:any)=>{
        this.categories=data
      //  this.cdr.detectChanges()
        console.log(this.categories)
      },
      (error)=>{
        console.log(error)
      }
     )

  }

  //update form submit
  public updateQuiz(){
    //validate
    this._quiz.updateQuiz(this.quizData).subscribe(
      (data:any)=>{
        Swal.fire('Updated','Quiz updated successfully','success').then((e)=>{
          this._router.navigate(['/admin/quizzes']);
        })

      },
      (error)=>{
        Swal.fire('Error','Error in updating Quiz','error')
        console.log(error)

      }
    )
  }

}
