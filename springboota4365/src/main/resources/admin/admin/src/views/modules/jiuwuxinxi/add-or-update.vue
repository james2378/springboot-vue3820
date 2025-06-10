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
        <el-form-item  v-if="type!='info'"  label="卖家名" prop="maijiaming">
          <el-input v-model="ruleForm.maijiaming" 
              placeholder="卖家名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.maijiaming" label="卖家名" prop="maijiaming">
              <el-input v-model="ruleForm.maijiaming" 
                placeholder="卖家名" readonly></el-input>
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
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="旧物类型" prop="jiuwuleixing">
          <el-select v-model="ruleForm.jiuwuleixing" placeholder="请选择旧物类型">
            <el-option
                v-for="(item,index) in jiuwuleixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiuwuleixing" label="旧物类型" prop="jiuwuleixing">
              <el-input v-model="ruleForm.jiuwuleixing" 
                placeholder="旧物类型" readonly></el-input>
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
                                                                                                </el-row>
                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="置换需求" prop="zhihuanxuqiu">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="置换需求"
                  v-model="ruleForm.zhihuanxuqiu">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.zhihuanxuqiu" label="置换需求" prop="zhihuanxuqiu">
                    <span>{{ruleForm.zhihuanxuqiu}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                                                                                                  <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="旧物详情" prop="jiuwuxiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.jiuwuxiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.jiuwuxiangqing" label="旧物详情" prop="jiuwuxiangqing">
                    <span v-html="ruleForm.jiuwuxiangqing"></span>
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
                        maijiaming: '',
                                xingming: '',
                                shouji: '',
                                jiuwumingcheng: '',
                                jiuwuleixing: '',
                                jiuwutupian: '',
                                zhihuanxuqiu: '',
                                jiuwuxiangqing: '',
                                thumbsupnum: '',
                                crazilynum: '',
                      },
                                                                                jiuwuleixingOptions: [],
                                                                                          rules: {
                  maijiaming: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  shouji: [
                                                                                              ],
                  jiuwumingcheng: [
                            { required: true, message: '旧物名称不能为空', trigger: 'blur' },
                                                                                              ],
                  jiuwuleixing: [
                            { required: true, message: '旧物类型不能为空', trigger: 'blur' },
                                                                                              ],
                  jiuwutupian: [
                                                                                              ],
                  zhihuanxuqiu: [
                                                                                              ],
                  jiuwuxiangqing: [
                                                                                              ],
                  thumbsupnum: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  crazilynum: [
                                        { validator: validateIntNumber, trigger: 'blur' },
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
                    if(o=='maijiaming'){
            this.ruleForm.maijiaming = obj[o];
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
                    if(o=='jiuwuleixing'){
            this.ruleForm.jiuwuleixing = obj[o];
            continue;
          }
                    if(o=='jiuwutupian'){
            this.ruleForm.jiuwutupian = obj[o];
            continue;
          }
                    if(o=='zhihuanxuqiu'){
            this.ruleForm.zhihuanxuqiu = obj[o];
            continue;
          }
                    if(o=='jiuwuxiangqing'){
            this.ruleForm.jiuwuxiangqing = obj[o];
            continue;
          }
                    if(o=='thumbsupnum'){
            this.ruleForm.thumbsupnum = obj[o];
            continue;
          }
                    if(o=='crazilynum'){
            this.ruleForm.crazilynum = obj[o];
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
                                    this.ruleForm.maijiaming = json.maijiaming
                                                this.ruleForm.xingming = json.xingming
                                                this.ruleForm.shouji = json.shouji
                                                                                                                                                                                        } else {
          this.$message.error(data.msg);
        }
      });
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
                                                                                        // 多级联动参数
                                                                                                                info(id) {
      this.$http({
        url: `jiuwuxinxi/info/${id}`,
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
            url: `jiuwuxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.jiuwuxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.jiuwuxinxiCrossAddOrUpdateFlag = false;
    },
                                                                                    jiuwutupianUploadChange(fileUrls) {
                this.ruleForm.jiuwutupian = fileUrls;
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
