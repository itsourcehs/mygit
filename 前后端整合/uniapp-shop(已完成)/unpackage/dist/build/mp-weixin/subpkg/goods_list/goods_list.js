(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["subpkg/goods_list/goods_list"],{"4f0d":function(t,n,e){"use strict";e.d(n,"b",(function(){return r})),e.d(n,"c",(function(){return i})),e.d(n,"a",(function(){return o}));var o={myGoods:function(){return e.e("components/my-goods/my-goods").then(e.bind(null,"4b57"))}},r=function(){var t=this,n=t.$createElement;t._self._c},i=[]},"628c":function(t,n,e){"use strict";(function(t){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var o=r(e("a34a"));function r(t){return t&&t.__esModule?t:{default:t}}function i(t){return c(t)||s(t)||a(t)||u()}function u(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function a(t,n){if(t){if("string"===typeof t)return d(t,n);var e=Object.prototype.toString.call(t).slice(8,-1);return"Object"===e&&t.constructor&&(e=t.constructor.name),"Map"===e||"Set"===e?Array.from(t):"Arguments"===e||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(e)?d(t,n):void 0}}function s(t){if("undefined"!==typeof Symbol&&Symbol.iterator in Object(t))return Array.from(t)}function c(t){if(Array.isArray(t))return d(t)}function d(t,n){(null==n||n>t.length)&&(n=t.length);for(var e=0,o=new Array(n);e<n;e++)o[e]=t[e];return o}function f(t,n,e,o,r,i,u){try{var a=t[i](u),s=a.value}catch(c){return void e(c)}a.done?n(s):Promise.resolve(s).then(o,r)}function l(t){return function(){var n=this,e=arguments;return new Promise((function(o,r){var i=t.apply(n,e);function u(t){f(i,o,r,u,a,"next",t)}function a(t){f(i,o,r,u,a,"throw",t)}u(void 0)}))}}var g={data:function(){return{queryObj:{query:"",cid:"",pagenum:1,pagesize:10},goodsList:[],total:0,isloading:!1}},onLoad:function(t){console.log(t),this.queryObj.query=t.query||"",this.queryObj.cid=t.cid||"",this.getGoodsList()},methods:{getGoodsList:function(n){var e=this;return l(o.default.mark((function r(){var u,a;return o.default.wrap((function(o){while(1)switch(o.prev=o.next){case 0:return e.isloading=!0,o.next=3,t.$http.get("/api/public/v1/goods/search",e.queryObj);case 3:if(u=o.sent,a=u.data,e.isloading=!1,n&&n(),200===a.meta.status){o.next=9;break}return o.abrupt("return",t.$showMsg());case 9:e.goodsList=[].concat(i(e.goodsList),i(a.message.goods)),e.total=a.message.total;case 11:case"end":return o.stop()}}),r)})))()},gotoDetail:function(n){t.navigateTo({url:"/subpkg/goods_detail/goods_detail?goods_id="+n.goods_id})}},onReachBottom:function(){if(this.queryObj.pagenum*this.queryObj.pagesize>=this.total)return t.$showMsg("数据加载完毕!");this.isloading||(this.queryObj.pagenum+=1,this.getGoodsList())},onPullDownRefresh:function(){this.queryObj.pagenum=1,this.total=0,this.isloading=!1,this.goodsList=[],this.getGoodsList((function(){return t.stopPullDownRefresh()}))}};n.default=g}).call(this,e("543d")["default"])},"6e67":function(t,n,e){"use strict";e.r(n);var o=e("628c"),r=e.n(o);for(var i in o)"default"!==i&&function(t){e.d(n,t,(function(){return o[t]}))}(i);n["default"]=r.a},"8df8":function(t,n,e){"use strict";e.r(n);var o=e("4f0d"),r=e("6e67");for(var i in r)"default"!==i&&function(t){e.d(n,t,(function(){return r[t]}))}(i);var u,a=e("f0c5"),s=Object(a["a"])(r["default"],o["b"],o["c"],!1,null,null,null,!1,o["a"],u);n["default"]=s.exports},dd49:function(t,n,e){"use strict";(function(t){e("291b");o(e("66fd"));var n=o(e("8df8"));function o(t){return t&&t.__esModule?t:{default:t}}t(n.default)}).call(this,e("543d")["createPage"])}},[["dd49","common/runtime","common/vendor"]]]);