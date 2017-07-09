# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.db.models import Q
from django.shortcuts import HttpResponse
from django.shortcuts import render
from django.http import JsonResponse, Http404
from django.contrib.auth import (
    login as login_auth,
    logout,
    get_user_model,
    user_logged_in,
    user_logged_out,
    user_login_failed,
    authenticate,
)
import json 
from .models import PersonalInfo, TrainingDetails, PlacementDetails

# Create your views here.


def index(request):
    return render(request,"dashboard.html")

def report(request):
    return render(request,"report.html")


def login(request):
   # username = json.load(request.POST)
    
    username=request.POST.get('username','')
    password = request.POST.get('password','')
    print username,password
    user = authenticate(username=username, password=password)
    print user
    if user:
	login_auth(request, user)
	return JsonResponse({"id":request.user.id})
    else:
        return JsonResponse({"result":404})
    return JsonResponse({"ok":"ok got it"})


def post_data_from_app(request):
    info = PersonalInfo()
    name = request.POST.get('name', '')
    dob = request.POST.get('dob', '')
    contact = request.POST.get('phone', '')
    education_level = request.POST.get('bg', '')
    p=PersonalInfo.objects.create(name=name,dob=dob, education_level=education_level, contact=contact)
    p.save()
    info = TrainingDetails()
    
    vocational_skills = request.POST.get('vc', '')
    life_skills = request.POST.get('skill', '')
    f = TrainingDetails.objects.create(uid=p,life_skills=life_skills, vocational_skills=vocational_skills, further_education='NA')
    f.save()
    currentemployer = request.POST.get('curEmp', '')
    salary = request.POST.get('curSal','')
    satisfied = request.POST.get('jobsatis', '')
    typeofemployment = request.POST.get('jobres', '')
    savings = request.POST.get('savings', '')
    expectations = request.POST.get('expect', '')
    d = PlacementDetails.objects.create(uid=p, currentemployer=currentemployer, salary=salary, typeofemployment=typeofemployment, satisfied=satisfied, savings=savings, expectations=expectations)
    d.save()
    return JsonResponse({"success":"ok"})


def report_person(request):
    query = request.GET.get( "q" )
    if query:
        qs = PersonalInfo.objects.filter(
            Q( name__icontains=query )
        )
        context = {"qs":qs}
    else:
        context = {}
    return render(request, "person.html", context)





