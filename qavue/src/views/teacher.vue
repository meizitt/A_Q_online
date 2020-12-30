<template>
    <div class="container">
        <el-button  @click="exitLogin" class="button">退出</el-button>
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="全部问题" name="first">
                <div class="container">
                    <el-table
                            :data="AllQuest"
                            border
                            style="width: 100%">
                        <el-table-column
                                prop="q_id"
                                label="问题id"
                                width="70">
                        </el-table-column>
                        <el-table-column
                                prop="q_text"
                                label="问题"
                                width="300">
                        </el-table-column>
                        <el-table-column
                                prop="answer_text"
                                label="答案"
                                width="300">
                        </el-table-column>
                        <el-table-column
                                prop="sub_time"
                                label="提问时间"
                                width="100">
                        </el-table-column>
                        <el-table-column
                                prop="answer_time"
                                label="回答时间"
                                width="100">
                        </el-table-column>
                        <el-table-column
                                prop="stu_name"
                                label="提问学生"
                                width="100">
                        </el-table-column>

                        <el-table-column
                                prop="tch_name"
                                label="回答老师"
                                width="100">
                        </el-table-column>


                        <el-table-column
                                fixed="right"
                                label="操作"
                                width="100">
                            <template slot-scope="scope">
                                <el-button @click="findLabQ(scope.row)" type="primary" size="mini" icon="el-icon-edit"
                                           circle></el-button>
                                <el-button @click="delLabQ(scope.row)" type="danger" icon="el-icon-delete" circle
                                           size="mini"></el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </div>
            </el-tab-pane>
            <el-tab-pane label="添加问题" name="second">
                <el-form
                        :label-position="labelPosition"
                        :model="addQForm"
                        :rules="rules"
                        ref="addQForm"
                        label-width="80px"
                        style="width: 60%"
                        class="from"

                >
                    <!--用户名密码输入框-->
                    <el-form-item label="学生id" prop="stu_id">
                        <el-input v-model="addQForm.stu_id"></el-input>
                    </el-form-item>
                    <el-form-item label="学生姓名" prop="stu_name">
                        <el-input v-model="addQForm.stu_name"></el-input>
                    </el-form-item>
                    <el-form-item label="老师姓名" prop="tch_name">
                        <el-input v-model="addQForm.tch_name"></el-input>
                    </el-form-item>
                    <el-form-item label="问题内容" prop="q_text">
                        <el-input type="textarea" :rows="4" v-model="addQForm.q_text"></el-input>
                    </el-form-item>
                    <el-form-item label="问题答案">
                        <el-input v-model="addQForm.answer_text"></el-input>

                        <!--提交按钮-->

                    </el-form-item>
                    <el-button type="primary" class="button" @click="addQuest('addQForm')">提交</el-button>
                    <el-button type="info" class="button" @click="resetForm('addQForm')">重置</el-button>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="更新问题" name="three">

                <div class="container">
                    <el-form :label-position="labelPosition"
                             :model="labQ"
                             ref="labQ"
                             label-width="80px"
                             style="width: 60%"
                             class="from">
                        <el-form-item label="问题id" prop="q_id">
                            <el-input v-model="labQ.q_id" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="问题内容" prop="q_text">
                            <el-input v-model="labQ.q_text"></el-input>
                        </el-form-item>
                        <el-form-item label="答案" prop="answer_text">
                            <el-input v-model="labQ.answer_text"></el-input>
                        </el-form-item>
                        <el-form-item label="学生id" prop="stu_id">
                            <el-input v-model="labQ.stu_id"></el-input>
                        </el-form-item>
                        <el-form-item label="学生姓名" prop="stu_name">
                            <el-input v-model="labQ.stu_name"></el-input>
                        </el-form-item>
                        <el-form-item label="老师id" prop="tch_id">
                            <el-input v-model="labQ.tch_id"></el-input>
                        </el-form-item>
                        <el-form-item label="老师姓名" prop="tch_name">
                            <el-input v-model="labQ.tch_name"></el-input>
                        </el-form-item>

                        <!--按钮-->

                        <el-form-item>
                            <el-button type="primary" class="button" @click="updateLabQ ">修改</el-button>
                            <el-button type="info" class="button" @click="gotoFirst">返回</el-button>
                        </el-form-item>


                    </el-form>
                </div>

            </el-tab-pane>
            <el-tab-pane label="查寻问题" name="four">

                <div class="container" style="width: 80%">
                    <el-input type="textarea"
                              placeholder="请输入问题"
                              :autosize="{ minRows: 3, maxRows: 6}"
                              v-model="txt">
                    </el-input>
                    <el-button type="primary" @click="findQByT">查询</el-button>
                    <div class="container">
                        <el-table
                                :data="fQ"
                                border
                                style="width: 100%">
                            <el-table-column
                                    prop="q_id"
                                    label="问题id"
                                    width="70">
                            </el-table-column>
                            <el-table-column
                                    prop="q_text"
                                    label="问题"
                                    width="200">
                            </el-table-column>
                            <el-table-column
                                    prop="answer_text"
                                    label="答案"
                                    width="200">
                            </el-table-column>
                            <el-table-column
                                    prop="sub_time"
                                    label="提交时间"
                                    width="100">
                            </el-table-column>
                            <el-table-column
                                    prop="answer_time"
                                    label="回答时间"
                                    width="100">
                            </el-table-column>

                            <el-table-column
                                    fixed="right"
                                    label="操作"
                                    width="100">
                                <template slot-scope="scope">
                                    <el-button @click="answerQ(scope.row)" icon="el-icon-chat-dot-round"
                                               size="small"
                                               circle></el-button>

                                </template>
                            </el-table-column>


                        </el-table>

                    </div>

                </div>


            </el-tab-pane>
            <el-tab-pane label="常见问题" name="five">


                <div class="container" style="width: 80%">
                    <el-input type="textarea"
                              placeholder="请输入问题"
                              :autosize="{ minRows: 3, maxRows: 6}"
                              v-model="txtt">
                    </el-input>
                    <el-button type="primary" @click="findCommQ">查询</el-button>
                    <div class="container">
                        <el-table
                                :data="fQQ"
                                border
                                style="width: 100%">
                            <el-table-column
                                    prop="q_id"
                                    label="问题id"
                                    width="70">
                            </el-table-column>
                            <el-table-column
                                    prop="text"
                                    label="问题"
                                    width="200">
                            </el-table-column>
                            <el-table-column
                                    prop="answer"
                                    label="答案"
                                    width="200">
                            </el-table-column>
                            <el-table-column
                                    prop="num"
                                    label="查询次数"
                                    width="100">
                            </el-table-column>
                            <el-table-column
                                    prop="time"
                                    label="回答时间"
                                    width="100">
                            </el-table-column>

                        </el-table>

                    </div>

                </div>


            </el-tab-pane>
        </el-tabs>


    </div>
