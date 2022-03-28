# Django  Noting

## 安装----环境

```
Python 3
Django 3.1.1

```

## 创建项目

```
1.创建项目命令(命令行)：
    django-admin startproject <项目名>
        目录结构:
        urls:网站路由/路径
        setting:项目配置
        wsgi:网关接口
2.启动服务
	本机地址:127.0.0.1:8000
	命令: python manage.py runserver

3.项目构思
	·论坛版块(boards),在版块里可以创建新主题(Topic),其他用户可以参与回复
		管理员--创建版块，创建主题，回复主题
		普通人--         创建主题，回复主题
	·实体类(模型),
		Board   ---  版块名 unique，描述 
		Topic   ---  名称，最后更新时间
		Post(回复)  ---  文本内容，在什么时候创建的，在什么时候更新的。
		User  ---  用户名，密码，邮箱，是否是管理员
	·联系
		1.Topic需要一个字段(外键)标识属于哪个Board
		2.Post需要一个字段(外键)标识是属于哪个Topic
		3.需要一个字段标识Topic是哪个User发起的，Post是哪个User发的
```

## Django应用组成

```
Django 概念:
	1.app:应用程序(模块)
		MTV： models  views  templates tests
	2.project：配置和应用程序的集合
	
```



## 创建第一个应用程序(模块)

```python
manage.py所在目录下执行  django-admin startapp boards
	创建目录结构(自动):
	admin:django 内置应用程序Django Admin的配置文件
	apps:应用程序本身的配置文件
	models:定义应用程序数据实例，自动转换为数据库表
	tests: 单元测试
	views:处理Web应用程序请求和响应

MTV    models 存储数据   /  template 展示页面  /  views 调用数据


1.配置setting----------添加boards到INSTALLED_APPS列表
	INSTALLED_APPS(已安装6个内置应用程序)
	注意:boards用逗号结尾


2.编写views----------视图函数，参数request，返回 HttpResponse
	from django.http import HttpResponse
	def home(request):
        """py(视图)函数，接收request返回response"""
        return HttpResponse('hello')


3.urls中配置路由---------urlpatterns中添加url(r'^$', views.home, name='home')
	注意: $匹配空路径(代表http://127.0.0.1:8000/,),每一个路由必须以逗号结尾
    from boards import views  # 从boards目录导入views.py文件


4. 创建模型
	.模型描述
        Django contrib包已内置User模型 django.contrib.auth
        。。。省略 1-1 1-多 关系
        Topic中应用 类方法 posts()查询所有回复列表
	.设计模型
    	1.一个模型就是一个类
     	2.所有模型都是django.db.models.Model 的子类，所有字段都是field类的子类
        在board/models 里面编写模型
        	class Board(models.Model):
                name= charfield()
                description=
        	class Topic(models.Model):
                subject=
                last_updated=
                board =
                
        	class Post(models.Model):
            
5.绘制网站线框图
	https://app.diagrams.net/ 推荐使用
	https://www.layui.com/admin/std/dist/views/  弹窗及网页特效
	
    
6.迁移模型-----迁移完成将会生成一个 sqllite3
	对象关系映射(ORM)---- object relations mapping：将模型映射为数据库实例
	每改变数据库(添,改,删)需要操作一次迁移
	第一步:python manage.py makemigrations
	第二步:python manage.py migrate

7.试验Models API-----创建新的Board对象&常用操作
	交互式shell
	1.命令: python manage.py shell
	模型管理器(每个Django模型都带一个特殊的属性objects)，通过访问管理器来操作数据库
	2.from boards.models import Board
	3.board=Board(name='python',description='.....') 或 使用模型管理器 Board.objects.create(name='python',description='....')
	4.对象保存 board.save() 
    	4.1 修改值   board.name='django'
     	4.2 保存    board.save()
	5.列出数据库中的所有对象
    	Board.objects.all()
        a.获取单个对象
    	Boards.objects.get(id=1) or Boards.objects.get(name='python')
	6.__str__ 方法表示将对象以字符串的形式展示
    	boards/models.py
        class 模型名(models.Model):
            def __str__(self):
                "返回对象名称 name"
                return self.name  # 返回上面列子的name='python'
	7.遍历对象
    	board_list=Board.objects.all()  # 当成列表
		for board in board_list:
            print(board.description)
    8.按字段排序对象
    	Board.objects.all().order_by('-字段名')[:5] [:5]可选项 -必填
 	

8.编写视图并在HTML页面显示
	1).第一个视图函数
    	boards/views.py
		from .models import Board # 1.导入模型
        def home(request):
            boards=Boards.objects.all() # 2.列出所有对象
	2).模板引擎设置
    	1.在manage.py 目录创建一个templates的文件夹
     	2.在templates文件夹中,创建一个为home.html 的文件
     	3.在body里编写 
        	{% for board in boards  %}
            	{{ board.name }} <br> # 换行展示名称
             {% endfor %}
      	4.使用这个页面之前，必须告诉Django在哪里找到模板
        	打开 myproject/setting.py -----  TEMPLATES变量-----设置DIRS的值
            为 os.path.join(BASE_DIR,'templates') # BASE_DIR manage.py所在路径(非目录)
    	5.
9.静态文件设置---- CSS JavaScript,字体，图片
	Bootstrap 4
    1.在manage.py 目录创建一个static的文件夹
    2.在static 中创建一个css文件夹
    3.下载bootstrap-4.0.0-beta-dist.zip,将css/bootstrap.min.css复制到css文件夹中
    4.必须告诉Django在哪里找到静态文件
    	打开 myproject/setting.py -----  STATIC_URL变量-----设置STATICFILES_DIRS的值
        os.path.join(BASE_DIR,'static')
    5.在模板中加载静态文件
    	在HTML 文件第一行添加  {% load static %}
        head 里添加 <link rel="stylesheet" href="{% static 'css/bootstrap.min.css' %}">
	
 		
        

	
```

