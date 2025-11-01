package com.ifsha.shrassignment.components.histogram

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifsha.shrassignment.enums.WeekDay
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun HistogramCard(
    weekDayList: List<HistogramItemModel>
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                WeekHistogram(weekDayList = weekDayList)
            }
            Text(
                text = getTodayDate(),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
@Preview
fun HistogramCardPreview() {
    HistogramCard(
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

@Composable
@Preview(showBackground = true)
fun ShowScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        HistogramCardPreview()
    }
}

fun getTodayDate(): String {
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("d MMM")
    val formattedDate = today.format(formatter)
    return formattedDate
}