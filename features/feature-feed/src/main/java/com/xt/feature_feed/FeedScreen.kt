package com.xt.feature_feed

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.xt.common.R
import com.xt.notes.common.model.NetfChillType
import com.xt.notes.common.model.NetfItem
import com.xt.notes.common.ui.Content
import com.xt.notes.common.ui.component.DestinationBar

@Composable
fun MovieFeedScreen(
    onClick: (NetfItem) -> Unit,
    navController: NavController,
    viewModel: MovieFeedViewModel = hiltViewModel()
) {
    FeedScreen(
        viewModel = viewModel,
        type = NetfChillType.MOVIES,
        navController = navController,
        onClick = onClick,
        resourceId = R.string.movies
    )
}

@Composable
private fun <T : NetfItem> FeedScreen(
    viewModel: BaseFeedViewModel<T>,
    type: NetfChillType,
    navController: NavController,
    onClick: (NetfItem) -> Unit,
    @StringRes resourceId: Int
) {
    Content(viewModel = viewModel) { feeds ->
        Box {
            FeedCollectionList(
                netfChillType = type,
                navController = navController,
                collection = feeds,
                onFeedClick = onClick
            )
            DestinationBar(
                title = stringResource(
                    R.string.app_title, stringResource(resourceId)
                ), navController = navController, type = type
            )
        }
    }
}
