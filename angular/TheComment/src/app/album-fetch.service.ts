import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AlbumFetchService {
  private apiUrl = " https://jsonplaceholder.typicode.com/photos";
  constructor(private http:HttpClient) { }

  getAlbumData(){
    return this.http.get(this.apiUrl);
  }
}
