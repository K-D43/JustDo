package com.example.justdo.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "Notes")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    var id:Int ?= null,
    var title:String,
    var subTitle:String,
    var notes:String,
    var date:String,
    var priority:String
):Parcelable