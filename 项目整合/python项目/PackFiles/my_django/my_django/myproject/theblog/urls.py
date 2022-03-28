from django.conf.urls import url
from django.urls import path
from theblog import views as blog_views
urlpatterns = [
    path('theblog/',blog_views.home,name='blog_home'),
]