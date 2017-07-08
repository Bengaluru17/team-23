# -*- coding: utf-8 -*-
# Generated by Django 1.11.1 on 2017-07-08 12:10
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('administration', '0005_activity'),
    ]

    operations = [
        migrations.AddField(
            model_name='shelterlife',
            name='lattitude',
            field=models.FloatField(default=0.0),
        ),
        migrations.AddField(
            model_name='shelterlife',
            name='longitude',
            field=models.FloatField(default=0.0),
        ),
        migrations.AddField(
            model_name='shelterlife',
            name='relationwithneighbours',
            field=models.FloatField(default=0.0),
        ),
        migrations.AddField(
            model_name='shelterlife',
            name='relationwithroommates',
            field=models.FloatField(default=0.0),
        ),
    ]
