from django.shortcuts import render,redirect,get_object_or_404

# Create your views here.

from django.contrib.auth.forms import UserCreationForm  # 内置表单
from django.contrib.auth import login as auth_login
from .forms import SignUpForm
from django.contrib.auth.decorators import login_required # 视图装饰器
def signup(request):
    """注册视图"""
    if request.method=='POST':
        form=SignUpForm(request.POST)  #
        if form.is_valid():
            user=form.save() #创建一个User实例
            auth_login(request,user)
            return redirect('home')
    else:
        form=SignUpForm()  #  曾经出错
    return render(request,'signup.html',{'form':form})

