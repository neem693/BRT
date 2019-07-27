import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

serviceproperty = "Service Created";
private apiurl = "http://jsonplaceholder.typicode.com/users";

private titleSource = new BehaviorSubject('The Comment');
title = this.titleSource.asObservable();


  constructor(private http: HttpClient) {}

  changeTitle(title:string){
    this.titleSource.next(title);
  }

  showTodayDate(){
    let ndate = new Date();
    return ndate;
  }

  getdata(){
    return this.http.get(this.apiurl);
  }
}
