package com.xt.feature_feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.xt.common.R
import com.xt.notes.common.model.NetfChillType
import com.xt.notes.common.model.NetfItem
import com.xt.notes.common.ui.Dimens
import com.xt.notes.common.ui.theme.NetfChillTheme
import com.xt.notes.common.utils.MainDestinations
import com.xt.notes.domain.model.FeedWrapper
import com.xt.notes.domain.model.Movie
import com.xt.notes.domain.model.SortType

@Composable
fun <T : NetfItem> FeedCollectionList(
    netfChillType: NetfChillType,
    navController: NavController,
    collection: List<FeedWrapper<T>>,
    onFeedClick: (NetfItem) -> Unit
) {
    LazyColumn {
        item {
            Spacer(
                modifier = Modifier.windowInsetsTopHeight(
                    WindowInsets.statusBars.add(
                        WindowInsets(top = 56.dp)
                    )
                )
            )
        }
        itemsIndexed(items = collection) { index, feedCollection ->
            FeedCollection(
                netfChillType = netfChillType,
                navController = navController,
                feedCollection = feedCollection,
                onFeedClick = onFeedClick,
                index = index
            )
        }
    }
}

@Composable
private fun <T : NetfItem> FeedCollection(
    netfChillType: NetfChillType,
    navController: NavController,
    feedCollection: FeedWrapper<T>,
    onFeedClick: (NetfItem) -> Unit,
    index: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 36.dp)
                .padding(start = Dimens.PaddingNormal)
        ) {
            Text(
                text = /*stringResource(id = feedCollection.sortTypeResourceId)*/ "",
                maxLines = 1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(
                text = stringResource(id = R.string.more_item),
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        when (netfChillType) {
                            NetfChillType.MOVIES -> {
                                when (feedCollection.sortType) {
                                    SortType.TRENDING ->
                                        navController.navigate(MainDestinations.NETFCHILL_TRENDING_MOVIES_ROUTE)

                                    SortType.MOST_POPULAR ->
                                        navController.navigate(MainDestinations.NETFCHILL_POPULAR_MOVIES_ROUTE)

                                    SortType.NOW_PLAYING ->
                                        navController.navigate(MainDestinations.NETFCHILL_NOW_PLAYING_MOVIES_ROUTE)

                                    SortType.UPCOMING ->
                                        navController.navigate(MainDestinations.NETFCHILL_UPCOMING_MOVIES_ROUTE)

                                    SortType.HIGHEST_RATED ->
                                        navController.navigate(MainDestinations.NETFCHILL_TOP_RATED_MOVIES_ROUTE)

                                    SortType.DISCOVER ->
                                        navController.navigate(MainDestinations.NETFCHILL_DISCOVER_MOVIES_ROUTE)
                                }
                            }

                            NetfChillType.TV_SERIES -> {
                                when (feedCollection.sortType) {
                                    SortType.TRENDING ->
                                        navController.navigate(MainDestinations.NETFCHILL_TRENDING_TV_SHOW_ROUTE)

                                    SortType.MOST_POPULAR ->
                                        navController.navigate(MainDestinations.NETFCHILL_POPULAR_TV_SHOW_ROUTE)

                                    SortType.NOW_PLAYING ->
                                        navController.navigate(MainDestinations.NETFCHILL_AIRING_TODAY_TV_SHOW_ROUTE)

                                    SortType.UPCOMING ->
                                        navController.navigate(MainDestinations.NETFCHILL_ON_THE_AIR_TV_SHOW_ROUTE)

                                    SortType.HIGHEST_RATED ->
                                        navController.navigate(MainDestinations.NETFCHILL_TOP_RATED_TV_SHOW_ROUTE)

                                    SortType.DISCOVER ->
                                        navController.navigate(MainDestinations.NETFCHILL_DISCOVER_TV_SHOW_ROUTE)
                                }
                            }
                        }
                    }
                    .padding(Dimens.PaddingNormal)
            )
        }
        Feeds(
            index = index,
            feeds = feedCollection.feeds,
            onFeedClick = onFeedClick
        )
    }
}

@Composable
private fun <T : NetfItem> Feeds(
    index: Int,
    feeds: List<T>,
    onFeedClick: (NetfItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = Dimens.PaddingMicro,
            end = Dimens.PaddingMicro
        )
    ) {
        items(feeds) { feed ->
            NetfItem(
                index = index,
                netfItem = feed,
                onFeedClick = onFeedClick
            )
        }
    }
}

@Composable
private fun <T : NetfItem> NetfItem(
    index: Int,
    netfItem: T,
    onFeedClick: (NetfItem) -> Unit
) {
    val itemWidth: Dp
    val imageUrl: String?

    if (index % 3 == 0) {
        itemWidth = 220.dp
        imageUrl = netfItem.backdropUrl
    } else {
        itemWidth = 120.dp
        imageUrl = netfItem.posterUrl
    }
    Card(
        modifier = Modifier
            .padding(Dimens.PaddingSmall)
            .clickable { onFeedClick(netfItem) },
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(
                    width = itemWidth,
                    height = 180.dp
                )
            )
            Text(
                text = netfItem.name,
                fontSize = NetfChillTheme.fontSizes.sp11,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .size(
                        width = itemWidth,
                        height = 36.dp
                    )
                    .wrapContentWidth()
            )
        }
    }
}

@Preview("default")
@Composable
fun FeedCardPreview() {
    NetfChillTheme {
        val movie = Movie(1, "", null, null, null, "Movie", 1.0, 2)
        NetfItem(index = 0, netfItem = movie, onFeedClick = {})
    }
}
