package com.hermawan.indomount
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
//ini menunjukan class data
data class Mountain(
    var photo: Int,
    var name: String,
    var desc: String,
    var geography: String,
    var peakHeight: String,
    var mountainType: String,
    var lowestTemperature: String,
    var climbingDuration: String,
    var myth: String,
    var description: String
) : Parcelable