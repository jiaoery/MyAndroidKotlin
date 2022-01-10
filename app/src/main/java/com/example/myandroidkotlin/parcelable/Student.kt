package com.example.myandroidkotlin.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.collections.List as List

@Parcelize
class Student(var username:String,var age:Int,var data: List<Person>): Parcelable