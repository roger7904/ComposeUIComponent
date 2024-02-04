package com.roger.composeuicomponent.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.roger.composeuicomponent.ui.component.dotsProgress.navigation.dotProgressScreen
import com.roger.composeuicomponent.ui.component.dotsProgress.navigation.navigateToDotProgress
import com.roger.composeuicomponent.ui.component.home.navigation.homeNavigationRoute
import com.roger.composeuicomponent.ui.component.home.navigation.homeScreen
import com.roger.composeuicomponent.ui.component.panZoomImage.navigation.navigateToPanZoomImage
import com.roger.composeuicomponent.ui.component.panZoomImage.navigation.panZoomImageScreen
import com.roger.composeuicomponent.ui.component.stackedCards.navigation.navigateToStackedCards
import com.roger.composeuicomponent.ui.component.stackedCards.navigation.stackedCardsScreen
import com.roger.composeuicomponent.ui.component.swipeableCard.navigation.navigateToSwipeableCard
import com.roger.composeuicomponent.ui.component.swipeableCard.navigation.swipeableCardScreen

@Composable
fun UIApp() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = homeNavigationRoute
    ) {
        homeScreen(
            onSwipeableCardClick = {
                navController.navigateToSwipeableCard()
            },
            onDotProgressClick = {
                navController.navigateToDotProgress()
            },
            onStackedCardsClick = {
                navController.navigateToStackedCards()
            },
            onPanZoomImageClick = {
                navController.navigateToPanZoomImage()
            },
        )
        swipeableCardScreen()
        dotProgressScreen()
        stackedCardsScreen()
        panZoomImageScreen()
    }
}