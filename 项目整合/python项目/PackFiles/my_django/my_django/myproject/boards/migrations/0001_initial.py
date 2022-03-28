# Generated by Django 3.1.3 on 2021-03-12 09:16

import datetime
from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='Board',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=30, unique=True, verbose_name='版块名称')),
                ('description', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='Topic',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('subject', models.CharField(max_length=255, verbose_name='主题内容')),
                ('last_update', models.DateTimeField(default=datetime.datetime.now)),
                ('board', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='boards.board', verbose_name='所属版块')),
                ('starter', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL, verbose_name='由谁创建')),
            ],
        ),
        migrations.CreateModel(
            name='Post',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('message', models.TextField(max_length=4000, verbose_name='回复内容')),
                ('created_at', models.DateTimeField(default=datetime.datetime.now, verbose_name='回复时间')),
                ('updated_at', models.DateTimeField(default=datetime.datetime.now, verbose_name='更新时间')),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='posts', to=settings.AUTH_USER_MODEL, verbose_name='所属用户')),
                ('topic', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='boards.topic', verbose_name='所属主题')),
                ('updated_by', models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='+', to=settings.AUTH_USER_MODEL, verbose_name='由谁更新')),
            ],
        ),
    ]
