<template>
<div class="home-box">
  <el-skeleton :loading="loading" animated>
    <template #template>
      <el-skeleton-item variant="image" style="width: 100%; height: 350px; margin-top: 20px;"></el-skeleton-item>
    </template>
    <template #default>
      <div class="carousel-box">
        <el-card style="margin-top: 20px;">
          <template v-if="cardIsActive">
            <el-carousel type="card" height="350px">
              <el-carousel-item v-for="(item, index) in urls" :key="index">
                <el-image :src="item" fit="contain" style="width: 100%; height: 300px;"></el-image>
              </el-carousel-item>
            </el-carousel>
          </template>
          <template v-else>
            <el-carousel type="none" height="350px">
              <el-carousel-item v-for="(item, index) in urls" :key="index">
                <el-image :src="item" fit="contain" style="width: 100%; height: 300px;"></el-image>
              </el-carousel-item>
            </el-carousel>
          </template>
        </el-card>
      </div>
    </template>
  </el-skeleton>
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
        <el-card :body-style="{ padding: '0px' }" shadow="hover" v-for="(good, index) in goods" :key="index">
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
            <div class="store-style ellipsis">{{ good.store }}</div>
            <div class="count-info">
              <span>销售量{{good.sales }}</span>
              <span>库存剩余量&nbsp;{{ good.stock }}</span>
            </div>
            <div class="card-bottom">
              <el-space>
                <el-tooltip class="but-cart" :disabled="!good.disabled" content="已添加购物车!" placement="top">
                  <div>
                    <el-button :disabled="good.disabled" type="danger" circle size="mini" icon="el-icon-shopping-cart-2" @click="setCart(good.id)"></el-button>
                  </div>
                </el-tooltip>
                <span style="color: red;">￥{{ good.price }}</span>
              </el-space>
            </div>
            <div>
            </div>
          </div>
        </el-card>
      </div>
    </template>
  </el-skeleton>
  <div class="load-btn">
    <el-button @click="handlerLoad" type="info" icon="el-icon-refresh" :loading="goods.loading2" size="mini">{{loadText}}</el-button>
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
      loadText: "加载更多",
    };
  },
  methods: {
    handlerLoad() {
      const t = this;
      t.goods.loading2 = true;
      let pageSize= t.goods.pageSize
      let total = t.goods.total
      if (pageSize>=total) {
        t.loadText="没有更多了"
        t.goods.loading2=false;
      } else {
        t.incrementCount(10);
      }
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
    setCart(id) {
      if (localStorage.user) {
        let result=this.goods.find(n => n.id === id);
        this.addCart(result)
        this.$message.success(`${result.name}商品添加成功!`)
      } else {
        this.$router.push("/sign")
      }
    },
    ...mapActions(["updateGoods", "incrementCount"]),
    ...mapActions({
      addCart: "addToCart"
    }),
  },
  computed: {
    ...mapState(["goods", "loading"])
  },
  created() {
    this.updateGoods();
  },
  mounted() {
    if (document.body.clientWidth < 1024) {
      this.cardIsActive = false;
    }
    this.changeCard();
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
    }
    .shop-image {
      width: 100%;
      height: 100%;
    }

    .card-container {
      .but-cart {
        display: none;
      }

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

    }

    .card-container:hover {
      img {
        transform: scale(1.1);
      }
      .but-cart {
        display: block;
      }
      .overlay {
        opacity: .2;
      }
    }
  }
}
@media (max-width: 768px) {
  .home-box .card-box {
    grid-template-columns: repeat(2, 1fr);
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
