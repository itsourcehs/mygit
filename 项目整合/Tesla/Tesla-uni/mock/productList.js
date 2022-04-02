let products = [{
	"id": "fa241ce1a6178",
	"carPic": require("@/static/images/swiper/car.png"),
	"name": "Model s"
},
{
	"id": "d78wawy7aawd9",
	"carPic": require("@/static/images/swiper/car.png"),
	"name": "Model x"
},
{
	"id": "575jdaw9311",
	"carPic": require("@/static/images/swiper/car.png"),
	"name": "Model y"
}]

// 
export default {
  'get|/api/parameter/query':  option => {
    return {
      status: 200,
      message: 'success',
      data: products
    };
  },
}