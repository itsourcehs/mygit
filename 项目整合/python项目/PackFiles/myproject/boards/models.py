from django.db import models
from django.utils.text import Truncator  # 将一个长字符串截取为任意长度字符
# Create your models here.
from django.contrib.auth.models import User
""""""
class Board(models.Model):
    """板块模型"""
    name = models.CharField(max_length=30,unique=True) # '版块' unique 表示唯一性
    description = models.CharField(max_length=100) # '描述'

    def __str__(self):
        """展示给用户"""
        return self.name

    def get_posts_count(self):
        """获取帖子数量"""
        return Post.objects.filter(topic__board=self).count() # 双下划线 topic__board

    def get_last_post(self):
        """获取帖子的最近时间"""
        return Post.objects.filter(topic__board=self).order_by('-created_at').first()


class Topic(models.Model):
    """主题模型"""
    subject = models.CharField(max_length=255) # 主题内容
    last_updated = models.DateTimeField(auto_now_add=True) # auto_now_add 设置当前时间
    starter = models.ForeignKey(User,related_name='topics',on_delete=models.CASCADE) # on_delete=models.CASCADE
    board = models.ForeignKey(Board,related_name='topics',on_delete=models.CASCADE) # 属于哪个版块 releated_name
    views = models.PositiveIntegerField(default=0) # 储存页面浏览量

    def __str__(self):
        return self.subject

class Post(models.Model):
    """帖子模型"""
    message = models.CharField(max_length=4000) # 储存回复的内容
    topic = models.ForeignKey(Topic,related_name='posts',on_delete=models.CASCADE) # 关联主题
    created_at = models.DateTimeField(auto_now_add=True) # 帖子排序并设置当前时间
    updated_at = models.DateTimeField(null=True)  # 告诉用户是否更新了内容 null=True
    created_by = models.ForeignKey(User,related_name='posts',on_delete=models.CASCADE) # 由哪个用户创建 关联
    updated_by = models.ForeignKey(User,related_name='+',null=True,on_delete=models.CASCADE) #related_name='+' 表示不用在意用户修改了哪些帖子

    def __str__(self):
        """使用30个字符"""
        truncated_message=Truncator(self.message)
        return truncated_message.chars(30)
