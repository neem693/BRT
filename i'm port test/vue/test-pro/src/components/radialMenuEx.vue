
<template>
  <div id="radial-menu">
 
    <radial-menu
      style="margin: auto; margin-top: 300px; background-color: white"
      :itemSize="50"
      :radius="100"
      :angle-restriction="180"
      >
        <radial-menu-item 
          v-for="(item, index) in items" 
          :key="index" 
          style="background-color: white" 
          @click="() => handleClick(item)">
          <span>{{item}}</span>
        </radial-menu-item>
      </radial-menu>
      <div style="color: rgba(0,0,0,0.6); margin-top: 16px;"></div>
  </div>
</template>
 
<script>
import { RadialMenu,  RadialMenuItem } from 'vue-radial-menu'
 
export default {
  name: 'radialMenuEx',
  components: {
    RadialMenu,
    RadialMenuItem
  },
  data () {
    return {
      items: ['타입1', '타입2', '타입3', '타입4', '타입5', '타입6'],
      lastClicked: 'click on something!'
    }
  },
  methods: {
    handleClick (item) {
      this.lastClicked = item;
    }
  }
}
</script> 