<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">旧物置换网站注册</h1>
                              <el-form-item v-if="tableName=='yonghu'" label="用户名" prop="yonghuyonghuming">
        <el-input v-model="ruleForm.yonghuming" placeholder="用户名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="密码" prop="yonghumima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="姓名" prop="yonghuxingming">
        <el-input v-model="ruleForm.xingming" placeholder="姓名"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='yonghu'" label="手机" prop="yonghushouji">
        <el-input v-model="ruleForm.shouji" placeholder="手机"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="邮箱" prop="yonghuyouxiang">
        <el-input v-model="ruleForm.youxiang" placeholder="邮箱"></el-input>
      </el-form-item>
                                                                  <el-form-item v-if="tableName=='maijia'" label="卖家名" prop="maijiamaijiaming">
        <el-input v-model="ruleForm.maijiaming" placeholder="卖家名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='maijia'" label="密码" prop="maijiamima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='maijia'" label="姓名" prop="maijiaxingming">
        <el-input v-model="ruleForm.xingming" placeholder="姓名"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='maijia'" label="手机" prop="maijiashouji">
        <el-input v-model="ruleForm.shouji" placeholder="手机"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='maijia'" label="邮箱" prop="maijiayouxiang">
        <el-input v-model="ruleForm.youxiang" placeholder="邮箱"></el-input>
      </el-form-item>
                                                                                                                        <el-button @click="login()" class="btn-login" type="primary">注册</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                              if((!this.ruleForm.yonghuming) && `yonghu` == this.tableName){
        this.$message.error(`用户名不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `yonghu` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                            if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
        this.$message.error(`姓名不能为空`);
        return
      }
                                                                                                                                                                                    if(`yonghu` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮件格式`);
        return
      }
                                                                                                            if((!this.ruleForm.maijiaming) && `maijia` == this.tableName){
        this.$message.error(`卖家名不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `maijia` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                            if((!this.ruleForm.xingming) && `maijia` == this.tableName){
        this.$message.error(`姓名不能为空`);
        return
      }
                                                                                                                                                                                    if(`maijia` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮件格式`);
        return
      }
                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
