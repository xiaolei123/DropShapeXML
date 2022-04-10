package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

/**
 * Shape的类型
 */
enum class Shape(val value: Int)
{
    RECTANGLE(GradientDrawable.RECTANGLE),
    OVAL(GradientDrawable.OVAL),
    LINE(GradientDrawable.LINE),
    RING(GradientDrawable.RING)
}