</template>

<script>
    import {getAllQ, addQuestion,
        updateQuestion, deleteQues,
        findQById, updateAnswer,
        findComm, findQBytext} from '../index'

    export default {
        data() {
            return {
                labelPosition: "right",
                activeName: "first",
                AllQuest: [],
                fQ: [],
                fQQ:[],
                txt: "",
                txtt:"",
                answer:"",
                labQ: {
                    stu_id: "",
                    stu_name: "",
                    tch_name: "",
                    q_text: "",
                    answer_text: "",
                    q_id: ""
                },
                addQForm: {
                    stu_id: "",
                    stu_name: "",
                    tch_name: "",
                    q_text: "",
                    answer_text: "",
                    q_id: ""
                },
                rules: {
                    stu_id: [
                        {required: true, message: '输入学生id', trigger: 'blur'},
                        {message: '请输入正确id', trigger: 'blur'}
                    ],
                    q_text: [
                        {required: true, message: '输入问题', trigger: 'blur'},
                        {message: '问题不能为空', trigger: 'blur'}

                    ],
                    stu_name: [
                        {required: true, message: '输入姓名', trigger: 'blur'},
                        {message: '姓名不能为空', trigger: 'blur'}
                    ]

                }
            }


        },
        mounted() {
            this.getAllQues()
        },
        methods: {
            submitForm(formName) {
            },
            handleClick(row) {
            },
            exitLogin(){
              this.$router.push("/")
            },
            findCommQ(){
                findComm(res => {
                    this.fQQ = res
                    if (res.length == 0) {
                        this.$message(
                            {
                                type: 'warning',
                                message: '题库不存在要查询的问题'
                            }
                        )
                    }
                }, this.txtt)
            },
            findLabQ(row) {

                // console.log(row.q_id)
                findQById(res => {
                    this.labQ = res
                    this.activeName = "three";
                }, row.q_id);

            },
            answerQ(row) {

                this.$prompt('请输入答案', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                }).then(({ value }) => {
                     row.answer_text=value;
                    updateAnswer(res => {
                        res.res=="success"?this.$message({
                            type: 'success',
                            message: '提交成功'
                        }):null
                    },row)

                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '取消输入'
                    });
                });


            },
            findQByT() {

                findQBytext(res => {
                    this.fQ = res
                    if (res.length == 0) {
                        this.$message(
                            {
                                type: 'warning',
                                message: '题库不存在要查询的问题'
                            }
                        )
                    }
                }, this.txt)
            },
            delLabQ(row) {
                this.$confirm('是否删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                    deleteQues(res => {
                        res.res === "success" ? this.$message({
                            type: 'success',
                            message: '删除成功!'
                        }) : this.$message({
                            type: 'info',
                            message: '删除失败!'
                        });
                    }, row.q_id);
                    this.gotoFirst()
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                })
            },
            updateLabQ() {
                updateQuestion(res => {
                    if (res.res === "success") {
                        this.$message({
                            message: "添加成功",
                            type: "success"
                        });
                        this.gotoFirst()
                    }
                }, this.labQ)
            },
            getAllQues() {
                getAllQ(res => {
                    this.AllQuest = res
                })
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },

            addQuest(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let {
                            stu_id,
                            stu_name,
                            tch_name,
                            q_text,
                            answer_text
                        } = this.addQForm
                        addQuestion(res => {
                            this.$message({
                                message: "添加成功",
                                type: "success"
                            })
                        }, {
                            stu_id,
                            stu_name,
                            tch_name,
                            q_text,
                            answer_text
                        });
                        this.gotoFirst();
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            gotoFirst() {
                window.location.reload()
                this.activeName = "first"
            },
        }
    };
</script>

<style>
</style>
