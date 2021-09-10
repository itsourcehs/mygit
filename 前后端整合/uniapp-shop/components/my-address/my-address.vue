<template>
	<view>
		<!-- 选择收货地址按钮 -->
		<view
		class="address-choose-box"
		v-if="JSON.stringify(address) === '{}'">
			<button
			class="btnChooseAddress"
			type="primary"
			size="mini"
			@click="chooseAddress">请选择收货地址+</button>
		</view>
		
		<!-- 渲染收货地址信息区域 -->
		<view class="address-info-box" v-else @click="chooseAddress">
			<view class="info">
				<view class="info-left">
					<view class="username">收货人: <text>{{address.userName}}</text></view>
				</view>
				<view class="info-right">
					<view class="phone">电话: <text>{{address.telNumber}}</text></view>
					<uni-icons type="arrowright" size="16"></uni-icons>
				</view>
			</view>
			<view class="info1">
				<view class="info1-left">收货地址: </view>
				<view class="info1-right">{{addstr}}</view>
			</view>
		</view>
		
		<!-- 底部边框线 -->
		<image
		class="address-border"
		src="../../static/线条2.png"></image>
	</view>
</template>

<script>
	// 按需导入 mapState 这个辅助函数
	import { mapState, mapMutations, mapGetters} from 'vuex'
	export default {
		name:"my-address",
		data() {
			return {
				// address: {} 由下方计算属性替换
				
			};
		},
		methods: {
			// 把 m_user模块的函数映射到当前组件
			...mapMutations('m_user', ['updateAddress']),
			async chooseAddress () {
				/* 
				  调用小程序提供的 chooseAddress() 方法
				  返回一个数组,数组第一项为错误对象,第二项为成功后的收货地址对象
				 */
				const [err, succ] = await uni.chooseAddress().catch(err => err)
				
				// 2.用户成功的选择了收获地址
				if (err === null && succ.errMsg === 'chooseAddress:ok') {
					// this.address = succ
					
					// 调用Store提供的 updateAddress 函数,将address保存到Store
					this.updateAddress(succ)
				}
				
				/* 3.用户没有授权
				if (err && err.errMsg === 'chooseAddress:fail auth deny') {
					// 调用 this.reAuth() 向用户重新发起授权申请
					this.reAuth()
				} */
				
				// 解决iphone真机上无法重新授权
				if (err && (err.errMsg === 'chooseAddress:fail auth deny' || err.errMsg === 'chooseAddress:fail authorize no response')) {
					// 调用 this.reAuth() 向用户重新发起授权申请
					this.reAuth()
				}
			},
			
			// 向用户重新发起授权申请
			async reAuth () {
				// 提示用户对地址进行授权
				const [err2, confirmResult] = await uni.showModal({
					content: '检测到你没有打开地址权限,是否去设置打开?',
					confirmText: '确认',
					cancelText: '取消',
				})
				
				// 如果弹框异常,则直接退出
				if (err2) return
				
				if (confirmResult.cancel) return uni.$showMsg('你取消了地址授权! ')
				
				// 如果用户点击了确认,调用uni.openSetting()函数进入授权页面
				if (confirmResult.confirm) return uni.openSetting({
					success: (settingResult) => {
						// 授权结束,需要对授权的结果进一步判断
						if (settingResult.authSetting['scope.address']) return uni.$showMsg('授权成功! 请选择地址')
						if (!settingResult.authSetting['scope.address']) return uni.$showMsg('你取消了地址授权! ')
					}
				})
			}
		},
		computed: {
			// 把 m_user模块的address对象映射到当前组件,代替data中的address对象
			...mapState('m_user', ['address']),
			
			...mapGetters('m_user', ['addstr']),
		}
	}
</script>

<style lang="scss">
// 底部框线
.address-border {
	display: block;
	width: 100%;
	height: 5rpx;
}

// 收货地址盒子
.address-choose-box {
	height: 90rpx;
	display: flex;
	align-items: center;
	justify-content: center;
}

// 收货地址信息区域
.address-info-box {
	font-size: 12rpx;
	height: 90rpx;
	display: flex;
	flex-direction: column;
	justify-content: center;
	padding: 0 5rpx;
	
	.info {
		display: flex;
		justify-content: space-between;
		
		.info-right {
			display: flex;
			align-items: center;
			
			.phone {
				margin-right: 5rpx;
			}
		}
	}
	
	.info1 {
		display: flex;
		align-items: center;
		margin-top: 10rpx;
		
		.info1-left {
			white-space: nowrap;
		}
	}
}
</style>
