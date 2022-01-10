package com.example.myandroidkotlin.parcelable

import android.os.Parcel
import android.os.Parcelable

class Person(var name:String,var age:Int) : Parcelable {

    constructor(parcel: Parcel) : this("",0) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel.readString() ?: "", parcel.readInt())
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}