<template>
  <li class="el-menu-item is-active" style="">{{msg}}</li>
</template>
<script type="text/ecmascript-6">
  export default {
    name: 'Slidebar',
    data () {
      return {
        msg: 'Dashboard'
      }
    }
  }
</script>
<style>
  li {
    padding-left: 20px;
  }
</style>
