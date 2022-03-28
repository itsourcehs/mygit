from django.db import models
from ..organization.models import CourseOrg,Teacher
from datetime import datetime


class Course(models.Model):
    """课程模型"""
    DEGREE_CHOICES = (("cj","初级"),("zj","中级"),("gj","高级"))
    name = models.CharField(verbose_name="课程名",max_length=50)
    desc = models.CharField(verbose_name="课程描述",max_length=300)
    # detail
    degree = models.CharField(verbose_name="课程难度",choices=DEGREE_CHOICES,max_length=2)
    learn_times = models.IntegerField(verbose_name="学习时长(分钟数)",default=0)
    fav_nums = models.IntegerField(verbose_name="收藏人数",default=0)
    # image
    click_nums = models.IntegerField(verbose_name="点击数",default=0)
    tag = models.CharField(verbose_name="课程标签",default='',max_length=10)
    # is_banner
    course_org = models.ForeignKey(CourseOrg,on_delete=models.CASCADE,verbose_name="所属机构",null=True,blank=True) # blank 啥意思
    category = models.CharField(verbose_name="课程类别",max_length=20,default='')
    teacher = models.ForeignKey(Teacher,on_delete=models.CASCADE,verbose_name="讲师",null=True,blank=True)
    youneed_know = models.CharField(verbose_name="课程须知",max_length=300,default='')
    teacher_tell = models.CharField(verbose_name="老师告诉你",max_length=300,default='')

    class Meta:
        verbose_name = "课程"
        verbose_name_plural = verbose_name
    def __str__(self):
        return self.name
    def get_learn_users(self):
        """获取这门课程的学习用户"""
        return self.usercourse_set.all()[:5]
    def get_course_lesson(self):
        """获取课程所有章节"""
        return self.lesson_set.all()
    def get_zj_nums(self):
        """获取课程所有章节数"""
        return self.lesson_set.all().count()
    get_zj_nums.short_description = '章节数' # 后台显示名称


class Lesson(models.Model):
    """课程章节"""
    course = models.ForeignKey(Course,on_delete=models.CASCADE, verbose_name='课程')
    name = models.CharField(verbose_name="章节名", max_length=100)
    add_time = models.DateTimeField(verbose_name="添加时间", default=datetime.now)

    class Meta:
        verbose_name = "章节"
        verbose_name_plural = verbose_name

    def get_lesson_vedio(self):
        # 获取章节所有视频
        return self.video_set.all()

    def __str__(self):
        return f'{self.course}课程的章节 >> {self.name}'


class Video(models.Model):
    '''章节视频'''
    lesson = models.ForeignKey(Lesson, verbose_name="章节", on_delete=models.CASCADE)
    name = models.CharField(verbose_name="视频名", max_length=100)
    url = models.CharField(verbose_name='访问地址', default='', max_length=200)
    learn_times = models.IntegerField(verbose_name="学习时长(分钟数)", default=0)
    add_time = models.DateTimeField(verbose_name="添加时间", default=datetime.now)

    class Meta:
        verbose_name = "视频"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.name
