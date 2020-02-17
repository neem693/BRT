import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-sns-share',
  templateUrl: './sns-share.component.html',
  styleUrls: ['./sns-share.component.css']
})
export class SnsShareComponent implements OnInit {

  @Input() share_url:string;

  constructor() { }

  ngOnInit() {
    console.log(this.share_url);
  }

  share(type:number){

    let url = "";
    let share_url = encodeURIComponent(this.share_url);

    const naver = 1;
    const facebook =2;
    const twitter = 3;
    const google = 4;
    const kakao = 5;

    
    switch(type){
      case kakao:
        url = "https://story.kakao.com/s/share?url=" + share_url;
        break;
      case twitter:
        url = "https://twitter.com/intent/tweet?text=[%EA%B3%B5%EC%9C%A0]%20" + share_url;
        break;
      case naver:
        url = "https://plus.google.com/share?url=" + share_url;
        break;
      case facebook :
        url = "https://www.facebook.com/sharer/sharer.php?u=" + share_url;
        break;
      case google:
        url = "https://plus.google.com/share?url=" + share_url;
        break;
    }

    window.open(url);

  }

}
