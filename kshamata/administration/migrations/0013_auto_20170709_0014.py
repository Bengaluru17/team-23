# -*- coding: utf-8 -*-
# Generated by Django 1.11 on 2017-07-09 00:14
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('administration', '0012_personalinfo_dob'),
    ]

    operations = [
        migrations.AlterField(
            model_name='personalinfo',
            name='dob',
            field=models.DateField(default='2001-01-01'),
        ),
    ]
