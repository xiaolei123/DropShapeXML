package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

/**
 * 设置属性的接口
 */
fun interface ShapeSetter
{
    fun applyTo(drawable: GradientDrawable)
}