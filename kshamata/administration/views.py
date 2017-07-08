# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.shortcuts import HttpResponse
from django.shortcuts import render
from django.http import JsonResponse
# from django.views.decorators.csrf import crf_exempt

# Create your views here.


def index(request):
    if request.POST is True:
	print(request.POST)
    return JsonResponse({"count":1})


def phptest(request):
    return render(request,"phpAndroidAccess.php")    
