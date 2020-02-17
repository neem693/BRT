import { Component, OnInit, Input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ClipboardService } from 'ngx-clipboard';
import { GlobalServiceService } from 'src/app/global/global-service.service';

@Component({
  selector: 'app-share',
  templateUrl: './share.component.html',
  styleUrls: ['./share.component.css']
})
export class ShareComponent implements OnInit {

  @Input() eval_id:any;
  coping:number=0;

  share = {
    url:new FormControl("http://the-comment.com/eval/share/" + this.eval_id),
  }

  constructor(
    private _clipboardService: ClipboardService,
    private globalService:GlobalServiceService
    ) { }

  ngOnInit() {
    //console.log(this.eval_id);
    this.share.url.setValue("http://the-comment.com/eval/share/" + this.eval_id);
  }

  copyURL(){
    this._clipboardService.copy(this.share.url['value']);
    this.coping = 1;
    setTimeout(()=>{
      this.coping = 0;
    },1000);
  }



}
