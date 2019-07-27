import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';
import { observable, Observable } from 'rxjs';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {
  jsonData:any;

  constructor(private service:ProductServiceService) { }
  
  ngOnInit() {
   this.service.getTheProductList().subscribe(
      (data)=>{
        this.jsonData = data;
        console.log("실행중");
        this.afterAuthFunction();
      },
      (error)=>{
        console.log(error);
      }
    )
  

  }

  afterAuthFunction(){
    console.log("실행완료");
  }

}
