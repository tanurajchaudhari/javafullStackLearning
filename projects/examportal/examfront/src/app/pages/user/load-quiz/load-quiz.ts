import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Quiz } from '../../../service/quiz';
import { Material_Imports } from '../../../importMaterial';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-load-quiz',
  imports: [
    Material_Imports,
    FormsModule,CommonModule,
    MatCardModule
  ],
  templateUrl: './load-quiz.html',
  styleUrl: './load-quiz.css',
})
export class LoadQuiz implements OnInit{
 catId:number=0;
 quizzes:any[]=[];
  constructor(private _route:ActivatedRoute, private _quiz: Quiz,private cdr:ChangeDetectorRef){}
  ngOnInit(): void {
 
   
  //  this.catId= + this._route.snapshot.params['catId'];
  //  console.log(this.catId)


   this._route.params.subscribe((params)=>{
    console.log(params)
    this.catId= + this._route.snapshot.params['catId'];
    if(this.catId==0){
      console.log("Load All the quiz")
      this._quiz.getActiveQuizzes().subscribe(
        (data:any)=>{
          this.quizzes=data;
        //  this.cdr.detectChanges()
         console.log(data)
          
        },
        (error:any)=>{
          alert("alert : error in fetching quizzess")
          console.log(error)
        }
      )

    }else{
      console.log("load specific quiz")
      this._quiz.getActiveQuizzesOfCategory(this.catId).subscribe({
       next: (data:any)=>{
          this.quizzes=data;
          // this.cdr.detectChanges()
        },
        error: (error)=>{
          alert("Errorin loading data")
          console.log(error);
        }
    })
    }
   })


    
  }

}
