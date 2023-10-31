package com.xt.notesapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.xt.feature_feed.base.MovieFeedScreen
import com.xt.feature_feed.base.TvShowScreen
import com.xt.notes.common.utils.MainDestinations
import com.xt.notesapp.component.NetfChillBottomBar
import com.xt.notesapp.utils.HomeSections

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetfChillApp() {
    val appState = rememberNetfChillAppState()
    Scaffold(bottomBar = {
        if (appState.shouldShowBottomBar) {
            NetfChillBottomBar(
                tabs = appState.bottomBarTabs,
                currentRoute = appState.currentRoute!!,
                navigateToRoute = appState::navigationToBottomBarRoute
            )
        }
    }) { innerPaddingModifier ->
        NavHost(
            navController = appState.navHostController,
            startDestination = MainDestinations.HOME_ROUTE,
            modifier = Modifier.padding(innerPaddingModifier)
        ) {
            navigationScreens(
                onMovieSelected = appState::navigateToMovieDetail,
                onTvShowSelected = {},
                navController = appState.navHostController
            )
        }
    }
}

private fun NavGraphBuilder.navigationScreens(
    onMovieSelected: (Int) -> Unit,
    onTvShowSelected: (Int) -> Unit,
    navController: NavController,
) {
    navigation(
        route = MainDestinations.HOME_ROUTE, startDestination = HomeSections.MOVIE_SECTION.route
    ) {
        composable(route = HomeSections.MOVIE_SECTION.route) {
            MovieFeedScreen(onClick = { onMovieSelected(it.id) }, navController = navController)
        }
        composable(route = HomeSections.TV_SHOW_SECTION.route) {
            TvShowScreen(onClick = { onTvShowSelected(it.id) }, navController = navController)
        }
        composable(route = HomeSections.BOOKMARK_SECTION.route) {

        }
        composable(route = HomeSections.SETTING_SECTION.route) {

        }
    }
}

private fun NavGraphBuilder.detailScreens() {
    composable(
        route = "${MainDestinations.NETFCHILL_MOVIE_DETAIL_ROUTE}/{${MainDestinations.NETFCHILL_ID_KEY}}",
        arguments = listOf(
            navArgument(MainDestinations.NETFCHILL_ID_KEY) { type = NavType.IntType })
    ) {

    }
}
