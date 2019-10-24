import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WorksSerivceService {

  constructor(private http:HttpClient) {
   }

   getAllWorkType(){
     return this.http.get(environment.baseApiUrl + "/type/getWorkAllType");
   }
   
   worksSave(data:FormData){
     return this.http.post(environment.baseApiUrl + "/works/workSave",data,{observe:'response'});
   }
}
