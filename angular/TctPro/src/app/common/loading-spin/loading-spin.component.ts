import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-loading-spin',
  templateUrl: './loading-spin.component.html',
  styleUrls: ['./loading-spin.component.css']
})
export class LoadingSpinComponent implements OnInit {

  @Input()
  loading:number = 0;

  constructor() { }

  ngOnInit() {
  }

}
