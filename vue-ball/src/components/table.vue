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
        label="id"
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
        prop="email"
        label="email"
        width="100">
      </el-table-column>
      <el-table-column
        prop="create_date"
        label="create_date"
        width="300"
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
    <Modal :dialogFormVisible="dialogFormVisible" :form="form" v-on:canclemodal="dialogVisible"></Modal>
  </div>
</template>
<script type="text/ecmascript-6">
  import Modal from './Modal.vue'

  export default {
    name: 'Table',
    data () {
      return {
        tableData: [],
        apiUrl: '/api/user/query/',
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
      Modal
    },
    mounted () {
      this.getAllUserBall()
    },
    methods: {
      dialogVisible: function () {
        this.dialogFormVisible = false
      },
      getAllUserBall: function () {
        this.$axios.get(this.apiUrl + 133, {
          params: {}
        }).then((response) => {
          this.tableData = response.data[0]
          console.log(response.data)
        }).catch(function (response) {
          console.log(response)
        })
      },
      changePage: function (currentPage) {
        this.currentPage = currentPage
        this.getCustomers()
      },
      editItem: function (index, rows) {
        this.dialogFormVisible = true
        const itemId = rows[index].id
        const idurl = this.apiUrl + itemId
        this.$axios.get(idurl).then((response) => {
          this.form = response.data
        }).catch(function (response) {
          console.log(response)
        })
      },

      formatter (row, column) {
        let data = this.$moment(row.create_date, this.$moment.ISO_8601)
        return data.format('YYYY-MM-DD')
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
