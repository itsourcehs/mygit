from django.test import TestCase

# Create your tests here.


import requests
import json
class Send_Menthod:
    def send_menthod(self,method,url,data):
        json_data = json.dumps(data)
        dic_data = {json_data}
        print(dic_data)
        # if method=="post":
        #     response=requests.request(method,url)
        #
        # elif method=="get":
        #     response = requests.request(method,url)


if __name__ == '__main__':
    list_data = "123"
    Send_Menthod().send_menthod(method="get",url="www.baidu.com",data=list_data)