# Admin & xadmin介绍

```
shell 创建superuser

命令
	python manage.py createsuperuser
	输入账号 密码
	浏览器访问 http://127.0.0.1:8000/admin/
	
	接下来添加Board模型
	boards/admin 
	from boards.models import Board


xadmin:
	1.pip 安装
	2.项目settings中引入
		'xadmin'
		'crispy_forms'
	3.urls中设置
		import xadmin
		path('xadmin/',xadmin.site.urls),
	4.数据库迁移
```

# URL 分发

```python
1.从 myproject/urls.py

    认识 URL 调度器  URLconf  url()
    一个大项目可能有很多个app(里面有多个urls.py),django 需要一个根路由作为入口
    在 myproject/settings.py 中已经自动配置好了  ROOT_URLCONF=''
2.url 函数解析
	def url(regex,view,kwargs=None,name=None):
        """
        regex: 代表正则表达式，正则表达式会忽略掉GET POST请求后面的参数
        view: 视图函数
        * 不要在views 或 templates中硬编码URL 而是通过name去应用URL
        """
3.创建一个页面示例
	1.添加基础路由
    	url(r'^about/$',views.about,name='about')
  	2.views 中添加视图函数 about
 	3.views 中  from django.shortcuts import render
    	render(c) 返回的值是一个 Unicode 对象，不是普通的 Python 字符串
            render方法的作用:结合一个给定的模板和一个给定的上下文字典，并返回一个渲染后的 HttpResponse 对象-------把context的内容, 加载进templates中定义的文件, 并通过浏览器渲染呈现
            return render(request,'about.html',{'company_name':'suibian'})
   	4.Django 中 快捷得到一个对象，或者返回一个不存在的对象404
    	from django.shortcuts import render,get_object_or_404
        	def board_topics(request,pk):
                board=get_object_or_404(模型名,pk=pk)
                return render(request,'topics.html',{'board':board})
		字典值跟在 url name 后  :   url(r'^questions/(?P<pk>\d+)/$', views.question, name='question')    访问  /name/字典值/ ==  /question/board/

4.添加导航链接，主页链接指引访问指定board下的topics列表，topics页面也应该有一个返回主页的链接.
```

