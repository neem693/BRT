<template>
  <div id="app">
   
    <div class = "hamburg">
      <el-button ref="hamburg_button" class = "el-icon-s-unfold" @click = "customMenuMethod()"></el-button>
      <div class = "detail"><el-button v-if="customCollapse == false" circle @click = "expand()" class = "el-icon-caret-right"></el-button></div>
      
    </div>
    <el-menu
      default-active="2"
      :class="{'el-menu-vertical-demo':true,'customTransition':customTransition,'customCollapse':customCollapse}"
      @select="activate"
      @open="handleOpen"
      @close="handleClose"
      :collapse="isCollapse"
    >
  
      <el-menu-item index="1">
         <i class="el-icon-s-home"></i>
          <span slot="title">홈</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-location"></i>
        <span slot="title">지리정보데이터</span>
      </el-menu-item>
      <el-menu-item index="3" >
        <i class="el-icon-pie-chart"></i>
        <span slot="title">통계</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-goods"></i>
        <span slot="title">콘텐츠 정보</span>
      </el-menu-item>
    </el-menu>
      <!-- <div v-if = "customCollapse == false">
    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">
      <el-radio-button :label="false">expand</el-radio-button>
      <el-radio-button :label="true">collapse</el-radio-button>
    </el-radio-group>
    </div> -->
  </div>
</template>
<style>

#app{
  position:absolute;
  top:-58px;
  width: 100%;
}


.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;

}
.hamburg{
  display: block;
  text-align: left;
  
}
.hamburg button {
  width: 64px;
  font-size: large;
}

.hamburg .detail {
  position: absolute;
  top: 0px;
  margin: 0;
  left: 52px;
  top: 15px;
}

.detail button{
  
  font-size: small;
  width: auto;
  padding: 8px !important;
}

.customCollapse{
  left: -100px !important;
}
.el-menu--collapse.customTransition:not(.v-leave-active){
   left: 0px;
  transition: left 0.5s, border-color .3s,background-color .3s,color .3s;
}


</style>

<script>
export default {
    name: 'customElMenu',
  data() {
    return {
      isCollapse: true,
      customCollapse: true,
      customTransition: true
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    customMenuMethod (){
      if(this.customCollapse == true){
        this.isCollapse = true;
        this.customCollapse = false;
        
      }else{
        this.isCollapse = true;
        this.customCollapse = true;
      }
    },
    activate(index,indexPath){
      console.log(index,indexPath);
      console.log(    this.$refs.hamburg_button);
      let classList = this.$refs.hamburg_button.$el.classList;
      
      console.log(classList);
      for(let class_ of classList){

        if(class_.includes('el-icon')){
          this.$refs.hamburg_button.$el.classList.remove(class_);
        }

      }


      //추가
      let addClass = "";

      switch(Number(index)){
        case 1 : 
          addClass = "el-icon-s-home";
          break;
        case 2 :
          addClass = "el-icon-location";
          break;
        case 3 :
          addClass = "el-icon-pie-chart";
          break;
        case 4 :
          addClass = "el-icon-goods"
          break;
      }

      this.$refs.hamburg_button.$el.classList.add(addClass);

    },
    expand (){
      this.isCollapse = !this.isCollapse;
    }
  },
};
</script>