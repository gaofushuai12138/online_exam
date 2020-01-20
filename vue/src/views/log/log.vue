<template>
    <div class="app-container">
        <div class="filter-container">
            <el-button type="primary" style="margin-left:0px;margin-top:-40px;width:80px;" @click="queryAllLog">查询</el-button>
            <el-button type="danger" style="width:80px;" @click="clearAll">清空</el-button>
            <el-input v-model="formData.username" placeholder="操作者" style="width:300px;margin-left:20px"></el-input>
            <el-input v-model="formData.description" placeholder="操作记录" style="width:300px;margin-left:40px"></el-input>
            <div class="block" style="margin-left:870px;margin-top:-40px;width:400px">
                <el-date-picker
                style="width:450px"
                v-model="formData.dataTime"
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
                </el-date-picker>
            </div>
            <el-table
                border
                v-loading.body = "listLoading"
                :data="tableData"
                element-loading-text="拼命加载中"
                fit
                highlight-current-row
                style="width: 100%;margin-top:20px">
                <el-table-column
                align="center"
                    prop="logid"
                    label="序号"
                    width="180">
                </el-table-column>
                <el-table-column
                align="center"
                    prop="username"
                    label="操作者"
                    width="180">
                </el-table-column>
                <el-table-column
                label="ip"
                align="center"
                prop="ip"></el-table-column>
                <el-table-column
                align="center"
                    prop="module"
                    label="操作模块">
                </el-table-column>
                <el-table-column
                align="center"
                    prop="description"
                    label="操作内容">
                </el-table-column>
                <el-table-column
                label="操作时间"
                align="center"
                prop="operationTime">
                </el-table-column>
            </el-table>
             <div class="pagination" style="margin-top:17px">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="pageNum"
                  :page-size="pageRow"
                  :total="pageTotal"
                  :page-sizes="[10, 20, 50, 100]"
                  layout="total, sizes, prev, pager, next, jumper">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
      pageNum: 1,
      pageRow: 10,
      formData: {
        username:"",
        description:"",
        dataTime:""
      },
      pageSize:10,
      initQuery:{
        pageSize:10,
        pageNum:1
      
      },
      pageTotal: 1000,
      value: "",
      tableData: [],
      listLoading: false,
      role: []
    };
  },
  created() {
    this.getList();
  },
  mounted() {},
  methods: {
    clearAll(){
      this.formData.username = "",
      this.formData.description = "",
      this.formData.dataTime = ""
    },
    getList(){
      this.listLoading = true;
      let _this = this;
      this.api({
        url:"/log/getAllSysLog",
        method:"post",
        data:this.initQuery
      }).then((result) => {
        _this.pageNum = 1;
        _this.pageTotal = result.total
        _this.tableData = result.list
        _this.listLoading = false;
      }).catch((err) => {
        
      });

    },
    queryAllLog() {
      let startTime = null;
      let endTime = null;
      if(this.formData.dataTime != ""){
        startTime = this.$moment(this.formData.dataTime[0]).format('YYYY-MM-DD HH:mm:ss') ;
        endTime = this.$moment(this.formData.dataTime[1]).format('YYYY-MM-DD HH:mm:ss') ;
      }
      let _this = this;
      let params = {
        pageSize:10,
        pageNum:1,
        sysLog:this.formData,
        startTime:startTime,
        endTime:endTime,
        sysLog:this.formData
      }
      console.log(params)
      this.api({
        url:"/log/getAllSysLog",
        method:"post",
        data:params
      }).then((result) => {
        console.log(result)
        _this.tableData = result.list;
        _this.pageTotal = result.total
      }).catch((err) => {
        
      });
    },
    handleCurrentChange(val) {
      let _this = this;
      let pageRow = this.pageRow;
      let params = {
        pageNum:val,
        pageSize:pageRow,
        sysLog:this.formData
      }
      this.api({
        url:"/log/getAllSysLog",
        method:"post",
        data:params
      }).then((data) => {
        console.log(data.list)
        _this.tableData = data.list;
      }).catch((err) => {
        
      });
    },
    handleSizeChange(val) {
      // console.log(val);
      let _this = this;
      let pageNum = this.pageNum;
      let startTime = null;
      let endTime = null;
      this.pageRow = val;
      if(this.formData.dataTime != ''){
        startTime = this.$moment(this.formData.dataTime[0]).format('YYYY-MM-DD HH:mm:ss') 
        endTime = this.$moment(this.formData.dataTime[1]).format('YYYY-MM-DD HH:mm:ss') 
      }
      let params = {
        pageNum : pageNum,
        pageSize:val,
        startTime:startTime,
        endTime:endTime,
        sysLog:this.formData
      }
      this.api({
        url:"/log/getAllSysLog",
        method:"post",
        data:params
      }).then((result) => {
        console.log(result.list)
        _this.tableData = result.list
      }).catch((err) => {
        
      });
    }
  }
};
</script>


<style scoped>
</style>


