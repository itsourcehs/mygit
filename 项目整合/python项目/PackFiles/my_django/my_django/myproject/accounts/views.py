from django.shortcuts import render,redirect
from django.contrib.auth.forms import UserCreationForm # 内置表单
from django.contrib.auth import login as auth_login #  login函数
from .forms import RegisterForm
def register(request):
    if request.method == 'POST': # 填写完表单后,如果请求方式为post
        form = UserCreationForm(request.POST)
        if form.is_valid(): # 如果表单有效
            user = form.save() # 保存为用户
            auth_login(request,user)
            return redirect('boards:home') # 重定向回首页
    else:
        form = RegisterForm()
    #
    return render(request,'register.html',{
            'form':form
        })

