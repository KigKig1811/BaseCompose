package com.xt.notes.common.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xt.common.R
import com.xt.notes.common.model.NetfChillType
import com.xt.notes.common.ui.theme.AlphaNearOpaque
import com.xt.notes.common.utils.MainDestinations

@Composable
fun DestinationBar(
    title: String,
    type: NetfChillType? = null,
    navController: NavController,
    upPress: (() -> Unit)? = null,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.statusBarsPadding()
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colorScheme.background.copy(alpha = AlphaNearOpaque),
            contentColor = MaterialTheme.colorScheme.onSurface,
            elevation = 0.dp
        ) {
            IconButton(
                onClick = { upPress?.invoke() },
                modifier = Modifier
                    .alpha(if (upPress == null) 0f else 1f)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(
                onClick = {
                    when (type) {
                        NetfChillType.MOVIES -> navController.navigate(MainDestinations.NETFCHILL_SEARCH_MOVIE_ROUTE)
                        NetfChillType.TV_SERIES -> navController.navigate(MainDestinations.NETFCHILL_SEARCH_TV_SHOW_ROUTE)
                        else -> {}
                    }
                },
                modifier = Modifier
                    .alpha(if (type == null) 0f else 1f)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = type?.let {
                        stringResource(
                            id = R.string.search,
                            it.name
                        )
                    }
                )
            }
        }
        NetfChillDivider()
    }
}

