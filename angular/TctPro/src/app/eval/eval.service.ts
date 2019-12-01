import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EvalService {



  constructor(private http: HttpClient) { }

  /** get the work in eval */
  getWork(data: any) {
    return this.http.get(environment.baseApiUrl + "/eval/getWork", { params: data });
  }

  /** get the matter of evalation */
  getMatter(data: any) {
    return this.http.get(environment.baseApiUrl + "/eval/getMatter", { params: data });
  }
  /** add evaluation Item */
  saveEval(data: {}) {
    return this.http.post(environment.baseApiUrl + "/eval/saveEval", data);
  }


  evalSearch(param: any) {
    return this.http.get(environment.baseApiUrl + '/eval/evalSearch',{params:param});
  }


}
