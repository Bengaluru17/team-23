# -*- coding: utf-8 -*-
from __future__ import unicode_literals
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
from .models import PersonalInfo

# Create your views here.


def index(request):
    return render(request,"dashboard.html")


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
    info.name = request.POST.get('name', '')
    info.dob = request.POST.get('name', '')



