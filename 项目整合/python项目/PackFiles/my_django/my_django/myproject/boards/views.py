from django.contrib.auth.models import User
from django.shortcuts import render,get_object_or_404,redirect
from django.utils import timezone
from django.views.generic import View,ListView,DetailView,CreateView,UpdateView
from boards.models import Board,Topic,Post
from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from .forms import *
from django.db.models import Count



def board_topics(request,pk):
    """详情"""
    board = get_object_or_404(Board,pk=pk)
    topics = board.topics.order_by('-last_update').annotate(replies=Count('posts') - 1)
    return render(request,'topics.html',{"board":board,"topics":topics})

@login_required
def new_topic(request,pk):
    """添加主题"""
    board = get_object_or_404(Board, pk=pk)
    user = User.objects.first()
    if request.method == 'POST':
        form = AddTopicForm(request.POST) # 如果为post,生成一个form对象
        if form.is_valid():
            topic = form.save(commit=False) # 如果有效保存为一个Topic对象
            topic.board = board # 所属板块为传入的board
            topic.starter = request.user # 变更为当前登录用户
            # 将form中message传入Post模型生成一个post对象进行保存
            topic.save() # 保存
            post = Post.objects.create(
                message=form.cleaned_data.get('message'),
                topic=topic,
                created_by=request.user
            )

            return redirect('topic_posts',pk=pk,topic_pk=topic.pk)  # TODO: redirect to the created topic page
    else:
        form = AddTopicForm()
    return render(request,'add_topic.html', {'board': board, 'form': form})

def topic_posts(request,pk,topic_pk):
    """

    @param request:
    @param pk: 标识唯一版块
    @param topic_pk: 标识回复属于哪个主题
    """
    topic = get_object_or_404(Topic,board__pk=pk,pk=topic_pk)
    topic.views +=1 # 主题每被阅读一次该字段+1
    topic.save() # 保存
    return render(request,'topic_posts.html',{
        "topic":topic
    })

@login_required
def reply_topic(request,pk,topic_pk):
    """

    @param request:
    @param pk: 版块唯一标识
    @param topic_pk: 所属主题唯一标识
    @return:
    """
    topic = get_object_or_404(Topic,board__pk=pk,pk=topic_pk)
    if request.method == 'POST':
        form = PostForm(request.POST)
        if form.is_valid():
            post = form.save(commit=False)
            post.topic = topic
            post.created_by = request.user
            post.save()
            return redirect('topic_posts',pk=pk,topic_pk=topic_pk)
    else:
        form = PostForm()
    return render(request,'reply_topic.html',{
        "topic":topic,'form':form
    })

@method_decorator(login_required,name='dispatch')
class PostUpdateView(UpdateView):
    """编辑回复GCBV视图"""
    model = Post
    fields = ('message',)
    template_name = 'edit_post.html'
    pk_url_kwarg = 'post_pk'
    context_object_name = 'post'

    def form_valid(self, form):
        """"""
        post = form.save(commit=False)
        post.updated_by = self.request.user
        post.updated_at = timezone.now()
        post.save()
        return redirect('topic_posts',pk=post.topic.board.pk,topic_pk=post.topic.pk)

    def get_queryset(self):
        """重写get_queryset方法"""
        queryset = super().get_queryset()
        return queryset.filter(created_by=self.request.user) # 以当前系统登陆的用户来过滤内容



class BoardListView(ListView):
    model = Board
    context_object_name = "boards"
    template_name = 'home.html'



