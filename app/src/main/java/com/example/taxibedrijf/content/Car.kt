package com.example.taxibedrijf.content

import android.os.Parcel
import android.os.Parcelable

class Car(var kenteken: String, var merk: String, var datumTenaamstelling: String) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kenteken)
        parcel.writeString(merk)
        parcel.writeString(datumTenaamstelling)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: Parcel): Car {
            return Car(parcel)
        }

        override fun newArray(size: Int): Array<Car?> {
            return arrayOfNulls(size)
        }
    }
}