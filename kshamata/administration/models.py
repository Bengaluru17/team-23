# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class PersonalInfo(models.Model):
    uid = models.AutoField(primary_key=True)
    name = models.CharField(max_length=20)
    age = models.IntegerField(max_length=3)
    photo = models.ImageField(upload_to="profile/img")
    education_level = models.CharField(max_length=30)
    date_since_joining = models.DateField(auto_now_add=True, auto_now=False)


class TrainingDetails(models.Model):
    uid = models.OneToOneField(PersonalInfo)
    life_skills = models.CharField(max_length=40)
    vocational_skills = models.CharField(max_length=200)
    further_education = models.CharField(max_length=100)
