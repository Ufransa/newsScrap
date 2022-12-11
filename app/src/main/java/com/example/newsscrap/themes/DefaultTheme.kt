package com.example.newsscrap.themes

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import com.example.newsscrap.R

class DefaultTheme : MyAppTheme {

    companion object {
        val ThemeId = 0
    }

    override fun id(): Int {
        return ThemeId
    }

    override fun activityBackgroundColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.background_default)
    }

    override fun activityImageQuote(context: Context): Int {
        return R.drawable.quote
    }

    override fun activityImageTrazado(context: Context): Int {
        return R.drawable.trazado_110
    }

    override fun activityIconColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.icon_default)
    }

    override fun activityTextColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.text_default)
    }

    override fun activityThemeButtonColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.button_default)
    }

    override fun activityActionBar(context: Context): ColorDrawable {
        return ColorDrawable(Color.parseColor("#E7E9F7"))
    }

    override fun activityActionBarLogo(context: Context): Int {
        return R.drawable.logo_azul_horizontal_250
    }
}