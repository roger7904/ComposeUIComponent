package com.roger.composeuicomponent.ui.component.dotsProgress.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.roger.composeuicomponent.ui.component.dotsProgress.DotsProgressScreen

const val dotProgressNavigationRoute = "dot_progress_route"

fun NavController.navigateToDotProgress(navOptions: NavOptions? = null) {
    this.navigate(dotProgressNavigationRoute, navOptions)
}

fun NavGraphBuilder.dotProgressScreen() {
    composable(
        route = dotProgressNavigationRoute,
    ) {
        DotsProgressScreen()
    }
}