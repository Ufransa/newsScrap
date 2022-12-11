package com.example.newsscrap.themes

import android.content.Context
import android.graphics.drawable.ColorDrawable
import com.dolatkia.animatedThemeManager.AppTheme

interface MyAppTheme : AppTheme {
    fun activityBackgroundColor(context: Context): Int
    fun activityImageQuote(context: Context): Int
    fun activityImageTrazado(context: Context): Int
    fun activityIconColor(context: Context): Int
    fun activityTextColor(context: Context): Int
    fun activityThemeButtonColor(context: Context): Int
    fun activityActionBar(context: Context): ColorDrawable
    fun activityActionBarLogo(context: Context): Int
}