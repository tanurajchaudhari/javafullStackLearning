import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Material_Imports } from '../../../importMaterial';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { Category } from '../../../service/category';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Quiz } from '../../../service/quiz';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-quiz',
  imports: [
    Material_Imports,
    MatSlideToggleModule,
    MatSelectModule,
    CommonModule,
    FormsModule


  ],
  templateUrl: './add-quiz.html',
  styleUrl: './add-quiz.css',
})
export class AddQuiz implements OnInit {

  categories: any[] = [];
  quizData = {
    title: '',
    description: '',
    maxmarks: '',
    numberOfQuestions: '',
    active: true,
    category: {
      cid: ''
    }
  }
  constructor(private _cat: Category, private _snack: MatSnackBar, private _quiz: Quiz, private cdr: ChangeDetectorRef,
    private _router: Router
  ) { }

  ngOnInit(): void {

    this._cat.categories().subscribe(
      (data: any) => {
        this.categories = data;
        console.log(this.categories)
      },
      (error) => {
        Swal.fire('Error !!!', 'Error in loading in data...', 'error')
      }
    )

  }

  //ad quiz
  addQuiz() {
    console.log(this.quizData)
    if (this.quizData.title.trim() == '' || this.quizData.title == null) {
      this._snack.open('Title is Require !!', '', {
        duration: 3000
      })
    }

    //add Quiz 
    this._quiz.addQuiz(this.quizData).subscribe(
      (data: any) => {
        this.quizData = {
          title: '',
          description: '',
          maxmarks: '',
          numberOfQuestions: '',
          active: true,
          category: {
            cid: ''
          }
        }
        // this.cdr.detectChanges();
        Swal.fire('Success', 'Quiz is added', 'success')
          .then(() => {

            return Swal.fire({
              icon: 'info',
              title: 'Are you sure want to add more quiz?',
              confirmButtonText: 'Yes',
              showCancelButton: true,
            });

          })
          .then((result) => {

            if (!result.isConfirmed) {
              this._router.navigate(['/admin/quizzes']);
            }

          });




      },
      (error) => {
        Swal.fire('Error !!!', 'error while adding quiz ', 'error')
        console.log(error)
      }
    )
  }

}
