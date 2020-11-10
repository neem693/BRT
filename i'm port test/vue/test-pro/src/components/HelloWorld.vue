<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <ul>
      <li>
        <a
          href="https://vuejs.org"
          target="_blank"
        >
          Core Docs
        </a>
      </li>
      <li>
        <a
          href="https://forum.vuejs.org"
          target="_blank"
        >
          Forum
        </a>
      </li>
      <li>
        <a
          href="https://chat.vuejs.org"
          target="_blank"
        >
          Community Chat
        </a>
      </li>
      <li>
        <a
          href="https://twitter.com/vuejs"
          target="_blank"
        >
          Twitter
        </a>
      </li>
      <br>
      <li>
        <a
          href="http://vuejs-templates.github.io/webpack/"
          target="_blank"
        >
          Docs for This Template
        </a>
      </li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li>
        <a
          href="http://router.vuejs.org/"
          target="_blank"
        >
          vue-router
        </a>
      </li>
      <li>
        <a
          href="http://vuex.vuejs.org/"
          target="_blank"
        >
          vuex
        </a>
      </li>
      <li>
        <a
          href="http://vue-loader.vuejs.org/"
          target="_blank"
        >
          vue-loader
        </a>
      </li>
      <li>
        <a
          href="https://github.com/vuejs/awesome-vue"
          target="_blank"
        >
          awesome-vue
        </a>
      </li>
    </ul>
    <button @click="pay()">결제</button>
    <floatingActionExample></floatingActionExample>
    <radialMenuEx class ="fix"></radialMenuEx>
    <br><br>
    <br><br>

    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
        <br><br>
    <br><br>

    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
        <br><br>
    <br><br>

    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
        <br><br>
    <br><br>

    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>


  </div>
</template>

<script>

import radialMenuEx from './radialMenuEx';
import floatingActionExample from './floatingAction';

const { IMP } = window;
// IMP.init('imp49163872');

export default {

  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted () {



  },
  components : {
    radialMenuEx,
    floatingActionExample
  },
  methods: {
    pay(){

      IMP.request_pay({
        pg : 'html5_inicis',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '주문명:결제테스트',
        amount : 14000,
        buyer_email : 'iamport@siot.do',
        buyer_name : '구매자이름',
        buyer_tel : '010-3043-5693',
        buyer_addr : '서울특별시 강남구 삼성동',
        buyer_postcode : '123-456'
    }, function(rsp) {
        if ( rsp.success ) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }

        alert(msg);
    });

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.fix{
  left: calc(50% - 25px);
  /* left: 300px; */
  position:fixed;
  bottom: -30px;
}
</style>
