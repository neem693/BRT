import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {
 

  constructor(private http:HttpClient) { }

  artistSave(data: {}) {
   return this.http.post(environment.baseApiUrl + "/artist/artistSave",data,{observe:'response'});
  }

  selectArtistOne(data:any) {
    return this.http.get(environment.baseApiUrl + "/artist/artistSelectOne",{params:data});
  }

  selectArtistList(data:any){
    return this.http.post(environment.baseApiUrl + "/artist/selectArtistList",data);
  }


}
