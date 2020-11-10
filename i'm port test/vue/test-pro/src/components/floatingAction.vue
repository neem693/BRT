<template>
  <vue-fab
    :mainBtnColor="mainBtnColor"
    @clickMainBtn="clickMainBtn"
    :scrollAutoHide = false
    >
    <fab-item v-for="(item, idx) in menu"
      :idx="idx"
      :title="item.title"
      :color="item.color"
      :icon="item.icon"
      @clickItem="clickItem"
      :key="idx" />
  </vue-fab>
</template>

<script>  

  export default {
    name: 'floatingActionExample',
    data () {
      return {
        menu: [
          {
            icon: 'done',
            title: 'good job!',
            color: '#ff9900'
          },
          {
            icon: 'toc',
            title: '',
            color: '#999'
          }
        ],
        mainBtnColor: '#FF0099'
      }
    },
    components: {
    },
    methods: {
      clickItem: function (idx) {
        console.log('idx: ' + idx)
      },
      clickMainBtn: function () {
        console.log('clickMainBtn');
      }
    }
  }
</script>