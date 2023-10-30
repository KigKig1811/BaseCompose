package com.xt.notesapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xt.notesapp.utils.HomeSections

@Composable
fun rememberNetfChillAppState(
    navHostController: NavHostController = rememberNavController()
) = remember(navHostController) {
    NetfChillAppState(navHostController)
}


@Stable
class NetfChillAppState(val navHostController: NavHostController) {

    //BottomBar state
    val bottomBarTabs = HomeSections.values()
    private val bottomBarRoutes = bottomBarTabs.map { it.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes

    //Navigation state
    val currentRoute: String?
        get() = navHostController.currentDestination?.route

    fun navigationToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navHostController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(findStartDestination(navHostController.graph).id) {
                    saveState = true
                }
            }
        }
    }
}
private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}
