package com.xt.notesapp.utils

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.xt.notesapp.R

enum class HomeSections(
    val route: String,
    @StringRes val resTitle: Int,
    val unSelectedIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    MOVIE_SECTION("Movie", R.string.movie, Icons.Outlined.Movie, Icons.Filled.Movie),
    TV_SHOW_SECTION("TVShow", R.string.tv_show, Icons.Outlined.LiveTv, Icons.Filled.LiveTv),
    BOOKMARK_SECTION("Bookmark", R.string.favorite, Icons.Outlined.Favorite, Icons.Filled.Favorite),
    SETTING_SECTION("Setting", R.string.setting, Icons.Outlined.Settings, Icons.Filled.Settings)
}
