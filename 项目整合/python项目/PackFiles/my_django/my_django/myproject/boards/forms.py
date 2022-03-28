from django import forms
from .models import Topic,Post

class AddTopicForm(forms.ModelForm):
    """"""
    message = forms.CharField(
        widget=forms.Textarea(
            attrs={'rows':5,'placeholder': 'What is on your mind?'}
        ),
        max_length=4000,help_text='最大长度为4000'
    )

    class Meta:
        model = Topic
        fields = ['subject','message']


class PostForm(forms.ModelForm):
    """回复表单"""
    class Meta:
        model = Post
        fields = ['message', ]