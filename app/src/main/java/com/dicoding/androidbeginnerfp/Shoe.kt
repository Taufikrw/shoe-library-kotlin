package com.dicoding.androidbeginnerfp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    val name: String,
    val desc: String,
    val category: String,
    val price: String,
    val photo: Int,
    val photo2: Int,
    val photo3: Int
) : Parcelable