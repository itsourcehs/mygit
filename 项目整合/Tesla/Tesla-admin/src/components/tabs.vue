<template>
	<div>
		<el-tabs
		v-model="editableTabsValue"
		type="card"
		closable
		@tab-remove="removeTab">
			<el-tab-pane
			v-for="(item, index) in editableTabs"
			:key="item.name"
			:label="item.title"
			:name="item.name">
				
			</el-tab-pane>
		</el-tabs>
	</div>
</template>

<script>
	export default {
		name: "tabs",
		data() {
			return {
				editableTabsValue: '2',
				editableTabs: [{
				  title: '首页',
				  name: '1',
				  content: 'Tab 1 content'
				}, {
				  title: 'Tesla零件',
				  name: '2',
				  content: 'Tab 2 content'
				}],
				tabIndex: 2
		  }
		},
		methods: {
			// 移除标签卡
			removeTab(targetName) {
				let tabs = this.editableTabs;
				let activeName = this.editableTabsValue;
				if (activeName === targetName) {
				  tabs.forEach((tab, index) => {
					if (tab.name === targetName) {
					  let nextTab = tabs[index + 1] || tabs[index - 1];
					  if (nextTab) {
						activeName = nextTab.name;
					  }
					}
				  });
				}
					
				this.editableTabsValue = activeName;
				this.editableTabs = tabs.filter(tab => tab.name !== targetName);
			}
		},
	}
</script>

<style>
.el-tabs--card>.el-tabs__header .el-tabs__item.is-active {
    border-bottom-color: #f0f0f0;
}
</style>
