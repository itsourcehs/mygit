<template>
	<view>
		<view class="search-box">
			<uni-search-bar
			@input="input"
			:radius="100"
			cancelButton="none"></uni-search-bar>
		</view>
		
		<!-- 搜索建议列表 -->
		<view class="sugg-list" v-if="searchResults.length !== 0">
			<view class="sugg-item"
			v-for="(item, i) in searchResults"
			:key="i"
			@click="gotoDetail(item.goods_id)">
			    <view class="goods-name">{{item.goods_name}}</view>
			    <uni-icons type="arrowright" size="16"></uni-icons>
			</view>
		</view>
		
		<!-- 搜索历史区域 -->
		<view class="history-box" v-else>
			<!-- 标题区域 -->
			<view class="history-title" v-if="historyList.length !== 0">
			  <text>搜索历史</text>
			  <uni-icons type="trash" size="17"
			  @click="cleanHistory"></uni-icons>
			</view>
			<!-- 列表区域 -->
			<view class="history-list">
			  <uni-tag
			  :text="item"
			  v-for="(item, i) in historys"
			  :key="i"
			  @click="gotoGoodsList(item)"></uni-tag>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 延时器的timerId
				timer: null,
				// 搜索关键词
				kw: '',
				// 搜索结果数据列表
				searchResults: [],
				// 搜索历史数据列表
				historyList: ['a', 'app', 'apple']
			};
		},
		onLoad () {
			this.historyList = JSON.parse(uni.getStorageSync('kw') || '[]')
		},
		computed: {
			// 解决搜索关键字前后顺序问题
			historys () {return [...this.historyList].reverse()}
		},
		methods: {
			input (e) {
				// e.value 表示最新的搜索内容
				console.log(e);
				// 清除 timer 对应的延时器
				clearTimeout(this.timer)
				// 重新启动一个延时器，并把 timerId 赋值给 this.timer
				this.timer = setTimeout(() => {
					// 如果 600 毫秒内，没有触发新的输入事件，则为搜索关键词赋值
					this.kw = e
					// console.log(this.kw);
					this.getSearchList()
				},600)
			},
			saveSearchHistory () {
				// this.historyList.push(this.kw)
				// 1. 将 Array 数组转化为 Set 对象
				const set = new Set(this.historyList)
				// 2. 调用 Set 对象的 delete 方法，移除对应的元素
				set.delete(this.kw)
				// 3. 调用 Set 对象的 add 方法，向 Set 中添加元素
				set.add(this.kw)
				// 4. 将 Set 对象转化为 Array 数组
				this.historyList = Array.from(set)
				
				// 1.调用 uni.setStorageSync(key, value) 将搜索历史记录持久化存储到本地
				uni.setStorageSync('kw',JSON.stringify(this.historyList))
				// 2.在 onLoad 生命周期函数中，加载本地存储的搜索历史记录
			},
			async getSearchList () {
				// 判断关键词是否为空
				if (this.kw === '') {
				  this.searchResults = []
				  return
				}
				
				// /api/public/v1/goods/qsearch?query=a
				const { data: res } = await uni.$http.get('/api/public/v1/goods/qsearch', { query: this.kw })
				if (res.meta.status !== 200) return uni.$showMsg()
				// console.log(res);
				this.searchResults = res.message
				
				this.saveSearchHistory()
			},
			gotoDetail(goods_id) {
				uni.navigateTo({
					url: '/subpkg/goods_detail/goods_detail?goods_id=' + goods_id
				});
			},
			cleanHistory () {
				// uni.showModal({
				// 	title: '提示',
				// 	content: '确认清空全部搜索历史?',
				// 	success: function (res) {
				// 		if (res.confirm) {
				// 			// 1.清空 data 中保存的搜索历史
				// 			this.historyList = []
				// 			// 2.清空本地存储中记录的搜索历史
				// 			uni.setStorageSync('kw', '[]')
				// 			uni.showToast({
				// 				title: '操作成功!',
				// 				icon: 'success'
				// 			})
				// 		} else if (res.cancel) {}
				// 	}
				// })
				this.historyList = []
				uni.setStorageSync('kw','[]')
			},
			gotoGoodsList (kw) {
				uni.navigateTo({
					url: '/subpkg/goods_list/goods_list?query=' + kw
				});
			}
		}
	}
</script>

<style lang="scss">
.search-box {
	// 搜索框吸顶
	position: sticky;
	top: 0;
	z-index: 999;
}
.sugg-list {
	padding: 0 5rpx;
	.sugg-item {
		font-size: 12px;
		padding: 13px 0;
		border-bottom: 1px solid #efefef;
		display: flex;
		align-items: center;
		justify-content: space-between;
		
		.goods-name {
			// 文字不允许换行,溢出部分隐藏
			white-space: nowrap;
			overflow: hidden;
			// 文本溢出后,使用...代替
			text-overflow: ellipsis;
			margin-right: 3rpx;
		}
	}
}
.history-box {
  padding: 0 5px;

  .history-title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 40px;
    font-size: 13px;
    border-bottom: 1px solid #efefef;
  }

  .history-list {
    display: flex;
	// 多行展示
    flex-wrap: wrap;

    .uni-tag {
      margin-top: 5px;
      margin-right: 5px;
    }
  }
}
</style>
