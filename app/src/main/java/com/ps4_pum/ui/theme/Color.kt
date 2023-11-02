package com.ps4_pum.ui.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFFA9A9A9 )
val PrimaryLightColor = Color(0xFFBB86FC)
val SecondaryColor = Color(0xFF03DAC5)
val BackgroundColor = Color(0xFF59AFF0 )
val SurfaceColor = Color(0xFFFFFFFF)
val ErrorColor = Color(0xFFB00020)
val OnPrimaryColor = Color(0xFFFFFFFF)
val OnSecondaryColor = Color(0xFF000000)
val OnBackgroundColor = Color(0xFF000000)
val OnSurfaceColor = Color(0xFF000000)
val OnErrorColor = Color(0xFFFFFFFF)

val ColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryLightColor,
    secondary = SecondaryColor,
    background = BackgroundColor,
    surface = SurfaceColor,
    error = ErrorColor,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onBackground = OnBackgroundColor,
    onSurface = OnSurfaceColor,
    onError = OnErrorColor
)