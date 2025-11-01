package com.ifsha.shrassignment.components.histogram

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifsha.shrassignment.R
import com.ifsha.shrassignment.enums.WeekDay

@Composable
fun HistogramItem(
    histogramItemModel: HistogramItemModel
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            4.dp
        )
    ) {
        Box(
            modifier = Modifier
                .width(15.dp)
                .height(histogramItemModel.height.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.primary_gradient),
                            colorResource(id = R.color.primary),
                        )
                    )
                )
        ) {
            Text(
                text = histogramItemModel.score.toString(),
                color = colorResource(id = R.color.dark_background),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .rotate(-90f)
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }

        Text(
            text = histogramItemModel.weekDay.fullName.substring(0,2).uppercase(),
            color = Color.Gray,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
@Preview
fun HistogramItemPreview() {
    HistogramItem(
        histogramItemModel = HistogramItemModel(
            weekDay = WeekDay.SATURDAY,
            score = 10,
            height = 100f
        )
    )
}