from django.test import TestCase

# Create your tests here.

# from django.core.urlresolvers import reverse
from django.urls import reverse
from django.urls import resolve
from django.test import TestCase
from .views import signup


class SignUpTests(TestCase):
    def test_signup_status_code(self):
        """测试注册视图状态码返回200"""
        url = reverse('signup')
        response = self.client.get(url)
        self.assertEquals(response.status_code,200)

    def test_signup_url_resolves_signup_view(self):
        """测试返回了正确的视图函数"""
        view = resolve('/signup/')
        self.assertEquals(view.func,signup)
