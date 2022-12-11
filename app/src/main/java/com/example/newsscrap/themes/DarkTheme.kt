package com.example.newsscrap.themes

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import com.example.newsscrap.R

class DarkTheme : MyAppTheme {

    companion object {
        val ThemeId = 1
    }

    override fun id(): Int {
        return ThemeId
    }

    override fun activityBackgroundColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.background_night)
    }

    override fun activityImageQuote(context: Context): Int {
        return R.drawable.quote_dark
    }

    override fun activityImageTrazado(context: Context): Int {
        return R.drawable.trazado_dark
    }

    override fun activityIconColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.icon_night)
    }

    override fun activityTextColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.text_night)
    }

    override fun activityThemeButtonColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.button_night)
    }

    override fun activityActionBar(context: Context): ColorDrawable {
        return ColorDrawable(Color.parseColor("#8b8b8b"))
    }

    override fun activityActionBarLogo(context: Context): Int {
        return R.drawable.logo_blanco_horizontal_250
    }
}