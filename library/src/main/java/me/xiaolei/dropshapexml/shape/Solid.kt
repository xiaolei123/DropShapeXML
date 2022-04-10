package me.xiaolei.dropshapexml.shape

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * 背景色
 */
class Solid(private val context: Context) : ShapeSetter
{
    @ColorInt
    var color: Int? = null

    @ColorRes
    var colorId: Int? = null

    override fun applyTo(drawable: GradientDrawable)
    {
        val color = color ?: let { colorId?.let { ContextCompat.getColor(context, it) } }
        color?.let { drawable.setColor(it) }
    }
}