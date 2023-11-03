package com.xt.paging.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.xt.notes.common.model.NetfChillType
import com.xt.notes.common.model.NetfItem
import com.xt.notes.common.ui.Dimens
import com.xt.notes.common.ui.component.DestinationBar
import com.xt.notes.common.ui.component.ErrorScreen
import com.xt.notes.common.ui.component.NetfChillProgressBar
import com.xt.notes.common.utils.toDp
import com.xt.paging.movie.TrendingMoviesViewModel

@Composable
fun TrendingMovieScreen(
    navController: NavController,
    onClick: (NetfItem) -> Unit,
    upPress: () -> Unit,
    viewModel: TrendingMoviesViewModel = hiltViewModel()
) {

}

@Composable
private fun <T : NetfItem> PagingScreen(
    title: String,
    type: NetfChillType,
    upPress: () -> Unit,
    onClick: (NetfItem) -> Unit,
    navController: NavController,
    viewModel: BasePagingViewModel<T>
) {
    Box {
        PagingScreen(onClick = onClick, viewModel = viewModel)
        DestinationBar(title = title, navController = navController, upPress = upPress, type = type)
    }

}

@Composable
private fun <T : NetfItem> PagingScreen(
    onClick: (NetfItem) -> Unit,
    viewModel: BasePagingViewModel<T>
) {
    val lazyNetfItems = viewModel.pagingDataFlow.collectAsLazyPagingItems()

    when (lazyNetfItems.loadState.refresh) {
        is LoadState.Loading -> {
            NetfChillProgressBar()
        }

        is LoadState.Error -> {
            val message =
                (lazyNetfItems.loadState.refresh as? LoadState.Error)?.error?.message ?: return

            ErrorScreen(
                message = message,
                refresh = { lazyNetfItems.refresh() },
                modifier = Modifier.fillMaxSize()
            )
        }

        else -> {

        }
    }
}

@Composable
private fun <T : NetfItem> LazyNetfItemGrid(
    lazyNetfItems: LazyPagingItems<T>,
    onClick: (NetfItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        contentPadding = PaddingValues(
            start = Dimens.PaddingMedium,
            end = Dimens.PaddingMedium,
            bottom = WindowInsets.navigationBars.getBottom(LocalDensity.current)
                .toDp().dp.plus(
                    Dimens.PaddingMedium
                )

        ),
        horizontalArrangement = Arrangement.spacedBy(
            Dimens.PaddingMedium,
            Alignment.CenterHorizontally
        ),
        content = {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(
                    modifier = Modifier.windowInsetsTopHeight(
                        WindowInsets.statusBars.add(WindowInsets(top = 56.dp))
                    )
                )
            }

            items(count = lazyNetfItems.itemCount) { index ->
                val netfItem = lazyNetfItems[index] ?: return@items

            }
        }
    )

}
