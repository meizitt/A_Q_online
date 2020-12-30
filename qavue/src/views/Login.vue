<template>
    <div class="container">
        <div class="title">网上辅导答疑管理系统</div>
        <el-form
                :label-position="labelPosition"
                label-width="80px"
                class="from"
                :model="formLabelAlign"
        >
            <!--用户名密码输入框-->
            <el-form-item label="用户ID">
                <el-input v-model="stu_id"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="pwd"></el-input>

                <!--提交按钮-->
                <div class="btn">
                    <el-button class="button" @click="S_login">学生登入</el-button>
                    <el-button class="button" @click="T_login">教师登入</el-button>
                    <el-button type="primary" class="button" @click="toRegister">注册</el-button>
                </div>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    // @ is an alias to /src
    // import HelloWorld from '@/components/HelloWorld.vue'
    //
    // export default {
    //   name: 'Home',
    //   components: {
    //     HelloWorld
    //   }
    // }
    import {login_s, login_t} from '../index'

    export default {
        data() {
            return {
                labelPosition: "right",
                formLabelAlign: {
                    name: "",
                    region: "",
                    type: ""
                },
                stu_id: "",
                pwd: ""
            };
        },
        methods: {
            toRegister() {
                this.$router.push("register");
            },
            S_login() {
                this.logins()
            },
            logins() {
                let {stu_id, pwd} = this
                login_s(res => {

                    if (res.res === "success") {
                        this.$router.push("teacher");
                    } else {
                        alert("用户名或密码错误")
                    }

                }, {
                    stu_id, pwd
                })
            },
            loginT() {
                let {stu_id, pwd} = this
                login_t(res => {

                    if (res.res === "success") {
                        this.$router.push("teacher");
                    } else {
                        alert("用户名或密码错误")
                    }

                }, {
                    tch_id: stu_id, pwd
                })
            },
            T_login() {
                this.loginT()
            },
            Login() {
                login()
            }
        }
    };
</script>

<style lang="less" scoped>
    .container {
        .title {
            margin-top: 30vh;
            text-align: center;
            font-size: 22px;
        }

        .from {
            margin-top: 30px;
            width: 40vw;
            margin-left: 30vw;

            .btn {
                margin-top: 30px;
                display: flex;

                .button {
                    flex: 1;
                }
            }
        }
    }
</style>


