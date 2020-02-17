import { Component, OnInit, Input, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';


declare const $: any;

@Component({
  selector: 'app-eval-object',
  templateUrl: './eval-object.component.html',
  styleUrls: ['./eval-object.component.css']
})
export class EvalObjectComponent implements OnInit, AfterViewInit {


  @Input() item: any;
  @Input() index: number = 0;
  @Input() autoEffect = 0;

  constructor(private router: Router) { }

  ngOnInit() {
    if (this.item['ev_value'] >= 1 && this.item['ev_value'] <= 3) {
      this.item['ev_value_class_name'] = 'gray';
    } else if (this.item['ev_value'] >= 4 && this.item['ev_value'] <= 5) {
      this.item['ev_value_class_name'] = 'blue';
    } else if (this.item['ev_value'] >= 6 && this.item['ev_value'] <= 7) {
      this.item['ev_value_class_name'] = 'yellow';
    }


    if (this.autoEffect == 1) {
      this.evalShow(this.index);
    }
  }

  /**
 * go to Detail of evalItem detail
 */
  goToDetail(item: any) {
    this.router.navigate(["/eval/evalDetail", item.eval_item_id]);

  }

  ngAfterViewInit(): void {

  }


  /**
   * loading complete jquery effect 
   * */
  evalShow(i: number) {
    setTimeout(() => {
      $("#eval_con_" + i).addClass("loadingComplete");
      console.log("#eval_con_" + i);
    }, 200 * (i + 1));

  }

}
