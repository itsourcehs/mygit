from django.db import models
from django.contrib.auth.models import User # 用户模型
from datetime import datetime
from django.utils.text import Truncator #

class Board(models.Model):
    """版块Model"""
    name = models.CharField(max_length=30,unique=True,verbose_name='版块名称')
    description  =models.CharField(max_length=100)

    def __str__(self):
        return self.name

    def get_posts_count(self):
        """获取版块下所有的回复数"""
        return Post.objects.filter(topic__board=self).count()

    def get_last_post(self):
        """获取版块下最后一条回复"""
        return Post.objects.filter(topic__board=self).order_by('-created_at').first()

class Topic(models.Model):
    """主题Model"""
    subject = models.CharField(verbose_name='主题内容',max_length=255)
    last_update = models.DateTimeField(auto_now_add=True)
    board = models.ForeignKey(Board,on_delete=models.CASCADE,related_name='topics',verbose_name='所属版块')
    starter = models.ForeignKey(User,on_delete=models.CASCADE,related_name='topics',verbose_name='由谁创建')
    views = models.PositiveIntegerField(default=0,verbose_name="阅读量")
    def __str__(self):
        return self.subject
class Post(models.Model):
    """回复Model"""
    message = models.TextField(verbose_name='回复内容',max_length=4000)
    created_at = models.DateTimeField(verbose_name='回复时间',auto_now_add=True)
    updated_at = models.DateTimeField(verbose_name='更新时间',null=True)
    topic = models.ForeignKey(Topic,on_delete=models.CASCADE,related_name='posts',verbose_name='所属主题')
    created_by = models.ForeignKey(User,on_delete=models.CASCADE,related_name='posts',verbose_name='所属用户')
    updated_by = models.ForeignKey(User,on_delete=models.CASCADE,null=True,related_name='+',verbose_name='由谁更新')
    def __str__(self):
        truncated_message = Truncator(self.message)
        return truncated_message.chars(30) # 将message字符截取为30个字符
