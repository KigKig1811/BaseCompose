package com.xt.notes.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

private val localCustomFontSizes = staticCompositionLocalOf { FontSizes() }

@Immutable
data class FontSizes(
    val sp11: TextUnit = 11.sp
)

object NetfChillTheme {
    val fontSizes: FontSizes
        @Composable
        get() = localCustomFontSizes.current
}

private val darkColorPalette = darkColorScheme(
    primary = AshGray,
    surfaceVariant = DarkGray,
    secondary = Teal200
)

private val lightColorPalette = lightColorScheme(
    primary = GRAY,
    surfaceVariant = DarkGray,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NetfChillTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
