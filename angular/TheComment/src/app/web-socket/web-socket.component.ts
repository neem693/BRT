import { Component, OnInit, OnDestroy } from '@angular/core';
import * as $ from 'jquery';
import * as Sockjs from 'sockjs-client';
import { Stomp } from '@stomp/stompjs'
import { environment } from 'src/environments/environment';



// <script src = "/webjars/sockjs-client/sockjs.min.js"></script>
// <script src = "/webjars/stomp-websocket/stomp.min.js"></script>


@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.css']
})
export class WebSocketComponent implements OnInit,OnDestroy {
 
  model = {
    left: true,
    middle: false,
    right: false
  };

  connectVar = 0;
  stompClient: any;

  constructor() { }


  ngOnInit() {
    $("form").on('submit', (e) => {
      e.preventDefault();
    });
    $("#connect").click(() => {
      this.connect();
    })
    $("#disconnect").click(() => {
      this.disconnect();
    })
    $("#send").click(()=>{
      this.sendName();
    })
  }

  ngOnDestroy(): void {
    this.disconnect();
  }
  

  setConnected(connected: boolean) {
    if (connected == true) {
      this.connectVar = 1;
    } else {
      this.connectVar = 0;
    }

    $("#greetings").html("");
  }

  connect() {
    let socket = new Sockjs(environment.ApiUrl + "/Tct_websocket");
    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({}, (frame: any) => {
      this.setConnected(true);
      console.log("connected" + frame);
      this.stompClient.subscribe( "/topic/greetings", (greeting) => {
        this.showGreeting(JSON.parse(greeting.body).content);
      });
    });
  }

  disconnect() {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }
    this.setConnected(false);
    console.log("Disconnected");
  }

  sendName() {
    this.stompClient.send( "/app/hello", {}, JSON.stringify({ 'name': $("#name").val() }))
  }

  showGreeting(message: any) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
  }

}
