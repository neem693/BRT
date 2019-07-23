import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

title = "The Comment";
serviceproperty = "Service Created";
private apiurl = "http://jsonplaceholder.typicode.com/users";

  constructor(private http: HttpClient) {}

  showTodayDate(){
    let ndate = new Date();
    return ndate;
  }

  getdata(){
    return this.http.get(this.apiurl);
  }
}
