import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  count$:Observable<number>;

  constructor(private store:Store<{count:number}>) { }

  ngOnInit() {
    this.count$ = this.store.pipe(select('count'));  
  }

}
