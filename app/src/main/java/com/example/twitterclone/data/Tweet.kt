package com.example.twitterclone.data

import androidx.annotation.DrawableRes
import com.example.twitterclone.R

data class Tweet(
    val user: String,
    val userName: String,
    val postTime: String,
    val text: String,
    @DrawableRes
    val photo: Int = R.drawable.img_profile_photo
)
