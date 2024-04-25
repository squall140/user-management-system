<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="oldPassword" prop="oldPassword">
      <el-input v-model="user.oldPassword" placeholder="Please input the old password" type="password" show-password/>
    </el-form-item>
    <el-form-item label="newPassword" prop="newPassword">
      <el-input v-model="user.newPassword" placeholder="Please input the new password" type="password" show-password/>
    </el-form-item>
    <el-form-item label="confirm" prop="confirmPassword">
      <el-input v-model="user.confirmPassword" placeholder="Please input the new password" type="password" show-password/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">submit</el-button>
      <el-button type="danger" size="mini" @click="close">close</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateUserPwd } from "@/api/system/user";

export default {
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.user.newPassword !== value) {
        callback(new Error("The passwords entered twice are inconsistent!"));
      } else {
        callback();
      }
    };
    return {
      user: {
        oldPassword: undefined,
        newPassword: undefined,
        confirmPassword: undefined
      },
      // 表单校验
      rules: {
        oldPassword: [
          { required: true, message: "The old password cannot be empty", trigger: "blur" }
        ],
        newPassword: [
          { required: true, message: "The new password cannot be empty", trigger: "blur" },
          { min: 6, max: 20, message: "6 to 20 characters in length", trigger: "blur" },
          { pattern: /^[^<>"'|\\]+$/, message: "Cannot contain illegal characters：< > \" ' \\\ |", trigger: "blur" }
        ],
        confirmPassword: [
          { required: true, message: "confirm new password can not be blank", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateUserPwd(this.user.oldPassword, this.user.newPassword).then(response => {
            this.$modal.msgSuccess("modified!");
          });
        }
      });
    },
    close() {
      this.$tab.closePage();
    }
  }
};
</script>
