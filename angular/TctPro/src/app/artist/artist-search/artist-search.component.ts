import { Component, OnInit, ViewChild } from '@angular/core';
import { SwiperConfigInterface, SwiperComponent } from 'ngx-swiper-wrapper';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';
import { FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-artist-search',
  templateUrl: './artist-search.component.html',
  styleUrls: ['./artist-search.component.css']
})
export class ArtistSearchComponent implements OnInit {

  public config: SwiperConfigInterface = {
    slideToClickedSlide: true,
    loop: true,
    direction: 'horizontal',
    slidesPerView: 5,
    mousewheel: true,
    centeredSlides: true,
    pagination: { clickable: true, el: '.swiper-pagination' },
  };

  typeList = {
    data: [],
    type2: [],
    type1Index: 0,
    type2Index: 0,
  }

  /**
   * loading type of some
   * ##search : search loading
   * ##searchItemOrder: loading of item order in searchs
   * ##detail : at least one load of detail
   * 0: detail not load
   * 1: at least one load
   * ##firstLoading: first loading for typeList loading
   * 0: is not loading
   * 1: is loading
   */
  loading = {
    type: 0,
    search: 0,
    searchItemOrder: 0,
    detail: 0,
    firstLoading: 0,
  }

  /**
   * search variable
   * ##order##
   * 0:eval count
   * 1:realse time
   * ##order2##
   * 0:desend
   * 1:accend
   */
  search = {
    type1: 0,
    type2: 0,
    searchText: new FormControl("", [
      Validators.maxLength(60)
    ]),
    order: 0,
    order2: 0,
    pageNum: 1,

  }

  private swiperType1:SwiperComponent;  
  private swiperType2:SwiperComponent;

  @ViewChild('type1', { static: false }) set swiperType1_viewchild(content:SwiperComponent){
    this.swiperType1 = content;
  }
  @ViewChild('type2', { static: false }) set swiperType2_viewchild(content:SwiperComponent){
    this.swiperType2 = content;
  }
  

  constructor(
    private workService:WorksSerivceService,
    private router:Router,
    private route:ActivatedRoute
  ) { }

  ngOnInit() {

    this.getAllType();
  }

  /*************모든 타입 불러오기********** */
  getAllType() {

    this.workService.getAllWorkType().subscribe((result) => {
      this.typeList.data = Object.assign([], result);

      for (var i = 0; i < this.typeList.data.length; i++) {

        this.typeList.data[i].type2Dto.unshift({ type2_name: "전체", type2_id: 0 });

        // for(var j =0; j<this.typeList.data[i].type2Dto.length; j++){

        // }

      }

      this.typeList.data.unshift({ type1_name: "전체", type1_id: 0 });
      this.loading.type = 1;

      setTimeout(()=>{
        for (var i = 1; i < this.typeList.data.length; i++) {
          if (this.typeList.data[i].type1_id == this.search.type1) {
            this.typeList.type1Index = i;
            this.swiperType1.directiveRef.setIndex(i);
            console.log("type1 index" + this.typeList.type1Index);
            setTimeout(()=>{
              for (var j = 1; j < this.typeList.data[this.typeList.type1Index].type2Dto.length; j++) {
                console.log(this.search.type2);
                if (this.typeList.data[this.typeList.type1Index].type2Dto[j].type2_id == this.search.type2) {
                  this.typeList.type2Index = j;
                  this.swiperType2.directiveRef.setIndex(j);
                  console.log(j + " type2 " + this.typeList.type2Index);
                }
              }
            },1000)

          }
        }

        this.loading.firstLoading = 1;

      },1000);
   

      // console.log(this.typeList);
    });

  }

  /**type1 change event */
  type1Change(index: number) {
    this.search.type1 = this.typeList.data[index].type1_id;
    if(this.loading.firstLoading == 1){
      this.search.type2 = 0;
    }
    
    this.typeList.type1Index = index;
    this.typeList.type2Index = 0;

    // console.log(this.search.type1 + "type1");
  }

  /**type1 change event */
  type2Change(index: number) {
    this.typeList.type2Index = index;
    this.search.type2 = this.typeList.data[this.typeList.type1Index].type2Dto[index].type2_id;

    // this.search.type1 = this.typeList.data[index].type1_id;
    // console.log(this.search.type1);
    // console.log(this.search.type2 + "type2");
  }

  artistSearchNativeUrl(page:number){

    let param = {};
    
    for(let key in this.search){
      if(key == "searchText"){
        param[key] = this.search.searchText.value;
        continue;
      }
      param[key] = this.search[key];
    }
    
    this.router.navigate([],{
      queryParamsHandling: "merge",
      queryParams: param
    })

  }

}
