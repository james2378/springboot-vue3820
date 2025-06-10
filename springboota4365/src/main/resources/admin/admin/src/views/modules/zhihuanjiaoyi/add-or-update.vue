<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingming" label="姓名" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shouji" label="手机" prop="shouji">
              <el-input v-model="ruleForm.shouji" 
                placeholder="手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="旧物名称" prop="jiuwumingcheng">
          <el-input v-model="ruleForm.jiuwumingcheng" 
              placeholder="旧物名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiuwumingcheng" label="旧物名称" prop="jiuwumingcheng">
              <el-input v-model="ruleForm.jiuwumingcheng" 
                placeholder="旧物名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="旧物图片" prop="jiuwutupian">
          <file-upload
          tip="点击上传旧物图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.jiuwutupian?ruleForm.jiuwutupian:''"
          @change="jiuwutupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiuwutupian" label="旧物图片" prop="jiuwutupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jiuwutupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="置换物" prop="zhihuanwu">
          <el-input v-model="ruleForm.zhihuanwu" 
              placeholder="置换物" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhihuanwu" label="置换物" prop="zhihuanwu">
              <el-input v-model="ruleForm.zhihuanwu" 
                placeholder="置换物" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="物品图片" prop="wupintupian">
          <file-upload
          tip="点击上传物品图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.wupintupian?ruleForm.wupintupian:''"
          @change="wupintupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.wupintupian" label="物品图片" prop="wupintupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.wupintupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                                                              </el-row>
                                                                                                                                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="物品详情" prop="wupinxiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.wupinxiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.wupinxiangqing" label="物品详情" prop="wupinxiangqing">
                    <span v-html="ruleForm.wupinxiangqing"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
            ruleForm: {
                        yonghuming: '',
                                xingming: '',
                                shouji: '',
                                jiuwumingcheng: '',
                                jiuwutupian: '',
                                zhihuanwu: '',
                                wupintupian: '',
                                wupinxiangqing: '',
                                sfsh: '',
                                shhf: '',
                      },
                                                                                                                                                        rules: {
                  yonghuming: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  shouji: [
                                                                                              ],
                  jiuwumingcheng: [
                                                                                              ],
                  jiuwutupian: [
                                                                                              ],
                  zhihuanwu: [
                                                                                              ],
                  wupintupian: [
                                                                                              ],
                  wupinxiangqing: [
                                                                                              ],
                  sfsh: [
                                                                                              ],
                  shhf: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                              },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
            continue;
          }
                    if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
            continue;
          }
                    if(o=='shouji'){
            this.ruleForm.shouji = obj[o];
            continue;
          }
                    if(o=='jiuwumingcheng'){
            this.ruleForm.jiuwumingcheng = obj[o];
            continue;
          }
                    if(o=='jiuwutupian'){
            this.ruleForm.jiuwutupian = obj[o];
            continue;
          }
                    if(o=='zhihuanwu'){
            this.ruleForm.zhihuanwu = obj[o];
            continue;
          }
                    if(o=='wupintupian'){
            this.ruleForm.wupintupian = obj[o];
            continue;
          }
                    if(o=='wupinxiangqing'){
            this.ruleForm.wupinxiangqing = obj[o];
            continue;
          }
                    if(o=='sfsh'){
            this.ruleForm.sfsh = obj[o];
            continue;
          }
                    if(o=='shhf'){
            this.ruleForm.shhf = obj[o];
            continue;
          }
                  }
                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                    this.ruleForm.yonghuming = json.yonghuming
                                                this.ruleForm.xingming = json.xingming
                                                this.ruleForm.shouji = json.shouji
                                                                                                                                                                                        } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                  },
                                                                                        // 多级联动参数
                                                                                                                info(id) {
      this.$http({
        url: `zhihuanjiaoyi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `zhihuanjiaoyi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.zhihuanjiaoyiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.zhihuanjiaoyiCrossAddOrUpdateFlag = false;
    },
                                                                        jiuwutupianUploadChange(fileUrls) {
                this.ruleForm.jiuwutupian = fileUrls;
            },
                                            wupintupianUploadChange(fileUrls) {
                this.ruleForm.wupintupian = fileUrls;
            },
                                                  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
</style>
