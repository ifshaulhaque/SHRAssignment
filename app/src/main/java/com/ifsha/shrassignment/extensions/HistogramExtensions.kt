package com.ifsha.shrassignment.extensions

import com.ifsha.shrassignment.components.histogram.HistogramItemModel

fun List<HistogramItemModel>.setHeight() {
    var maxMessageCount = 0
    for (item in this) {
        maxMessageCount = Math.max(maxMessageCount, item.score)
    }

    val factor = Constants.HISTOGRAM_HEIGHT_REFERENCE/maxMessageCount

    for (item in this) {
        item.height = item.score * factor
    }
}

object Constants {
    const val HISTOGRAM_HEIGHT_REFERENCE = 160f
}