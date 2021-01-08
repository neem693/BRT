import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import customElMenu from '@/components/customElMenu'

Vue.use(Router)

export default new Router({
  mode: 'history',
  useEslint: false,
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/customElMenu',
      name: 'customElMenu',
      component: customElMenu
    }
  ]
})
