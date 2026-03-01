import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Material_Imports } from '../../../importMaterial';
import { CommonModule } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { Question } from '../../../service/question';
import Swal from 'sweetalert2';



import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import {
  ClassicEditor,
  Bold,
  Italic,
  Essentials,
  Paragraph,
  Heading,
  List,
  Link,
  Image,
  ImageToolbar,
  ImageUpload,
  Table,
  TableToolbar,
  BlockQuote
} from 'ckeditor5';


@Component({
  standalone: true,
  selector: 'app-add-questions',
  imports: [
    Material_Imports,
    CommonModule,
    MatSelectModule,
    FormsModule,
    CKEditorModule,




  ],
  templateUrl: './add-questions.html',
  styleUrl: './add-questions.css',
})
export class AddQuestions implements OnInit {


  public Editor = ClassicEditor;

  public config = {
    licenseKey: 'GPL',
    plugins: [
      Essentials,
      Paragraph,
      Bold,
      Italic,
      Heading,
      List,
      Link,
      Image,
      ImageToolbar,
      ImageUpload,
      Table,
      TableToolbar,
      BlockQuote
    ],
    toolbar: [
      'heading',
      '|',
      'bold',
      'italic',
      'link',
      'bulletedList',
      'numberedList',
      '|',
      'insertTable',
      'uploadImage',
      'blockQuote',
      '|',
      'undo',
      'redo'
    ]
  };


  qId: number = -1;
  qtitle: any;
  question = {
    quiz: {
      'qId': 0

    },
    content: '',
    option1: '',
    option2: '',
    option3: '',
    option4: '',
    answer: '',
  }
  constructor(private _route: ActivatedRoute, private _question: Question, private cdr: ChangeDetectorRef,
    private _router: Router

  ) { }
  ngOnInit(): void {

    this.qId = this._route.snapshot.params['qid'];
    this.qtitle = this._route.snapshot.params['qtitle'];
    this.question.quiz['qId'] = this.qId;
    console.log(this.qId)



  }

  //add question
  formSubmit() {
    this._question.addQuestion(this.question).subscribe(
      (data: any) => {
        this.question.content = '',
          this.question.option1 = '',
          this.question.option2 = '',
          this.question.option3 = '',
          this.question.option4 = '',
          this.question.answer = '',
          // this.cdr.detectChanges()
        // Swal.fire('Added','Question added successfully','success')
        Swal.fire('Added', 'Question added successfully', 'success')
          .then(() => {

            return Swal.fire({
              icon: 'info',
              title: 'Are you  want to add more question?',
              confirmButtonText: 'Yes',
              showCancelButton: true,
            });

          })
          .then((result) => {

            if (!result.isConfirmed) {
              this._router.navigate(['/admin/view-questions', this.qId, this.qtitle]);
            }

          });

      },
      (error) => {
        Swal.fire('Error!!', 'error in loading data', 'error')
      }
    )
  }

}
