<template>
  <el-form :inline="true" :model="formInline">

    <el-form-item label="Sex">
      <el-select v-model="formInline.sex" clearable placeholder="select sex"
                 v-on:visible-change="selectDemo">
        <el-option
          v-for="(item, index) in type_options"
          :key="index"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </el-form-item>

    <el-form-item v-if='formInline.sex' label="Description">
      <el-input v-model="formInline.email" placeholder="Please input suffix of email"></el-input>
    </el-form-item>

    <el-form-item valid-v-else='formInline.sex' label="Description">
      <el-input v-model="formInline.email" disabled placeholder="Please input suffix of email"></el-input>
    </el-form-item>

  </el-form>
</template>

<script>

  export default {
    name: 'd-b-filterinput',
    data () {
      return {
        type_options: [],
        formInline: {
          sex: '',
          email: ''
        },
        formLabelWidth: '120px'
      }
    },
    watch: {
      'formInline.sex': 'filterResultData',
      'formInline.email': 'filterResultData'
    },
    methods: {
      selectDemo: function (params) {

      },
    }
  }
</script>
