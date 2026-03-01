import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class Category {

  constructor(private _http:HttpClient){}

  //Load all the categories
  public categories(){
    return this._http.get(`${baseUrl}/category/`)
  }
  //ad category
  public addCategory(category:any){
         return this._http.post(`${baseUrl}/category/`,category);
  }
}
