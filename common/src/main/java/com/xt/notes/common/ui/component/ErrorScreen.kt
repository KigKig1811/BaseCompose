package com.xt.notes.common.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xt.common.R

@Composable
fun ErrorScreen(
    message: String,
    refresh: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message, style = MaterialTheme.typography.subtitle1.copy(
                color = MaterialTheme.colors.onSurface,
                letterSpacing = 1.5.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W400
            )

        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = refresh) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(message = "Error", refresh = {})
}
