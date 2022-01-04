// 按需导入 mapGetters 这个辅助方法
import { mapGetters } from 'vuex'

export default {
	computed: {
		// 将 m_cart 模块中的 total 映射为当前页面的计算属性
		...mapGetters('m_cart', ['total']),
	},
	watch: {
		// 监听 total 值的变化
		total() {
		  // 调用 methods 中的 setBadge 方法，重新为 tabBar 的数字徽章赋值
		  this.setBadge()
		},
	},
	methods: {
		setBadge () {
			// 判断购物车中商品总数量不为0,如果等于0则不显示徽章
			if (this.total !== 0)
			uni.setTabBarBadge({
				index: 2,
				text: this.total + '' // 注意：text 的值必须是字符串，不能是数字
			})
		}
	},
	onShow () {
		// 在页面刚展示的时候，设置数字徽标
		this.setBadge()
	}
}