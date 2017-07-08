# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.contrib import admin


from .models import PersonalInfo, TrainingDetails, PlacementDetails, shelterlife, activity


# Register your models here.

admin.site.register(PersonalInfo)
admin.site.register(TrainingDetails)
admin.site.register(PlacementDetails)
admin.site.register(shelterlife)
admin.site.register(activity)



















