package com.roger.composeuicomponent.ui.component.panZoomImage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.roger.composeuicomponent.ui.component.panZoomImage.PanZoomImageScreen

const val panZoomImageNavigationRoute = "pan_zoom_image_route"

fun NavController.navigateToPanZoomImage(navOptions: NavOptions? = null) {
    this.navigate(panZoomImageNavigationRoute, navOptions)
}

fun NavGraphBuilder.panZoomImageScreen() {
    composable(
        route = panZoomImageNavigationRoute,
    ) {
        PanZoomImageScreen()
    }
}