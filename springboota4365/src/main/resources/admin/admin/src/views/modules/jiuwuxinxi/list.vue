<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                            <el-form-item label="卖家名">
                <el-input v-model="searchForm.maijiaming" 
                    placeholder="卖家名" clearable></el-input>
              </el-form-item>
                                                                                                      <el-form-item label="旧物名称">
                <el-input v-model="searchForm.jiuwumingcheng" 
                    placeholder="旧物名称" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="旧物类型">
                <el-input v-model="searchForm.jiuwuleixing" 
                    placeholder="旧物类型" clearable></el-input>
              </el-form-item>
                                                                                                                                <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('jiuwuxinxi','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('jiuwuxinxi','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('jiuwuxinxi','查看')"
            :data="dataList"
            border
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler"
            style="width: 100%;">
            <el-table-column
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
                                            <el-table-column
                    prop="maijiaming"
                    header-align="center"
                    align="center"
                    sortable
                    label="卖家名">
                    <template slot-scope="scope">
                      {{scope.row.maijiaming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="xingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="姓名">
                    <template slot-scope="scope">
                      {{scope.row.xingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="shouji"
                    header-align="center"
                    align="center"
                    sortable
                    label="手机">
                    <template slot-scope="scope">
                      {{scope.row.shouji}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jiuwumingcheng"
                    header-align="center"
                    align="center"
                    sortable
                    label="旧物名称">
                    <template slot-scope="scope">
                      {{scope.row.jiuwumingcheng}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jiuwuleixing"
                    header-align="center"
                    align="center"
                    sortable
                    label="旧物类型">
                    <template slot-scope="scope">
                      {{scope.row.jiuwuleixing}}
                    </template>
                </el-table-column>
                                                              <el-table-column prop="jiuwutupian" 
                    header-align="center"
                    align="center" 
                    width="200" 
                    label="旧物图片">
                    <template slot-scope="scope">
                      <div v-if="scope.row.jiuwutupian">
                        <img :src="scope.row.jiuwutupian.split(',')[0]" width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
                                                            <el-table-column
                    prop="zhihuanxuqiu"
                    header-align="center"
                    align="center"
                    sortable
                    label="置换需求">
                    <template slot-scope="scope">
                      {{scope.row.zhihuanxuqiu}}
                    </template>
                </el-table-column>
                                                                                                                                                                                        <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('jiuwuxinxi','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                                <el-button v-if="isAuth('jiuwuxinxi','置换申请')" type="text" icon="el-icon-edit" size="small" @click="zhihuanjiaoyiCrossAddOrUpdateHandler(scope.row,'cross')">置换申请</el-button>
                                                                <el-button v-if="isAuth('jiuwuxinxi','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('jiuwuxinxi','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
                                                                                                                                                                                <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

            <zhihuanjiaoyi-cross-add-or-update v-if="zhihuanjiaoyiCrossAddOrUpdateFlag" :parent="this" ref="zhihuanjiaoyiCrossaddOrUpdate"></zhihuanjiaoyi-cross-add-or-update>
        
    
      </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
import zhihuanjiaoyiCrossAddOrUpdate from "../zhihuanjiaoyi/add-or-update";
export default {
  data() {
    return {
                                                                                                                              jiuwuleixingOptions: [],
                                                                                                                  searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
                  zhihuanjiaoyiCrossAddOrUpdateFlag: false,
                };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
            zhihuanjiaoyiCrossAddOrUpdate,
          },
  methods: {
            zhihuanjiaoyiCrossAddOrUpdateHandler(row,type){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.zhihuanjiaoyiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','jiuwuxinxi');
      this.$nextTick(() => {
        this.$refs.zhihuanjiaoyiCrossaddOrUpdate.init(row.id,type);
      });
    },
                    init () {
                                                                                                          this.$http({
            url: `option/jiuwuleixing/leixing`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.jiuwuleixingOptions = data.data;
            } else {
              this.$message.error(data.msg);
            }
          });
                                                                                                                                                                                                                                      },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                          if(this.searchForm.maijiaming!='' && this.searchForm.maijiaming!=undefined){
            params['maijiaming'] = '%' + this.searchForm.maijiaming + '%'
          }
                                                                                                        if(this.searchForm.jiuwumingcheng!='' && this.searchForm.jiuwumingcheng!=undefined){
            params['jiuwumingcheng'] = '%' + this.searchForm.jiuwumingcheng + '%'
          }
                                                            if(this.searchForm.jiuwuleixing!='' && this.searchForm.jiuwuleixing!=undefined){
            params['jiuwuleixing'] = '%' + this.searchForm.jiuwuleixing + '%'
          }
                                                                                                                                            this.$http({
        url: "jiuwuxinxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "jiuwuxinxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
