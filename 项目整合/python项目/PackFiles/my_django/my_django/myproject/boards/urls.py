from django.urls import path
from django.conf.urls import url

from .views import *
from . import views
urlpatterns = [

    url(r'^boards/(?P<pk>\d+)/$',views.board_topics,name='board_topics'),
    url(r'^boards/(?P<pk>\d+)/add/$',views.new_topic,name='new_topic'),
    path('',views.BoardListView.as_view(),name='home'), #

]