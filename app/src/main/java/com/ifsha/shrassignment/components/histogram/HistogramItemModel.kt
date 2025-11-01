package com.ifsha.shrassignment.components.histogram

import com.ifsha.shrassignment.enums.WeekDay

data class HistogramItemModel(
    val weekDay: WeekDay,
    val score: Int,
    var height: Float = 0f
)
