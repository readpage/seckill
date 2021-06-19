<template>
<div class="home-box">
  <el-skeleton :loading="loading" animated :count="10" class="card-box">
    <template #template>
      <div>
        <el-skeleton-item variant="image" style="width: 100%; height: 240px;" />
        <el-skeleton-item variant="text" style="margin-right: 16px;" />
        <el-skeleton-item variant="text" style="width: 30%;" />
      </div>
    </template>
    <template #default>
      <div class="card-box">
        <el-card :body-style="{ padding: '0px' }" shadow="hover" v-for="(good, index) in goods.list" :key="index">
          <div class="card-container">
            <router-link :to="{path:'/home'}">
              <div class="card-img">
                <el-image :src="good.img" class="shop-image" fit="cover"></el-image>
                <span class="overlay"></span>
              </div>
            </router-link>
            <div class="linecamp">
              <div class="font-style ellipsis">{{ good.name }}</div>
            </div>
            <div class="store-style ellipsis">
              <span >{{ good.store }}</span>
            </div>
            <div class="count-info">
              <span>已抢{{ good.sales }}件</span>
              <span>库存剩余量{{ good.stock }}</span>
            </div>
            <div class="card-bottom">
              <div class="time-info">
                  <span class="discounts">限时优惠&nbsp;</span>
                  <span class="down-time">{{ good.downTime }}</span>
              </div>
              <span style="color: red;">￥{{ good.price }}</span>
              <el-button class="seckill-btn" type="danger" size="mini" @click="buy(good)">立即抢购</el-button>
            </div>
            <div>
            </div>
          </div>
        </el-card>
      </div>
    </template>
  </el-skeleton>
   <div class="load-btn">
    <el-button @click="handlerLoad" type="info" icon="el-icon-refresh" :loading="loading2" size="mini">{{loadText}}</el-button>
  </div>
</div>
</template>

<script>
import { mapActions,  mapMutations,  mapState} from "vuex";
export default {
  data() {
    return {
      urls: [
        "/api/img/carousel1.jpg",
        "/api/img/carousel2.jpg",
        "/api/img/carousel3.jpg",
        "/api/img/carousel4.jpg",
      ],
      cardIsActive: true,
      disabled: false,
      pageSize: 10,
      goods: {},
      loading: true,
      loadText: "加载更多",
      loading2: false,
    };
  },
  methods: {
    buy(val) {
      const t = this
      if (localStorage.user) {
        t.axios.post("/api/orders/add/seckill/" +t.user.id+ "/" +val.id)
          .then(res => {
            t.$message.success(res.data.message)
            t.page()
          }).catch(err => {
            t.$message.error(err.response.data.message)
          })
      } else {
        t.$router.push("/sign")
      }
    },
    handlerLoad() {
      const t = this;
      t.loading2 = true;
      if (t.pageSize >= t.goods.total) {
        t.loadText="没有更多了"
        t.loading2 = false
      } else {
        t.pageSize+=10;
        t.page();
      }
    },
    handlerDownTime(val) {
      const diffTime = dayjs.duration(dayjs(val, "YYYY-MM-DD HH:mm:ss") - dayjs());
      const day = diffTime.days(); //天
      const hours = diffTime.hours(); //小时
      const minutes = diffTime.minutes(); //分钟
      const seconds = diffTime.seconds(); //秒

      if (diffTime.months()) {
        return `${diffTime.months()}月${day}天${hours}:${minutes}:${seconds}`
      }
      return `${day}天${hours}:${minutes}:${seconds}`
    },
    setDownTime() {
      this.goods.list.forEach(item => {
        item.downTime = this.handlerDownTime(item.goodsSeckill.endDate)
      });
    },
    page() {
      const t = this
      t.axios.get("/api/goods/pageSeckill/1/" +t.pageSize+ "?name=" +t.urlName)
        .then(res => {
          let goods = res.data;
          goods.list.forEach(item => {
            item.img = "/api/img/" + item.img;
          });
          t.goods = goods
          t.loading = false
          t.loading2 = false
        })
    },
    changeCard() {
      window.onresize = () => {
        let screenWidth = document.body.clientWidth;
        if (screenWidth <= 1024) {
          this.cardIsActive = false;
        } else {
          this.cardIsActive = true;
        }
      };
    },
  },
  computed: {
    ...mapState(["user", "urlName"]),
  },
  created() {
    this.page();
  },
  mounted() {
    if (document.body.clientWidth < 1024) {
      this.cardIsActive = false;
    }
    this.changeCard();
    setInterval(() => {
      this.setDownTime()
    }, 1000);
  },
  watch: {
    urlName: function(val) {
      this.page()
    }
  },
};
</script>

<style lang="scss">

.home-box {
  .load-btn {
    margin-top: 20px;
    display: flex;
    justify-content: center;
  }
  .card-box {
    margin-top: 20px;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    gap: 20px;

    .linecamp {
      overflow: hidden;
      height: 40px;
      padding: 0 8px;
      margin: 8px 0;
      line-height: 20px;
    }

    .store-style {
      color: #9199A1;
      font-size: 12px;
      padding:0 8px;
      margin-bottom: 8px;
      -webkit-line-clamp: 1 !important;
    }

    .count-info {
      font-size: 12px;
      color: #9199A1;
      padding: 0 8px;
      margin-bottom: 8px;
      span {
        margin-right: 20px;
      }
    } 
    .card-bottom {
      font-size: 12px;
      color: #9199A1;
      line-height: 18px;
      padding: 0 8px;
      height: 30px;
      margin-bottom: 10px;
      display: flex;
      justify-content: space-evenly;
      .time-info {
        height: 18px;
        box-sizing: border-box;
        .discounts {
          color: #fff;
          font-family: Arial, Helvetica, sans-serif;
          padding: 3.2px;
          background-color: rgba(242, 13, 13, 0.6);
        }
        .down-time {
          color: #F76E6E;
          padding: 1px;
          border: 1px solid #F76E6E;
        }
      }
    }
    .shop-image {
      width: 100%;
      height: 100%;
    }


    .card-container {
      position: relative;

      .card-img {
        overflow: hidden;
        position: relative;

        .el-image {
          overflow: visible;
        }

        img {
          transition: all .5s ease-out;
        }

        .overlay {
          transition: opacity .5s ease-out;
          position: absolute;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          background-color: #000;
          opacity: 0;
        }
      }
      .seckill-btn {
        position: absolute;
        display: none;
        top: calc(50% - 40px);
        left: calc(50% - 40px)
      }

    }

    .card-container:hover {
      img {
        transform: scale(1.1);
      }
      .overlay {
        opacity: .2;
      }
      .seckill-btn {
        display: block;
      }
      .seckill-btn {
        display: block;
      }
    }
  }
}

@media (max-width: 768px) {
  .home-box {
    .card-box {
      grid-template-columns: repeat(2, 1fr);
    }
  }
}

@media (min-width: 768px) and (max-width: 992px) {
  .home-box .card-box {
    grid-template-columns: repeat(3, 1fr);
  }
}

@media (min-width: 992px) and (max-width: 1400px) {
  .home-box .card-box {
    grid-template-columns: repeat(4, 1fr);
  }
}
</style>
