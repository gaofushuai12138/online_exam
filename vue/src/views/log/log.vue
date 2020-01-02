<template>
    <div class="app-container">
        <div class="filter-container">
            <el-input v-model="queryForm.operater" placeholder="操作者" style="width:300px"></el-input>
            <el-input v-model="queryForm.operaterecord" placeholder="操作记录" style="width:300px;margin-left:40px"></el-input>
            <div class="block" style="margin-left:700px;margin-top:-40px;width:400px">
                <el-date-picker
                style="width:450px"
                v-model="queryForm.dateTime"
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
                </el-date-picker>
            </div>
              <el-select class="block" style="margin-left:1200px;margin-top:-40px;position:absolute" v-model="queryForm.value" clearable placeholder="操作类型">
                <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
                </el-option>
               
            </el-select>
            <el-button type="primary" style="margin-top:-40px;width:80px;position:fixed;left:85%;right:15%" @click="queryLog">查询</el-button>
            <el-table
                border
                :data="tableData"
                style="width: 100%;margin-top:20px">
                <el-table-column
                align="center"
                    prop="index"
                    label="序号"
                    width="180">
                </el-table-column>
                <el-table-column
                align="center"
                    prop="name"
                    label="操作者"
                    width="180">
                </el-table-column>
                <el-table-column
                align="center"
                    prop="operate"
                    label="操作记录">
                </el-table-column>
                <el-table-column
                label="操作时间"
                align="center"
                prop="operatedate">
                </el-table-column>
                <el-table-column
                label="操作类型"
                align="center">
                <template slot-scope="scope">
                    <el-tag type="success" v-text="scope.row.operatetype"></el-tag>
                </template>
                </el-table-column>
            </el-table>
             <div class="pagination" style="margin-left:1450px;margin-top:15px">
                <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :current-page="queryForm.pageIndex"
                    :page-size="queryForm.pageSize"
                    :total="pageTotal"
                    @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
        queryForm:{
          operater:"",
          operaterecord:"",
          dateTime:"",
          value:"",
          pageIndex:1,
          pageSize:10
        },
        pageTotal:10,
        dateTime:"",
        input:"",
        totalCount: 0, //分页组件--数据总条数
         options: [{
          value: "用户管理",
          label: "用户管理"
        }, {
          value: '权限管理',
          label: '权限管理'
        }, {
          value: '日志管理',
          label: '日志管理'
        }],
        value: '',
        tableData: [{
            index:1,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1518 弄',
            operatedate:"2016-05-03",
            operatetype:"用户管理"
          }, {
            index:2,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1517 弄',
            operatedate: '2016-05-04',
            operatetype:"用户管理"
          }, {
            index:3,
            date: '2016-05-01',
            name: '王小虎',
            operate:"黄玉东还钱！",
            operatedate: '2016-03-04',
            operatetype:"用户管理"
          }, {
            index:4,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1516 弄',
            operatedate:"2016-03-04",
            operatetype:"用户管理"
          },{
            index:5,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1518 弄',
            operatedate:"2016-05-03",
            operatetype:"用户管理"
          }, {
            index:6,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1517 弄',
            operatedate: '2016-05-04',
            operatetype:"用户管理"
          }, {
            index:7,
            date: '2016-05-01',
            name: '王小虎',
            operate:"黄玉东还钱！",
            operatedate: '2016-03-04',
            operatetype:"用户管理"
          }, {
            index:8,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1516 弄',
            operatedate:"2016-03-04",
            operatetype:"用户管理"
          }, {
            index:9,
            date: '2016-05-01',
            name: '王小虎',
            operate:"黄玉东还钱！",
            operatedate: '2016-03-04',
            operatetype:"用户管理"
          }, {
            index:10,
            name: '王小虎',
            operate: '上海市普陀区金沙江路 1516 弄',
            operatedate:"2016-03-04",
            operatetype:"用户管理"
          }],
            listLoading:false,
            listQuery:{
                pageNum:1,
                pageRow:50
            },
            role:[]
    };
  },
  mounted() {},
  methods: {
      queryLog(){
          console.log(this.queryForm)
      },
      handlePageChange(){

      }
  },
};
</script>


<style scoped>
</style>


