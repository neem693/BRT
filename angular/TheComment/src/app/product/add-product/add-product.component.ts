import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductServiceService } from '../product-service.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  jsonData:any;
  param:string;
  queryNum:number;
  constructor(private service:ProductServiceService,private router:Router) {
    this.queryNum = 0;
   }

  ngOnInit() {
    
   
  }

  submitParam(){

    if(this.param =='' || this.param == undefined){
      alert("텍스트를 입력해주세요.");
      $("#paramText").focus();
      return;
    }

    this.service.postProduct(this.param).subscribe((data)=>{
      this.jsonData = data;
      this.queryNum = 1;
    })
  }

  

  

}
