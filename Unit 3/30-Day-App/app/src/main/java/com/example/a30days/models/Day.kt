package com.example.a30days.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
)
