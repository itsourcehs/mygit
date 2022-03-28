from datetime import datetime

from django.db import models


class CityDict(models.Model):
    name = models.CharField(verbose_name='城市', max_length=20)
    desc = models.CharField(verbose_name='描述', max_length=200)
    add_time = models.DateTimeField(default=datetime.now)

    class Meta:
        verbose_name = '城市'
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.name


class CourseOrg(models.Model):
    """课程机构"""
    ORG_CHOICES = (('pxjg',u"培训机构"),('gx',u"高校"),('gr',u"个人"),
                   )
    name = models.CharField(verbose_name="机构名称",max_length=50)
    desc = models.TextField(verbose_name="机构描述",max_length=400)
    category = models.CharField(max_length=20,choices=ORG_CHOICES,verbose_name=u"机构类别",default="pxjg")
    click_nums = models.IntegerField(verbose_name="点击数", default=0)
    tag = models.CharField(verbose_name="机构标签", default='全国知名', max_length=10)
    fav_nums = models.IntegerField(verbose_name="收藏人数", default=0)
    students = models.IntegerField(verbose_name="学习人数", default=0)
    course_nums = models.IntegerField(verbose_name="课程数", default=0)
    # image
    address = models.CharField(verbose_name="机构地址",max_length=150)
    city = models.ForeignKey(CityDict,on_delete=models.CASCADE,verbose_name="所在城市")
    add_time = models.DateTimeField(default=datetime.now)

    class Meta:
        verbose_name = "课程机构"
        verbose_name_plural = verbose_name
    def get_teacher_nums(self):
        """获取机构的教师数"""
        return self.teacher_set.all().count()
    def __str__(self):
        return self.name

class Teacher(models.Model):
    org = models.ForeignKey(CourseOrg,on_delete=models.CASCADE,verbose_name="所属机构")
    name = models.CharField(verbose_name="教师姓名",max_length=50)
    work_years = models.IntegerField(verbose_name="工作年限",default=0)
    work_company = models.CharField('就职公司', max_length=50)
    work_position = models.CharField(verbose_name="公司职位",max_length=50)
    points = models.CharField(verbose_name='教学特点', max_length=50)
    click_nums = models.IntegerField(verbose_name='点击数', default=0)
    fav_nums = models.IntegerField(verbose_name='收藏数', default=0)
    teacher_age = models.IntegerField(verbose_name='年龄', default=25)
    # image


    class Meta:
        verbose_name = '教师'
        verbose_name_plural = verbose_name
    def __str__(self):
        return f'{self.org}的教师: {self.name}'
    def get_course_nums(self):
        """获得该教师的课程统计"""
        return self.course_set.all().count() # 报黄是因为找不到 class Course


