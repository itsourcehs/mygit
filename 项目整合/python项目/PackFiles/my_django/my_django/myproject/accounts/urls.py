from django.conf.urls import url
from . import views as accounts_views
from django.contrib.auth import views as auth_views
from boards import views
urlpatterns = [

    url(r'^register/$',accounts_views.register,name='register'), # 注册
    url(r'^login/$',auth_views.LoginView.as_view(template_name='login.html'),name='login'), # 登录
    url(r'^logout/$',auth_views.LogoutView.as_view(),name='logout'), # 注销
    url(r'^settings/password/$',auth_views.PasswordChangeView.as_view(template_name='password_change.html'),name="password_change"),
    url(r'^settings/password/done/$',auth_views.PasswordChangeDoneView.as_view(template_name='password_change_done.html'),name="password_change_done")
]