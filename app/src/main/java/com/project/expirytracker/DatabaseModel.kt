package com.project.expirytracker

import androidx.room.Entity


@Entity
data class DatabaseModel(
    val id:Int,
    val name:String,
    val quantity:Short,
    val type:String,

    val mfgYear:Short,
    val mfgMonth:Byte,
    val mfgDate:Byte,

    val expYear:Short,
    val expMonth:Byte,
    val expDate:Byte,

    val itemPrice:Short
)


