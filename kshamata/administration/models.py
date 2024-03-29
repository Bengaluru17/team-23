# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class PersonalInfo(models.Model):
    uid = models.AutoField(primary_key=True)
    name = models.CharField(max_length=20)
    dob = models.CharField(max_length=10)
    # photo = models.ImageField(upload_to="profile/img", null=True)
    education_level = models.CharField(max_length=30)
    date_since_joining = models.DateField(auto_now_add=True, auto_now=False)
    contact = models.CharField(max_length = 20)

    def __unicode__(self):
        return self.name


class TrainingDetails(models.Model):
    uid = models.OneToOneField(PersonalInfo)
    life_skills = models.CharField(max_length=40)
    vocational_skills = models.CharField(max_length=200)
    further_education = models.CharField(max_length=100)
    def __unicode__(self):
        return self.uid.name

class PlacementDetails(models.Model):
    uid = models.OneToOneField(PersonalInfo)
    currentemployer = models.CharField(max_length=40)
    salary = models.CharField(max_length = 6)
    typeofemployment = 	models.CharField(max_length=40)
    satisfied = models.BooleanField(default = True)
    savings = models.CharField(max_length = 6)
    expectations = models.CharField(max_length=100)
    
    def __unicode__(self):
        return self.uid.name

class shelterlife(models.Model):
    uid = models.OneToOneField(PersonalInfo)
    longitude = models.FloatField(default = 0.0)
    lattitude = models.FloatField(default = 0.0)
    shared = models.BooleanField()
    avgexpense = models.IntegerField(max_length = 6)
    savings = models.IntegerField(max_length = 6)
    relationwithroommates = models.FloatField(default = 0.0)
    relationwithneighbours = models.FloatField(default = 0.0)

    def __unicode__(self):
        return self.uid.name


class activity(models.Model):
    uid = models.OneToOneField(PersonalInfo)
    institution = models.CharField(max_length = 20)
    startdate = models.DateField(auto_now_add = True,auto_now = False)
    enddate = models.DateField(auto_now_add = True,auto_now = False)
    duration = models.IntegerField(max_length = 20)
    natureofactivity =  models.CharField(max_length=100)
    noofwomen =  models.IntegerField(max_length = 100)
    expectedoutcome = models.CharField(max_length=100)
    obtainedoutcome = models.CharField(max_length=100)
    amountspend = models.IntegerField(max_length = 6)

