package com.roger.composeuicomponent.ui.component.swipeableCard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.roger.composeuicomponent.ui.component.swipeableCard.SwipeableCardScreen

const val swipeableCardNavigationRoute = "swipeable_card_route"

fun NavController.navigateToSwipeableCard(navOptions: NavOptions? = null) {
    this.navigate(swipeableCardNavigationRoute, navOptions)
}

fun NavGraphBuilder.swipeableCardScreen() {
    composable(
        route = swipeableCardNavigationRoute,
    ) {
        SwipeableCardScreen()
    }
}