from django.contrib.auth.models import User
from django.shortcuts import render

# Create your views here.
# 1.http返回
from django.http import HttpResponse
from .models import Board, Topic, Post  # .models 表示当前目录下的models模块
from django.shortcuts import render, redirect, get_object_or_404  #
from django.http import Http404
from .forms import NewTopicForm,PostForm
from django.contrib.auth.decorators import login_required # 视图装饰器
from django.db.models import Count

from django.views.generic import UpdateView
from django.utils import timezone
from django.utils.decorators import method_decorator #
from django.views.generic import ListView
from django.core.paginator import Paginator,EmptyPage,PageNotAnInteger  # 分页
# 2.视图函数
def home(request):
    # return HttpResponse('Hello World!')
    boards = Board.objects.all()  # 获取所有的对象列表
    # boards_names = list() # 创建空列表
    #
    # for board in boards:
    #     """遍历列表"""
    #     boards_names.append(board.name)
    #
    # response_html = '<br>'.join(boards_names) #
    # return HttpResponse(response_html)
    boards=Board.objects.all()
    return render(request, 'home.html', {'boards': boards})


def board_topics(request, pk):
    """"""
    # try:
    #     board = Board.objects.get(pk=pk)
    # except Board.DoesNotExist:
    #     raise Http404
    board = get_object_or_404(Board, pk=pk)
    queryset = board.topics.order_by('-last_updated').annotate(replies=Count('posts') - 1)  #  这儿
    page=request.GET.get('page',1)
    paginator = Paginator(queryset, 20)  #　这里报错，，

    try:
        topics=paginator.page(page)   #  Paginator  整成了大写字母
    except PageNotAnInteger:
        topics=paginator.page(1)
    except EmptyPage:
        topics=paginator.page(paginator.num_pages)
    return render(request, 'topics.html', {'board': board, 'topics': topics})

@login_required
def new_topic(request, pk):
    """"""
    board = get_object_or_404(Board, pk=pk)
    # user = User.objects.first()
    if request.method == 'POST':
        form = NewTopicForm(request.POST)
        if form.is_valid():
            topic = form.save(commit=False)
            topic.board = board
            topic.starter = request.user  # 获取当前登录用户为主题作者
            topic.save()
            Post.objects.create(
                message=form.cleaned_data.get('message'),
                topic=topic, created_by=request.user )  # 同上
            # return redirect('board_topics', pk=board.pk)  # 出错
            return redirect('topic_posts', pk=pk, topic_pk=topic.pk)
    else:
        form = NewTopicForm()
    return render(request, 'new_topic.html', {'board': board, 'form': form})

def topic_posts(request,pk,topic_pk):
    """帖子回复视图"""
    # topic = get_object_or_404(Topic,board_pk=pk,pk=topic_pk)  # board_pk
    topic = get_object_or_404(Topic, board__pk=pk, pk=topic_pk)  # board_pk  两个下划线
    topic.views += 1
    topic.save()
    return render(request,'topic_posts.html',{'topic':topic})

@login_required
def reply_topic(request,pk,topic_pk):
    """回复帖子"""
    # topic = get_object_or_404(Topic,board_pk=pk,pk=topic_pk)  # 两个下划线
    topic = get_object_or_404(Topic, board__pk=pk, pk=topic_pk)
    if request.method == 'POST':
        form = PostForm(request.POST)
        if form.is_valid():
            post = form.save(commit=False)
            post.topic = topic
            post.created_by = request.user
            post.save()
            return redirect('topic_posts', pk=pk, topic_pk=topic_pk)
    else:
        form = PostForm()
    return render(request, 'reply_topic.html', {'topic': topic, 'form': form})

@method_decorator(login_required,name='dispatch')
class PostUpdateView(UpdateView):
    """继承"""
    model=Post
    fields = ('message', )
    template_name = 'edit_post.html'
    pk_url_kwarg = 'post_pk'
    context_object_name = 'post'

    def get_queryset(self):
        """重写方法"""
        queryset=super().get_queryset()
        return queryset.filter(created_by=self.request.user)

    def form_valid(self,form):
        """"""
        post=form.save(commit=False)
        post.updated_by=self.request.user
        post.updated_at=timezone.now()
        post.save()
        return redirect('topic_posts',pk=post.topic.board.pk,topic_pk=post.topic.pk)

class BoardListView(ListView):
    model = Board
    context_object_name = 'boards'
    template_name = 'home.html'