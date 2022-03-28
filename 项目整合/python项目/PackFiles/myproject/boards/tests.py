from django.test import TestCase

# Create your tests here.
# from django.core.urlresolvers import reverse
from django.urls import reverse  # 上面模块更名
from django.urls import resolve
from .views import home,board_topics,new_topic
from .models import Board,Topic,Post
from django.contrib.auth.models import User  #
class HomeTests(TestCase):
    """测试类 继承TestCase"""
    def setUp(self):
        self.board = Board.objects.create(name='Django',description='Django board.')
        url = reverse('home')
        self.response = self.client.get(url)
    def test_home_view_status_code(self):
        """测试视图状态代码"""
        # url = reverse('home')
        # response = self.client.get(url)
        self.assertEquals(self.response.status_code,200) # 请求url返回响应状态码为200 表示成功

    def test_home_url_resolves_home_view(self):
        view = resolve('/')
        self.assertEquals(view.func,home)

    def test_home_view_contains_link_to_topics_page(self):
        board_topics_url = reverse('board_topics',kwargs={'pk': self.board.pk})
        self.assertContains(self.response, 'href="{0}"'.format(board_topics_url))

class BoardTopicsTests(TestCase):
    """测试类"""
    def setUp(self):
        """在测试执行之前执行"""
        Board.objects.create(name='Django',description='Django board.') # 创建一个对象

    def test_board_topics_view_success_status_code(self):
        """视图成功返回的状态码"""
        url = reverse('board_topics', kwargs={'pk': 1})
        response = self.client.get(url)
        self.assertEquals(response.status_code, 200)

    def test_board_topics_view_not_found_status_code(self):
        url = reverse('board_topics', kwargs={'pk': 99})
        response = self.client.get(url)
        self.assertEquals(response.status_code, 404)

    def test_board_topics_url_resolves_board_topics_view(self):
        view = resolve('/boards/1/')
        self.assertEquals(view.func, board_topics)
    def test_board_topics_view_contains_link_back_to_homepage(self):
        """测试页面跳转回首页的用例"""
        board_topics_url = reverse('board_topics',kwargs={'pk':1})
        response = self.client.get(board_topics_url)
        homepage_url = reverse('home')
        self.assertContains(response,'href="{0}"'.format(homepage_url))

    def test_board_topics_view_contains_navigation_links(self):
        """测试按下'new topic'按钮页面正常跳转"""
        board_topics_url = reverse('board_topics',kwargs={'pk':1})
        homepage_url = reverse('home')
        new_topic_url = reverse('new_topic',kwargs={'pk':1})
        response = self.client.get(board_topics_url)
        self.assertContains(response,'href="{0}"'.format(homepage_url)) #  '{}'.format()
        self.assertContains(response,'href="{0}"'.format(new_topic_url))

class NewTopicTests(TestCase):
    """新话题视图测试"""
    def setUp(self):
        """"""
        Board.objects.create(name='Django',description='Django board.')
        User.objects.create_user(username='john',email='john@doe.com',password='123')

    def test_csrf(self):
        """测试用户Token"""
        url = reverse('new_topic',kwargs={'pk':1})
        response = self.client.get(url)
        self.assertContains(response,'csrfmiddlewaretoken')

    def test_new_topic_valid_post_data(self):
        """验证发送有效数据，视图函数是否创建了Topic 和 Post"""
        url = reverse("new_topic",kwargs={'pk':1})
        data = {
            'subject':'Test title',
            'message':'Lorem ipsum dolor sit amet'
        }
        response = self.client.post(url,data)
        self.assertTrue(Topic.objects.exists())
        self.assertTrue(Post.objects.exists())

    def test_new_topic_invalid_post_data(self):
        """"""
        url = reverse('new_topic', kwargs={'pk': 1})
        response = self.client.post(url, {})
        self.assertEquals(response.status_code, 200)

    def test_new_topic_invalid_post_data_empty_fields(self):
        """"""
        url = reverse('new_topic', kwargs={'pk': 1})
        data = {'subject': '', 'message': ''}
        response = self.client.post(url, data)
        self.assertEquals(response.status_code, 200)
        self.assertFalse(Topic.objects.exists())
        self.assertFalse(Post.objects.exists())

    def test_new_topic_view_success_status_code(self):
        """检查发给view的请求是否成功"""
        url = reverse(' new_topic',kwargs={'pk':1})
        response = self.client.get(url)
        self.assertEquals(response.status_code,200)

    def test_new_topic_view_not_found_status_code(self):
        url = reverse(' new_topic', kwargs={'pk': 99})
        response = self.client.get(url)
        self.assertEquals(response.status_code, 404)

    def test_new_topic_url_resolves_new_topic_view(self):
        """测试新话题跳转新视图的正确性"""
        view = resolve('/boards/1/new/')
        self.assertEquals(view.func,new_topic)

    def test_new_topic_view_contains_link_back_to_board_topics_view(self):
        """验证导航能回到topics的列表"""
        new_topic_url = reverse(' new_topic',kwargs={'pk':1})
        board_topics_url = reverse('board_topics',kwargs={'pk':1})
        response = self.client.get(new_topic_url)
        self.assertContains(response,'href="{0}"'.format(board_topics_url))


