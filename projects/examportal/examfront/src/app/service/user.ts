import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class User {

  constructor(private http:HttpClient){

  }

  // add user
  public addUser(employee:any) : Observable<any> {
    console.log("in user.ts ")  
    console.log (employee) 
  return this.http.post(`${baseUrl}/user/`,employee);
  
  }
  
}
