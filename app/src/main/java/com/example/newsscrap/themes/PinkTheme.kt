package com.example.newsscrap.themes

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import com.example.newsscrap.R

class PinkTheme : MyAppTheme {

    companion object {
        val ThemeId = 2
    }

    override fun id(): Int {
        return ThemeId
    }

    override fun activityBackgroundColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.background_pink)
    }

    override fun activityImageQuote(context: Context): Int {
        return R.drawable.quote_pink
    }

    override fun activityImageTrazado(context: Context): Int {
        return R.drawable.trazado_pink
    }

    override fun activityIconColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.icon_pink)
    }

    override fun activityTextColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.text_pink)
    }

    override fun activityThemeButtonColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.button_pink)
    }

    override fun activityActionBar(context: Context): ColorDrawable {
        return ColorDrawable(Color.parseColor("#f100c9"))
    }

    override fun activityActionBarLogo(context: Context): Int {
        return R.drawable.logo_negro_horizontal_250
    }

}