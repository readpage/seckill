<template>
<div class="container">
  <el-card>
    <div class="handle-box">
      <el-space :size="10">
        <el-button size="mini" icon="el-icon-refresh" @click="reload">刷新</el-button>
        <el-button type="primary" size="mini" icon="el-icon-plus" @click="addVisible=true">新增</el-button>
        <el-button type="success" size="mini" icon="el-icon-edit" :disabled="updateDisabled" @click="handleUpdate(multipleSelection[0])">修改</el-button>
        <seckill :update-disabled="updateDisabled" :multiple-selection="multipleSelection[0]"/>
        <el-popconfirm title="你确定要删除选中的数据吗?" @confirm="handleDeleteBatch(multipleSelection)">
          <template #reference>
            <el-button type="danger" size="mini" icon="el-icon-delete" :disabled="deleteDisabled">删除</el-button>
          </template>
        </el-popconfirm>
        <Type @type-event="typeSearch" />
        <search @search-event="querySearch" :type="urlType"/>
      </el-space>
    </div>
    <el-table :data="tableData" stripe 
      :header-cell-style="{ background: '#f5f7fa', color: '#606266' }" 
      @selection-change="handleSelectionChange" 
      v-loading="loading" element-loading-text="拼命加载中" 
      element-loading-spinner="el-icon-loading" height="450">
      <el-table-column type="selection" width="55px"></el-table-column>
      <el-table-column type="expand" label="详情">
        <template #default="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="商品id">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="商品名称">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="商品价格">
              <span>{{ props.row.price }}</span>
            </el-form-item>
            <el-form-item label="商品类型">
              <span>{{ props.row.type }}</span>
            </el-form-item>
            <el-form-item label="创建时间">
              <span>{{ props.row.createTime }}</span>
            </el-form-item>
            <el-form-item label="更新时间">
              <span>{{ props.row.updateTime }}</span>
            </el-form-item>
            <el-form-item label="版本">
              <span>{{ props.row.version }}</span>
            </el-form-item>
            <el-form-item label="商品秒杀开始时间">
              <span>{{ props.row.goodsSeckill.startDate }}</span>
            </el-form-item>
            <el-form-item label="商品秒杀结束时间">
              <span>{{ props.row.goodsSeckill.endDate }}</span>
            </el-form-item>
            <el-form-item label="状态">
              <span>{{ props.row.goodsSeckill.status?"开启":"关闭" }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="商品名称" prop="name" width="180" align="center" show-overflow-tooltip></el-table-column>
      <el-table-column label="商品图片" align="center" width="80">
        <template #default="scope">
          <el-image :src="scope.row.img" fit="contain" style="height: 40px" :preview-src-list="imgList"></el-image>
        </template>
      </el-table-column>
      <el-table-column label="商品价格" width="80" prop="price"></el-table-column>
      <el-table-column label="商品类型">
        <template #default="scope">
          <el-tag>{{ scope.row.type }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="商品店铺" prop="store" width="150"></el-table-column>
      <el-table-column label="创建时间"  sortable show-overflow-tooltip prop="createTime" width="180"></el-table-column>
      <el-table-column label="修改时间" sortable show-overflow-tooltip prop="updateTime" width="170"></el-table-column>
      <el-table-column label="操作" align="center" fixed="right" width="125px">
        <template #default="scope">
          <el-space>
            <el-button type="primary" size="mini" icon="el-icon-edit" @click="handleUpdate(scope.row)"></el-button>
            <el-popconfirm title="你确定要删除吗?" @confirm="handleDelete(scope.row.id)">
              <template #reference>
                <el-button type="danger" size="mini" icon="el-icon-delete"></el-button>
              </template>
            </el-popconfirm>
          </el-space>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination layout="total, sizes, prev, pager, next, jumper" small :total="total" :page-sizes="[5, 10, 20, 40]" :page-size="pageSize" background @current-change="handleCurrentChange" @size-change="handleSizeChange"></el-pagination>
  </el-card>
  <!-- 修改对话框 -->
  <el-dialog title="编辑商品" v-model="updateVisible" center width="500px">
    <el-form :model="updateForm" ref="updateFormRef" :rules="rules" label-width="80px">
      <el-form-item label="名称" prop="name">
        <el-input v-model="updateForm.name" size="small"></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model.number="updateForm.price" size="small"></el-input>
      </el-form-item>
      <el-form-item label="库存" prop="stock">
        <el-input v-model.number="updateForm.stock" size="small"></el-input>
      </el-form-item>
       <el-form-item label="类型" prop="type">
        <el-select v-model="updateForm.type" size="small" placeholder="请选择商品类型" clearable>
          <el-option
            v-for="item in options"
            :key="item"
            :value="item"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="店铺" prop="store">
        <el-input v-model="updateForm.store" size="small"></el-input>
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
  <el-dialog title="添加商品" v-model="addVisible" @close="handleClosed" center width="500px">
    <el-form :model="addForm" ref="addFormRef" :rules="rules" label-width="80px">
      <el-form-item label="名称:" prop="name">
        <el-input v-model="addForm.name" size="small"></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model.number="addForm.price" size="small"></el-input>
      </el-form-item>
      <el-form-item label="库存" prop="stock">
        <el-input v-model.number="addForm.stock" size="small"></el-input>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="addForm.type" size="small" placeholder="请选择商品类型" clearable>
          <el-option
            v-for="item in options"
            :key="item"
            :value="item"
          ></el-option>
        </el-select>
      </el-form-item> 
      <el-form-item label="店铺" prop="store">
        <el-input v-model="addForm.store" size="small"></el-input>
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
import seckill from './components/seckill.vue'
import Type from './components/Type.vue';
import search from './components/search.vue';
import { ElLoading } from 'element-plus'
export default {
  inject: ['reload'],
  components: {
    search,
    Type,
    seckill
  },
  data() {
    return {
      tableData: [],
      imgList: [],
      total: 0,
      pageSize: 5,
      pageNum: 1,
      updateForm: {
        id: 0,
        name: "",
        price: "",
        store: "",
        type: "",
        stock: "",
      },
      updateVisible: false,
      rules: {
        name: {
          required: true,
          message: "请输入名称😂"
        },
        price: [{
            required: true,
            message: "请输入价格😂"
          },
          {
            type: "number",
            message: "价格必须是数字值"
          },
        ],
        stock: [{
            required: true,
            message: "请输入库存😂"
          },
          {
            type: "number",
            message: "库存必须是数字值"
          },],
        store: {
          required: true,
          message: "请输入店铺😂"
        },
        type: {
          required: true,
          message: "请选择类型"
        }
      },
      updateDisabled: true,
      deleteDisabled: true,
      addVisible: false,
      addForm: {
        name: "",
        price: "",
        store: "",
        stock: "",
        type: "",
      },
      multipleSelection: [],
      loading: true,
      urlName: "",
      urlType: "",
      options: [],
      LOptions: {
        text: "拼命加载中...",
        spinner: "el-icon-loading"
      }
    }
  },
  methods: {
    querySearch(data) {
      this.urlName=data
      this.page();
    },
    typeSearch(data) {
      this.urlType=data
      this.page()
    },
    page() {
      const t = this;
      t.loading = true;
      t.axios.get("/api/goods/page/" + t.pageNum + "/" + t.pageSize +"?name=" +t.urlName+ "&type=" +t.urlType)
        .then((result) => {
          t.total = result.data.total;
          t.tableData = result.data.list;
          t.tableData.forEach(el => {
            el.img = "/api/img/" +el.img
          });
          t.imgList = t.tableData.map(item => item.img)
          t.loading = false;
        }).catch((err) => {
          t.$message.error("404!");
        });
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.page();
    },
    handleCurrentChange(val) {
      this.pageNum = val;
      this.page();
    },
    handleUpdate(row) {
      this.updateForm = Object.assign({}, row);
      console.log(this.updateForm)
      this.updateVisible = true;
    },
    update() {
      this.$refs.updateFormRef.validate((valid) => {
        if (valid) {
          const t = this;
          let loading = ElLoading.service(t.LOptions)
          let param = t.updateForm
          t.axios.put("/api/goods/update/" +param.id, param)
            .then((result) => {
              t.updateVisible = false;
              t.$notify.info({
                title: "消息",
                message: result.data.message
              })
              loading.close()
              t.reload()
            }).catch((err) => {
              loading.close()
              t.$message.error("出错了!")
            });
        }
      })
    },
    handleClosed() {
      this.$refs.addFormRef.resetFields();
    },
    save() {
      this.$refs.addFormRef.validate((valid) => {
        if (valid) {
          const t = this;
          let loading = ElLoading.service(t.LOptions)
          t.axios.post("/api/goods/save", t.addForm)
            .then((result) => {
              t.addVisible = false;
              t.$notify.info({
                title: "消息",
                message: result.data.message
              })
              loading.close()
              t.reload()
            }).catch((err) => {
              loading.close()
              t.$message.error("出错了😭");
            });
        }
      })
    },
    handleSelectionChange(val) {
      this.updateDisabled = val.length != 1;
      this.deleteDisabled = val.length == 0;
      this.multipleSelection = val;
    },
    handleDeleteBatch(data) {
      const list = data.map((item) => {
        return item.id;
      });
      const t = this;
      t.axios.delete("/api/goods/deleteBatchId/" + list)
        .then((result) => {
          t.page();
          t.$notify.info({
            title: "消息",
            message: result.data.message
          })
        }).catch((err) => {
          t.$message.error("出错了!😭")
        });
    },
    handleDelete(id) {
      const t = this;
      t.axios.delete("/api/goods/delete/" + id)
        .then((result) => {
          t.page()
          t.$notify.info({
            title: "消息",
            message: result.data.message
          })
        }).catch((err) => {
          t.$notify.error("出错了!😭");
        });
    },
    goodsType() {
      const t = this;
      t.axios.get("/api/goods/type")
        .then(res => {
          t.options=res.data
        })
    }
  },
  created() {
    this.page();
    this.goodsType();
  },
}
</script>

<style lang="scss">
.container {
  .handle-box {
    margin-bottom: 20px;
  }
}
.demo-table-expand {
  font-size: 0;
  label {
    color: #99a9bf;
  }
  .el-form-item {
    margin: 0;
    width: 50%;
  }
}
</style>
