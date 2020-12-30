<template>
    <div class="container">
        <el-form ref="form" :model="form" label-width="80px" class="form">
            <div class="title">注册</div>
            <el-form-item label="注册类型" class="register">
                <el-radio-group v-model="form.register" @change="registerType">
                    <el-radio label="学生注册"></el-radio>
                    <el-radio label="老师注册"></el-radio>
                </el-radio-group>
            </el-form-item>


            <el-form-item label="姓名">
                <el-input v-model="form.stu_name"></el-input>
            </el-form-item>

            <div v-show="!isStudent">
                <el-form-item label="教师ID">
                    <el-input v-model="form.stu_id" required="required"></el-input>
                </el-form-item>
                <el-form-item label="生日">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="生日日期" v-model="form.bir"
                                        style="width: 100%;"></el-date-picker>

                    </el-col>

                    <el-col :span="11">
                        <el-time-picker placeholder="选择时间" v-model="form.bir" style="width: 100%;"></el-time-picker>
                    </el-col>

                </el-form-item>
                <el-form-item label="职称">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="专业">
                    <el-input v-model="form.major"></el-input>
                </el-form-item>
                <el-form-item label="兼职">
                    <el-input v-model="form.part_time_teach"></el-input>
                </el-form-item>
                <el-form-item label="任职时间">
                    <el-col :span="11">
                        <el-date-picker
                                type="date"
                                placeholder="开始日期"
                                v-model="form.date1"
                                style="width: 100%;"
                        ></el-date-picker>
                    </el-col>

                    <el-col :span="11">
                        <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                    </el-col>


                </el-form-item>
                <el-form-item label="结束时间" style="width: fit-content">
                    <el-col :span="11">
                        <el-date-picker
                                type="date"
                                placeholder="结束日期"
                                v-model="form.date2"
                                style="width: 100%;"
                        ></el-date-picker>
                    </el-col>
                    <el-col :span="11">
                        <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                    </el-col>

                </el-form-item>
            </div>
            <div v-show="isStudent">
                <el-form-item label="学号">
                    <el-input v-model="form.stu_id"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="form.email"></el-input>
                </el-form-item>
            </div>
            <el-form-item label="密码">
                <el-input type="password" v-model="form.pwd"></el-input>
            </el-form-item>
            <el-form-item label="性别" @change="changeSex">
                <el-radio-group v-model="form.sex">
                    <el-radio label="男"></el-radio>
                    <el-radio label="女"></el-radio>
                </el-radio-group>
            </el-form-item>

            <el-form-item>
                <div class="button">
                    <el-button type="primary" @click="onSubmit">立即注册</el-button>
                </div>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import {register_s, register_t} from '../index'

    export default {
        data() {
            return {
                form: {
                    stu_name: "",
                    region: "",
                    date1: "",
                    date2: "",
                    delivery: false,
                    type: [],
                    register: "学生注册",
                    desc: "",
                    sex: "",
                    pwd: "",
                    email: "",
                    phonenum: "",
                    title: "",
                    major: "",
                    stu_id: "",
                    tch_id: "",
                    bir: "",
                    part_time_teach: ""
                },
                isStudent: true
            };
        },
        methods: {
            onSubmit() {
                this.isStudent ? this.Register() : this.Register_t()
                this.$router.push('/')
            },
            registerType(e) {
                this.form.register = e;
                this.isStudent = e === "学生注册" ? true : false;
            },
            changeSex(e) {
                this.form.sex = e;
            },
            Register() {
                let {stu_name, sex, stu_id, pwd, email} = this.form
                register_s(res => {
                    if(res.res==="success"){
                        alert("注册成功");
                    }
                }, {
                    stu_name, sex, pwd, email, stu_id
                })
            },
            Register_t() {
                let {
                    tch_id,
                    sex,
                    bir,
                    title,
                    major,
                    part_time_teach,
                    app_time,
                    pwd
                } = this.form
                register_t(res => {
                    if(res.res==="success"){
                        alert("注册成功");
                    }
                }, {
                    tch_id: this.form.stu_id,
                    tch_name: this.form.stu_name,
                    sex,
                    bir,
                    title,
                    major,
                    part_time_teach,
                    app_time: "2010-2021",
                    pwd
                })
            }
        }
    };
</script>

<style lang="less" scoped>
    .container {
        display: flex;
        justify-content: center;

        .title {
            font-size: 22px;
            text-align: center;
            margin-bottom: 30px;
        }

        .register {

        }

        .form {
            margin-top: 100px;
        }

        .button {
            text-align: center;
        }
    }
</style>
