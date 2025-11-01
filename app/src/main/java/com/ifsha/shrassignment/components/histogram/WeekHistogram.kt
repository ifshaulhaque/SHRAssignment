package com.ifsha.shrassignment.components.histogram

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ifsha.shrassignment.enums.WeekDay
import com.ifsha.shrassignment.extensions.setHeight

@Composable
fun WeekHistogram(
    weekDayList: List<HistogramItemModel>
) {
    weekDayList.setHeight()
    
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (item in weekDayList) {
            HistogramItem(histogramItemModel = item)
        }
    }
}

@Composable
@Preview
fun WeekHistogramPreview() {
    WeekHistogram(
        weekDayList = listOf(
            HistogramItemModel(
                weekDay = WeekDay.FRIDAY,
                score = 12,
            ),
            HistogramItemModel(
                weekDay = WeekDay.SATURDAY,
                score = 7,
            ),
            HistogramItemModel(
                weekDay = WeekDay.SUNDAY,
                score = 9,
            ),
            HistogramItemModel(
                weekDay = WeekDay.MONDAY,
                score = 3,
            ),
            HistogramItemModel(
                weekDay = WeekDay.TUESDAY,
                score = 10,
            ),
            HistogramItemModel(
                weekDay = WeekDay.WEDNESDAY,
                score = 5,
            ),
            HistogramItemModel(
                weekDay = WeekDay.THURSDAY,
                score = 4,
            ),
        ) 
    )
}