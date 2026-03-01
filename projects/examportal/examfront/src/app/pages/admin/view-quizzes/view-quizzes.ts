import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { Quiz } from '../../../service/quiz';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quizzes',
  imports: [
    Material_Imports,
    CommonModule,
  ],
  templateUrl: './view-quizzes.html',
  styleUrl: './view-quizzes.css',
})
export class ViewQuizzes implements OnInit {


  quizzes: any = []

  constructor(private _quiz: Quiz, private cdr: ChangeDetectorRef,) { }

  ngOnInit(): void {
    this._quiz.quizzes().subscribe(
      (data: any) => {
        this.quizzes = data;
        //this.cdr.detectChanges();
        console.log(this.quizzes)
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !', "Error in loading data !", 'error')
      }
    )

  }

  // delet Quiz
  deleteQuiz(qId: number) {
    Swal.fire(
      {
        icon: 'warning',
        title: 'Are you sure? want to delete?',
        confirmButtonText: 'Delete',
        showCancelButton: true,

      }
    ).then((result) => {
      if (result.isConfirmed) {
        //delete the quiz
        this._quiz.deleteQuiz(qId).subscribe(
          (data: any) => {
            this.quizzes = this.quizzes.filter((quiz: any) => quiz.qId != qId);
          //  this.cdr.detectChanges();
            Swal.fire('deleted', 'Quiz Deleted successfully', 'success');
          },
          (error) => {
            Swal.fire('Error !!1', 'Error in deleting Quiz', 'error')
          }
        )

      }
    })
  }
}