# 非常实用URL模式列表p98

```
https://simpleisbetterthancomplex.com/references/2016/10/10/url-patterns.html
```

# 复用模板

```CSS
base.html
子模版继承  {% extend 'base.html' %}  
占位 {% block %}
字体: https://fonts.google.com/?query=django
	在base.html 中添加字体 <link href='https://fonts.google.com/?query=django'>
Bootstrap 组件: https://getbootstrap.com/docs/4.0/components/navbar/

在static/css 文件夹创建新的CSS文件 --- app.css
	static/css/app.css
.<class名> {
    font-family:'Peralta', cursive;
}
```

# 表单处理

```html
1.<form>
    <% csrf_token %>  处理post请求
  </form>
2.设置HTML 输入的name 用来在服务器获取数据
    <input ... name='subject'>
    <input ... name='message'>
    获取数据:  subject=request.POST['subject']   message=request.POST['message']
```

# 创建表单的正确方法

```
Forms API
	django.forms 
	forms.Form   forms.ModelForm
	首先判断request.method 是否是POST
		是的话通过forms.py 中创建的表单类 NewTopicForm(request.method)实例化一个对象 A
		然后再判断A是否有效，如果有效 调用 A.save() 存入数据库
		最后通过 return 将用户重定向 ---- 相当于回退刷新
		
		如果A无效
	通过NewTopicForm()实例化B
    return 定向在表单提交页 .html
```

## 用户注册

```python
注册，登录，注销，密码重置，密码修改

身份认证将在另一个应用中实现(accounts)

manage.py所在目录下运行命令: django-admin startapp <app 名> 
1.添加 app名 到 INSTALLED_APPS列表
2.创建一个注册路由(sign_up)
	from accounts import views as accounts_views
	url(r'^signup/$',accounts_views.signup,name='signup')
    
3.accounts 中views 
    	def signup(request):
            return render(request,'signup.html')  # 指向注册页面

4.创建 signup.html
	.....

5.创建注册表单
	Django 内置表单 UserCreationForm
    **accounts 中views
    from django.contrib.auth import login
    def signup(request):
        if request.method == 'POST':
            form = UserCreationForm() # 创建一个表单对象
            if form.is_valid():
                user=form.save()
                login(request,user) # 作为参数传给login函数，手动验证用户
                return redirect('home') # 然后重定向回首页 redirect表示重定向
       	else:
            form = UserCreationForm() # 创建一个空
        return render(request,'signup.html',{'form':form})
		键为页面参数名，值为views参数名
6.将email 字段添加到表单
	UserCreationForm 不提供email字段
    创建一个新的注册表单
    **accounts 中forms
    from django import forms
    class SignUpForm(UserCreationForm):
        forms.CharField(max_length=254,)

---------------------------------------------------------

用户注销

1.创建路由(logout)

    
```

# 知识点梳理

