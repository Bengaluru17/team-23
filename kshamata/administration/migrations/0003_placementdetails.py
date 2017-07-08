# -*- coding: utf-8 -*-
# Generated by Django 1.11.1 on 2017-07-08 11:41
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('administration', '0002_trainingdetails'),
    ]

    operations = [
        migrations.CreateModel(
            name='PlacementDetails',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('currentemployer', models.CharField(max_length=40)),
                ('salary', models.IntegerField(max_length=6)),
                ('typeofemployment', models.CharField(max_length=40)),
                ('satisfied', models.BooleanField(default=True)),
                ('savings', models.IntegerField(max_length=6)),
                ('expectations', models.CharField(max_length=100)),
                ('uid', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, to='administration.PersonalInfo')),
            ],
        ),
    ]
