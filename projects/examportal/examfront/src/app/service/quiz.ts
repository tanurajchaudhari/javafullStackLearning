import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class Quiz {

  constructor(private _http:HttpClient){}

  //get all quizess
  public quizzes(){
    return  this._http.get(`${baseUrl}/quiz/`);
  }
  
  // add quizzess
  public addQuiz(quiz:any){
    return this._http.post(`${baseUrl}/quiz/`,quiz)
  }

  //delete the quiz
  public deleteQuiz(qId:number){
    return this._http.delete(`${baseUrl}/quiz/${qId}`)
  }

  //get single quiz
  public getQuiz(qId:number){
    return this._http.get(`${baseUrl}/quiz/${qId}`)
  }
  //update quiz
  public updateQuiz(quiz:any){
    return this._http.put(`${baseUrl}/quiz/`,quiz)
  }

  // get quizzes of category
  public  getQuizzesOfCategory(cid:number){
    return this._http.get(`${baseUrl}/quiz/category/${cid}`)
  }

  //get active quizzes
  public getActiveQuizzes(){
    return this._http.get(`${baseUrl}/quiz/active`)
  }
  //get active quizzes of category
  public getActiveQuizzesOfCategory(cid:number){
    return this._http.get(`${baseUrl}/quiz/category/active/${cid}`)
  }
}
