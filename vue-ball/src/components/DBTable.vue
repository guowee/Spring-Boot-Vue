<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      class="table">
      <el-table-column
        fixed
        prop="id"
        label="item_id"
        width="100">
      </el-table-column>
      <el-table-column
        prop="name"
        label="name"
        width="120">
      </el-table-column>
      <el-table-column
        prop="nickname"
        label="nickname"
        width="300">
      </el-table-column>
      <el-table-column
        prop="email"
        label="email"
        width="120">
      </el-table-column>
      <el-table-column
        prop="phone"
        label="phone"
        width="130">
      </el-table-column>
      <el-table-column
        prop="sex"
        label="sex"
        width="100">
      </el-table-column>
      <el-table-column
        prop="score"
        label="score"
        width="100">
      </el-table-column>
      <el-table-column
        prop="wechatId"
        label="wechat_id"
        width="100">
      </el-table-column>
      <el-table-column
        prop="createDate"
        label="create_date"
        width="180"
        :formatter="formatter">
      </el-table-column>
      <el-table-column
        prop="updateDate"
        label="update_date"
        width="180"
        :formatter="formatter">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="Operation"
        width="100">
        <template slot-scope="scope">
          <el-button @click="editItem(scope.$index, tableData)" type="text" size="large">Edit</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination class="pagination" layout="prev, pager, next" :total="total" :page-size="pageSize"
                   v-on:current-change="changePage">
    </el-pagination>
    <d-b-modal :dialogFormVisible="dialogFormVisible" :form="form" v-on:canclemodal="dialogVisible"></d-b-modal>
  </div>

</template>

<script>
  import Bus from '../eventBus'
  import DBModal from './DBModal.vue'

  export default {
    data () {
      return {
        tableData: [],
        apiUrl: '/api/user/all',
        total: 0,
        pageSize: 10,
        currentPage: 1,
        sex: '',
        email: '',
        dialogFormVisible: false,
        form: '',
      }
    },
    components: {
      DBModal
    },
    mounted () {
      this.getTotal()
      this.getAllUserBall()
      Bus.$on('filterResultData', (data) => {
        this.tableData = data.results
        this.total = data.total_pages
        this.pageSize = data.count
        this.email = data.email
        this.sex = data.sex
      })
    },
    methods: {
      dialogVisible: function () {
        this.dialogFormVisible = false
      },

      getTotal: function () {
        this.$axios.get('/api/user/count', {
          params: {}
        }).then((response) => {
          this.total = response.data
        }).catch(function (response) {
          console.log(response)
        })
      },
      getAllUserBall: function () {
        this.$axios.get(this.apiUrl, {
          params: {
            pageNum: this.currentPage,
            pageSize: this.pageSize,
          }
        }).then((response) => {
          this.tableData = response.data
        }).catch(function (response) {
          console.log(response)
        })
      },
      changePage: function (currentPage) {
        this.currentPage = currentPage
        this.getAllUserBall()
      },
      editItem: function (index, rows) {

      },
      formatter (row, column) {
        let data = this.$moment(row.create_date)
        return data.format('YYYY-MM-DD HH:mm:ss')
      },
    }
  }
</script>

<style>
  .table {
    margin-top: 30px;
  }

  .pagination {
    margin-top: 10px;
    float: right;
  }
</style>
