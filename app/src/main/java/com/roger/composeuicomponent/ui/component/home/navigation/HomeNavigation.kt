package com.roger.composeuicomponent.ui.component.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.roger.composeuicomponent.ui.component.home.HomeScreen

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onSwipeableCardClick: () -> Unit,
    onDotProgressClick: () -> Unit,
    onStackedCardsClick: () -> Unit,
    onPanZoomImageClick: () -> Unit,
) {
    composable(
        route = homeNavigationRoute,
    ) {
        HomeScreen(
            onSwipeableCardClick = onSwipeableCardClick,
            onDotProgressClick = onDotProgressClick,
            onStackedCardsClick = onStackedCardsClick,
            onPanZoomImageClick = onPanZoomImageClick,
        )
    }
}