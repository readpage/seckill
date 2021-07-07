<template>
  <div class="container">
    <el-card>
      <div class="handle-box">
        <el-space :size="10">
          <el-button type="primary" size="mini" icon="el-icon-plus" @click="addVisible=true">新增</el-button>
          <el-button type="success" size="mini" icon="el-icon-edit" :disabled="updateDisable" @click="handleUpdate(multipleSelection[0])">修改</el-button>
          <el-popconfirm title="你确定要删除选中的数据吗?"
            @confirm="handleDeleteBatch(multipleSelection)">
            <template #reference>
              <el-button type="danger" size="mini" icon="el-icon-delete" :disabled="deleteDisable">删除</el-button>
            </template>
          </el-popconfirm>
        </el-space>
      </div>
      <el-table
        :data="tableData"
        stripe
        :header-cell-style="{ background: '#f5f7fa', color: '#606266' }"
        @selection-change="handleSelectionChange"
        v-loading="loading"
        element-loading-text="拼命加载中"
        element-loading-spinner="el-icon-loading"
        height="400"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column
          label="用户名"
          prop="username"
          width="120"
          align="center"
        ></el-table-column>
        <el-table-column label="头像" align="center">
          <template #default="scope">
            <el-image :src="scope.row.avatar" style="height: 40px" :preview-src-list="[scope.row.avatar]" fit="contain"></el-image>
          </template>
        </el-table-column>
        <el-table-column label="手机号码" prop="phone"></el-table-column>
        <el-table-column label="创建时间" show-overflow-tooltip prop="createTime"></el-table-column>
        <el-table-column label="修改时间" show-overflow-tooltip prop="updateTime"></el-table-column>
        <el-table-column label="操作" align="center" fixed="right" width="125">
          <template #default="scope">
            <el-space>
              <el-button type="primary" size="mini" icon="el-icon-edit"
                @click="handleUpdate(scope.row)"></el-button>
              <el-popconfirm title="你确定要删除吗?"
                  @confirm="handleDelete(scope.row.id)">
                <template #reference>
                  <el-button type="danger" size="mini" icon="el-icon-delete"></el-button>
                </template>
              </el-popconfirm>
            </el-space>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination layout="total, sizes, prev, pager, next, jumper"
        small
        :total="total"
        :page-sizes="[5, 10, 20, 40]"
        :page-size="pageSize"
        background
        @current-change="handleCurrentChange"
        @size-change="handleSizeChange"
      ></el-pagination>
    </el-card>
    <!-- 修改的对话框 -->
    <el-dialog title="编辑用户" v-model="updateVisible"  center width="350px">
      <el-form :model="updateForm" ref="updateFormRef" :rules="rules" label-width="80px">
        <el-form-item label="姓名:" prop="username">
          <el-input v-model.trim="updateForm.username" size="small" prefix-icon="el-icon-user-solid"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password">
          <el-input show-password v-model.trim="updateForm.password" size="small" prefix-icon="el-icon-lock"></el-input>
        </el-form-item>
        <el-form-item>
          <el-space :size="40">
            <el-button size="small" type="primary" @click="update">确定</el-button>
            <el-button size="small" @click="updateVisible=false">取消</el-button>
          </el-space>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 添加对话框 -->
    <el-dialog title="添加用户" v-model="addVisible" @close="handleClosed" center width="350px">
      <el-form :model="addForm" ref="addFormRef" :rules="rules" label-width="80px">
        <el-form-item label="姓名:" prop="username">
          <el-input v-model.trim="addForm.username" size="small" prefix-icon="el-icon-user-solid"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password">
          <el-input show-password v-model.trim="addForm.password" size="small" prefix-icon="el-icon-lock"></el-input>
        </el-form-item>
        <el-form-item>
          <el-space :size="40">
            <el-button size="small" type="primary" @click="save">确定</el-button>
            <el-button size="small" @click="addVisible=false">取消</el-button>
          </el-space>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      total: 0,
      pageSize: 5,
      pageNum: 1,
      tableData: [],
      updateVisible: false,
      updateForm: {
        id: 0,
        username: "",
        password: ""
      },
      addVisible: false,
      addForm: {
        username: "",
        password: ""
      },
      rules: {
        username: { required: true, message: "请输入姓名!😂"},
        password: { required: true, message: "请输入密码!😂"}
      },
      updateDisable: true,
      deleteDisable: true,
      multipleSelection: [],
      loading: true,
    };
  },
  methods: {
    page() {
      const t=this;
      t.loading = true;
      t.axios.get("/api/user/page/" +t.pageNum+ "/" +t.pageSize)
        .then((result) => {
          t.tableData = result.data.list
          t.tableData.forEach(item => {
            if (item.phone) {
              let reg=/^(\d{3})\d{4}(\d{4})$/
              item.phone=item.phone.replace(reg, "$1****$2")
            }
          });
          t.tableData = result.data.list
          t.total = result.data.total;
          t.loading = false;
        }).catch((err) => {
          t.$message.error("出错了!");
        });
    },
    handleSizeChange(val) {
      this.pageSize=val;
      this.page();
    },
    handleCurrentChange(val) {
      this.pageNum=val;
      this.page();
    },
    update() {
      this.$refs.updateFormRef.validate((valid) => {
        if (valid) {
          const t = this;
          this.axios.put("/api/user/update", t.updateForm)
            .then((result) => {
              t.page();
              t.updateVisible=false;
              t.$notify.info({
                title: "消息",
                message: result.data.message
              })
            }).catch((err) => {
              t.$message.error("出错了!")
            });
        }
      })
    },
    handleUpdate(row) {
      this.updateForm = Object.assign({}, row);
      this.updateForm.password = "";
      this.updateVisible = true;
    },
    save() {
      this.$refs.addFormRef.validate((valid) => {
        if (valid) {
          const t = this;
          this.axios.post("/api/user/save", t.addForm)
            .then((result) => {
              t.page();
              t.addVisible=false;
              t.$notify.info({
                title: "消息",
                message: result.data.message
              })
            }).catch((err) => {
              t.$message.error("出错了😭");
            });
        }
      })
    },
    handleClosed() {
      this.$refs.addFormRef.resetFields();
    },
    handleSelectionChange(val) {
      this.updateDisable = val.length!=1;
      this.deleteDisable = val.length==0;
      this.multipleSelection = val;
    },
    handleDelete(id) {
      const t = this;
      this.axios.delete("/api/user/delete/" +id)
        .then((result) => {
          t.page();
          t.$notify.info({
            title: "信息",
            message: result.data.message
          })
        }).catch((err) => {
          t.$message.error("出错了!😭");
        });
    },
    handleDeleteBatch(data) {
      const list = data.map((item) => {
        return item.id;
      });
      const t = this;
      t.axios.delete("/api/user/deleteBatchId/" +list)
        .then((result) => {
          t.page();
          t.$notify.info({
            title: "信息",
            message: result.data.message
          })
        }).catch((err) => {
          t.$message.error("出错了!😭");
        });
    }
  }, 
  created() {
    this.page();
  },
};
</script>
<style lang="scss" scoped>
.container {
  .handle-box {
    margin-bottom: 20px;
  }
}
</style>
