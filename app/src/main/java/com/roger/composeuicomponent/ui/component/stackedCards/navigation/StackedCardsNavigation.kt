package com.roger.composeuicomponent.ui.component.stackedCards.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.roger.composeuicomponent.ui.component.stackedCards.StackedCardsScreen

const val stackedCardsNavigationRoute = "stacked_cards_route"

fun NavController.navigateToStackedCards(navOptions: NavOptions? = null) {
    this.navigate(stackedCardsNavigationRoute, navOptions)
}

fun NavGraphBuilder.stackedCardsScreen() {
    composable(
        route = stackedCardsNavigationRoute,
    ) {
        StackedCardsScreen()
    }
}