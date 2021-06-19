<template>
	<div class="app-topbar">
		<div class="app-topbar__collapse" @click="UpdateCollapse(!menuCollapse)">
			<i :class="[menuCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold']"></i>
		</div>
		<div class="app-topbar__user">
			<el-dropdown trigger="click">
				<span class="el-dropdown-link">
					<span class="name">{{ user.username }}</span>
					<el-avatar src="https://i.gtimg.cn/club/item/face/img/2/16022_100.gif"></el-avatar>
				</span>
				<template #dropdown>
					<el-dropdown-menu>
						<el-dropdown-item>个人中心</el-dropdown-item>
						<el-dropdown-item @click="exit">退出</el-dropdown-item>
					</el-dropdown-menu>
				</template>
			</el-dropdown>
		</div>
	</div>
</template>
<script>
import { mapGetters, mapMutations, mapState } from 'vuex'
export default {
	computed: {
		...mapGetters("msg", ["menuCollapse"]),
		...mapState(["user"]),
	},
	methods: {
		...mapMutations("msg", ["UpdateCollapse"]),
		exit() {
			localStorage.removeItem("user")
			this.$router.replace("/sign")
		}
	},
	mounted() {
		setTimeout(() => {
			this.user
		}, 1000);
	},
}
</script>
<style lang="scss" scoped>
.app-topbar {
	display: flex;
	align-items: center;
	height: 50px;
	padding: 0 10px;
	justify-content: space-between;

	&__collapse {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 40px;
		width: 40px;
		cursor: pointer;
		margin-right: 10px;

		i {
			font-size: 22px;
			color: #666;
		}
	}

	&__user {
		margin-right: 10px;
		cursor: pointer;

		.name {
			white-space: nowrap;
			margin-right: 15px;
		}
		.el-dropdown-link {
			display: flex;
			align-items: center;
		}
	}
}
</style>