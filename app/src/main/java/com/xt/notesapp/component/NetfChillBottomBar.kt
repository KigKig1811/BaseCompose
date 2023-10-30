package com.xt.notesapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.xt.notesapp.utils.HomeSections

@Composable
fun NetfChillBottomBar(
    tabs: Array<HomeSections>,
    currentRoute: String,
    navigateToRoute: (String) -> Unit
) {
    val currentRoute = tabs.first { it.route == currentRoute }

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .navigationBarsPadding()
    ) {
        BottomNavigation {
            tabs.forEach { section ->
                val selected = section == currentRoute
                BottomNavigationItem(
                    selected = selected,
                    label = {
                        Text(text = stringResource(id = section.resTitle))
                    },
                    icon = {
                        Icon(
                            imageVector = if (selected) section.selectedIcon else section.unSelectedIcon,
                            contentDescription = stringResource(
                                id = section.resTitle
                            )
                        )
                    },
                    unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                    onClick = { navigateToRoute(section.route) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun NetfChillBottomBarPreview() {
    NetfChillBottomBar(
        tabs = HomeSections.values(),
        currentRoute = HomeSections.MOVIE_SECTION.route,
        navigateToRoute = {}
    )
}
