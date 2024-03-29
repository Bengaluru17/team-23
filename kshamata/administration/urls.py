"""kshamata URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url, include
from . import views


urlpatterns = [

    # url(r'^index/$', views.index, name="index"),
    # url(r'phptest/$', views.phptest, name="php"),

    url(r'^index/$', views.index, name="index"),
    url(r'^report/$', views.report, name="report"),
    url(r'^person/$', views.report_person, name="report_person"),
    url(r'^post_data/$', views.post_data_from_app, name="post_data"),
    url(r'login/$', views.login, name="login"),

]
