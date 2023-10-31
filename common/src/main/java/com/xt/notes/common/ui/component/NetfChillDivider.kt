package com.xt.notes.common.ui.component

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xt.notes.common.ui.theme.NetfChillTheme


private const val DIVIDER_ALPHA = 0.12f

@Composable
fun NetfChillDivider(
    thickness: Int = 1,
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = DIVIDER_ALPHA),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness.dp,
    )
}

@Preview("default", showBackground = true)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun DividerPreview() {
    NetfChillTheme {
        Box(Modifier.size(height = 10.dp, width = 100.dp)) {
            NetfChillDivider(modifier = Modifier.align(Alignment.Center))
        }
    }
}
