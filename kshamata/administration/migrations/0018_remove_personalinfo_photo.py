# -*- coding: utf-8 -*-
# Generated by Django 1.11 on 2017-07-09 01:35
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('administration', '0017_auto_20170709_0134'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='personalinfo',
            name='photo',
        ),
    ]