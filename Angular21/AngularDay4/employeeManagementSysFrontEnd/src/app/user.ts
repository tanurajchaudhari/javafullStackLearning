import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class User {
   constructor(private httpClient:HttpClient){

 }
private URL="http://localhost:8080/emp"


loginUser(username:string,password:string){
  // console.log(username,password);

  var body=new HttpParams().set('username',username).set('password',password);
  return this.httpClient.post(this.URL+"/login",body,{
    withCredentials:true
  })
}



  getAllEmp():Observable<any>{
    return this.httpClient.get(this.URL+"/all",{
      withCredentials:true
    })
    
  }  


  saveEmployee(employee:any): Observable<any>{
    console.log(employee)
     
     return  this.httpClient.post(this.URL+"/save",employee,{
       withCredentials:true
     })

  }
  
}