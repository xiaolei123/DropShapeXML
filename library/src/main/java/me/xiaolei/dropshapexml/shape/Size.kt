package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

/**
 * 大小
 */
class Size : ShapeSetter
{
    var width: Int? = null

    var height: Int? = null

    override fun applyTo(drawable: GradientDrawable)
    {
        if (width != null || height != null)
            drawable.setSize(width ?: -1, height ?: -1)
    }
}