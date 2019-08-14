import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import * as Sockjs from 'sockjs-client';
import {Stomp} from '@stomp/stompjs'



// <script src = "/webjars/sockjs-client/sockjs.min.js"></script>
// <script src = "/webjars/stomp-websocket/stomp.min.js"></script>


@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.css']
})
export class WebSocketComponent implements OnInit {
  model = {
    left: true,
    middle: false,
    right: false
  };
  constructor() {}
   

  ngOnInit() {
    
  }

}
