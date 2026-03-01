import { CommonModule, LocationStrategy } from '@angular/common';
import { ChangeDetectorRef, Component, NgZone, OnInit } from '@angular/core';
import { Question } from '../../../service/question';
import { ActivatedRoute, RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';


@Component({
  selector: 'app-start',
  imports: [
    FormsModule,
    CommonModule,
    MatCardModule,
    MatDividerModule,
    MatButtonModule,
    RouterModule,
    MatProgressSpinnerModule,

  ],
  templateUrl: './start.html',
  styleUrl: './start.css',
})
export class Start implements OnInit {

  qid: any;
  questions: {
    quesId?: number;
    content: string;
    image: string;
    option1: string;
    option2: string;
    option3: string;
    option4: string;
    answer?: string;
    givenAnswer?: string;
    quiz: {
      qId: number;
      title: string;
      description: string;
      maxmarks: string;
      numberOfQuestions: string;
    }
  }[] = [];

  marksGot: any = 0;
  correctAnswer: any = 0;
  attempted: any = 0;
  isSubmit: boolean = false;
  timer: number = 0;
  totalTime: number = 0;
  private intervalId: any;

  constructor(
    private locationSt: LocationStrategy,
    private _route: ActivatedRoute,
    private _question: Question,
    private cdr: ChangeDetectorRef,
    private ngZone: NgZone

  ) { }
  ngOnInit(): void {
    this.preventBackButton();
    this.qid = this._route.snapshot.params['qid'];
    console.log(this.qid)
    this.loadQuestions()
  }
  loadQuestions() {
    this._question.getQuestionsOfQuizForTest(this.qid).subscribe(
      (data: any) => {
        console.log(data);
        this.questions = data

        this.totalTime = this.questions.length * 2 * 60;
        this.timer = this.totalTime;
        // this.questions.forEach((q) => {
        //   q.givenAnswer = '';
        // })
        console.log(this.questions)
        this.startTimer()
        //this.cdr.detectChanges()


      },
      (error) => {
        console.log(error)
        Swal.fire('Error!!!!', 'Error while fetching data', 'error')


      }
    )
  }
  preventBackButton() {
    history.pushState(null, '', location.href);
    this.locationSt.onPopState(() => {
      history.pushState(null, '', location.href);
    });
  }
  submitQuiz() {
    console.log("submitquiz button is click")
    Swal.fire({
      title: 'Do you want to submit the quiz',
      showCancelButton: true,
      confirmButtonText: `SUBMIT`,
      icon: 'info'
    }).then((result) => {
      if (result.isConfirmed) {
        //calculate the values
        this.evalQuiz()

      }
    })
  }

  startTimer() {
    this.intervalId = window.setInterval(() => {
      //code 
      if (this.timer <= 0) {
        clearInterval(this.intervalId)
        this.evalQuiz()

      } else {
        this.timer--;
        console.log(this.timer);
        //this.cdr.detectChanges(); 
      }

    }, 1000);


  }

  getProgress(): number {
    if (this.totalTime === 0) return 0;
    return (this.timer / this.totalTime) * 100;
  }
  getFormmatedTime() {
    let mm = Math.floor(this.timer / 60);
    let ss = this.timer - mm * 60
    return `${mm} min : ${ss} sec `;
  }
  evalQuiz() {
    clearInterval(this.intervalId);

    // >>>>>>>>>>>>>>>>>>>>> call  to  server to check questions >>>>>>>>>>>>>>>>>>>>>>>>
    this._question.evalQuiz(this.questions).subscribe({
      next: (data: any) => {
        console.log(data)
        this.marksGot= parseFloat(data.marksGot.toFixed(2)) ;
        this.correctAnswer=data.correctAnswer;
        this.attempted=data.attempted;
        console.log("Marksgot is :",this.marksGot)
        console.log("correctAnswer is :",this.correctAnswer)
        console.log("Attempted is :",this.attempted)

        this.isSubmit=true
      },
      error: (error) => {
        console.log(error)
      }
    })


    // this.isSubmit=true  
    // this.questions.forEach(q=>{
    //   if(q.givenAnswer==q.answer){
    //     this.correctAnswer++;
    //     let marksSingle =  +this.questions[0].quiz.maxmarks / this.questions.length ;
    //     this.marksGot+=marksSingle;
    //    // this.cdr.detectChanges();
    //   }
    // })
    // console.log("Correct Answers :",this.correctAnswer)
    // console.log("Marks Got",this.marksGot);
  }

  printPage(){
    window.print();
  }

}