```python
1.views 中
    from django.views.generic import View # 基于类的视图 

    class About(View):
        def get(self,request,pk) # pk是涉及到外键关联才写
        ···代码块···

2.urls中
	from .views import *
	path('about/<int:pk>/',About.as_view(),name='about') # pk项也是根据是否需要关联外键才写

3.html中
	超链接跳转
    <a href="{% 'blog:about' %}" # blog表示 name='about'的路由所在路径

4.models
	字段属性 DateTimeField, ForeignKey, ImageField, IntegerField, ManyToManyField......
    ImageField: 需安装 Pillow 库 且参数upload_to为必填项
    绝对路径: 从头写到尾
    相对路径: ../image/
        # 配置用户上传的文件
MEDIA_URL = '/media/'
MEDIA_ROOT = os.path.join(BASE_DIR,'media')

5.删除数据库
	删除migrations中的 00001文件 再重新执行数据库迁移命令

6.settings 中添加其他app
	example: extra_apps 示例方法: sys  sys.path.insert(0,os.path.join(BASE_DIR,'extra_apps')) 定义搜索路径的优先顺序，序号从0开始，表示最大优先级 

7.get_object_or_404(Modename,pk=_)
	获取Modename中的pk，如果获取到返回pk对应的一系列数据，否则返回404

8.注册用户
	from django.contrib.auth import login
	使用内置表单 UserCreationForm
    if request.method == 'POST': # 如果请求方式为post,则生成一个form表单对象
        form = UserCreationForm(request.POST)
        if form.is_valid(): # 如果表单对象有效，则使用save存为一个用户
            user = form.save()
            login(request,user)
            return redirect('home')
    else: # 如果请求方式不为post,则创建一个空表单
    return render(request,....)
	8.1 扩展内置表单 UserCreationForm

9.注销视图 -- 内置 django.contrb.auth import views --> LogoutView
	打开settings 添加LOGOUT_REDIRECT_URL到文件的底部
    LOGOUT_REDIRECT_URL = 'home' # 表示退出登录后回到首页
  9.1 登录视图 需要重新指定参数template_name = '自己的login.html'
	LoginView
10. 如果用户未登录
	if user.is_authenticated
    else
    endif
11.保护视图
	视图装饰器 视图前加 login_required
    from django.contrib.auth.decorators import login_required
    topic.starter = request.user # 变更为当前登录用户
12.查询结果集
	1.模型中将一个长字符串截取为任意长度字符 -- Truncator 工具类
    from django.utils.text import Truncator
    2.获取结果集
    	a.获取版块下的总主题数:
            board=Board.objects.get(name='Django')  board.topics.count()
        b.获取版块下的回复数量:
            Post.objects.filter(topic_ _board = board).count() # 双下划綫__
        c.标识版块下的最后一条回复
           Post.objects.filter(topic_ _board = board).order_by('-created_at').first()
        d.代码中加入以上 models下加入函数  然后html中使用{% with  %}
        e.主题列表下某一主题的回复数量
           使用annotate,QuerySet即时生成一个新的列,新列被翻译成属性,通过topic.replies访问
       topic = board.topics.order_by('-last_updated').annotate(replies=Count('posts')-1)
           html 中通过topic.replies访问
        2.1 PositiveIntegerField 字段存储页面浏览量 models.PositiveIntegerField

13.GCBV  https://ccbv.co.uk/

14.关于post.topic.board.pk 补充
	从P247页结尾开始重新学习
15.CBV上使用视图装饰器
	views.py中引入 from django.utils.decorators import method_decorator
    class前添加 @method_decorator(login_required, name='dispatch')

16.处理其他用户可以编辑所有帖子的问题
	重写UpdateView中的 get_queryset方法
    然后,通过给 queryset 添加一个额外的过滤条件,该过滤条件是通过请求中获取登录的用户来过滤内容
    def get_queryset(self):
        queryset = super().get_queryset()
        return queryset.filter(created_by = self.request.user)
17.实现分页
	1.定义一个分页的查询集非常重要
    	导入Paginator工具 from django.core.paginator import Paginator
        paginator = Paginator(queryset,20) # 告诉django将查询集按照每页20个元素分页
```

# 问题汇总

```
1.xadmin 字段无法填写之后无法提交
	字段所属模型生成对象
2.后端数据输出正常,但前端不显示数据
	数据库模型外键字段未创建反向关系导致
3.内置表单创建用户无效
	UserCreationForm(request.POST)
4.修改密码失败
 *** 待解决
5.Reverse for '<WSGIRequest: GET '/boards/3/topics/14/'>' not found
	原因:views中错误的将request作为参数传入redirect()
```

## 学生管理系统学习Noting

```python
1.多个app可以用一个文件包来存 apps(与manager同一目录下)
	之后在settings中: import sys  ----   sys.path.insert(0,os.path.join(BASE_DIR,'apps'))
	INSTALLED_APPS中添加apps中每个app名
2.
```

