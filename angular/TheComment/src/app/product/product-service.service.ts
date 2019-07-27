import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, Observer, observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {



  constructor(private http:HttpClient) { 

  }

  getTheProductList():Observable<any>{
    return this.http.get<any>(environment.ApiUrl + '/test/get');
  }

}
