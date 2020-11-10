// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import VueFab from 'vue-float-action-button'

Vue.config.productionTip = false

Vue.use(VueFab,{
  scrollAutoHide: false,
  hidden: false,
  autoHideDirection: 'down',
  size: 'big'

})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
