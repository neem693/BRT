import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) {

  }
  getHomeEvalItem(){
    return this.http.get(environment.baseApiUrl + "/evalPublic/mainEvalList");
  }

}
