package com.roger.composeuicomponent.ui.component.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onSwipeableCardClick: () -> Unit,
    onDotProgressClick: () -> Unit,
    onStackedCardsClick: () -> Unit,
    onPanZoomImageClick: () -> Unit,
) {
    Column {
        Button(onClick = {
            onSwipeableCardClick()
        }) {
            Text("Go to Swipeable Card")
        }
        Button(onClick = {
            onDotProgressClick()
        }) {
            Text("Go to Dot Progress")
        }
        Button(onClick = {
            onStackedCardsClick()
        }) {
            Text("Go to Stacked Cards")
        }
        Button(onClick = {
            onPanZoomImageClick()
        }) {
            Text("Go to Pan Zoom Image")
        }
    }
}