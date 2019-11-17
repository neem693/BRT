import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WorksSerivceService {




  constructor(private http: HttpClient) {
  }

  getAllWorkType() {
    return this.http.get(environment.baseApiUrl + "/type/getWorkAllType");
  }

  worksSave(data: any) {
    return this.http.post(environment.baseApiUrl + "/works/workSave", data, { observe: 'response' });
  }

  worksSelectOne(data: any) {
    return this.http.get(environment.baseApiUrl + "/works/worksSelectOne", { params: data });
  }

  worksSelectList(data: any) {
    return this.http.post(environment.baseApiUrl + "/works/selectWorks", data);
  }

  worksSelectListDetail(data: any) {
    return this.http.post(environment.baseApiUrl + "/works/selectWorksDetail", data);
  }

  worksSearch(data: {}) {
    return this.http.get(environment.baseApiUrl + "/worksPublic/worksSearch", { params: data });
  }

  worksSearchDetail(data: any) {
    return this.http.get(environment.baseApiUrl + "/worksPublic/worksSearchDetail",{params:data});
  }

  selectWorksByArtistOnes(id: any) {
    return this.http.get(environment.baseApiUrl + "/worksPublic/selectWorksByArtist",{params:id});
  }

  
}
