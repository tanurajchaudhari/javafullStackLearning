import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class Question {

  constructor(private _http:HttpClient){}

  //get questionf test
  public getQuestionsOfQuizForTest(qId:number){
    return this._http.get(`${baseUrl}/question/quiz/${qId}`)
  }
  //get questions for admin all questions
  public getQuestionsOfQuiz(qId:number){
    return this._http.get(`${baseUrl}/question/quiz/all/${qId}`)
  }
  //add question to quiz
  public addQuestion(question:any){
     return this._http.post(`${baseUrl}/question/`,question)
  }
  //delete question
  public deleteQuestion(questId:any){
    return this._http.delete(`${baseUrl}/question/${questId}`);
  }
  //get single question data
  public getSingleQuestion(questId:any){
  
    return this._http.get(`${baseUrl}/question/${questId}`)
  }
  //update the question
  public updateQuestion(question:any){
    return this._http.put(`${baseUrl}/question/`,question)
  }

  // eval quiz
  public evalQuiz(questions:any){
    return  this._http.post(`${baseUrl}/question/eval-quiz`,questions);
  }
}
