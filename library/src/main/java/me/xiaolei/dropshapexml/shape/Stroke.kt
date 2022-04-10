package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

/**
 * 边框
 */
class Stroke : ShapeSetter
{
    /**
     * 边框宽度
     */
    var width: Int? = null

    /**
     * 边框颜色
     */
    var color: Int? = null

    /**
     * 虚线长度
     */
    var dashWidth: Float? = null

    /**
     * 虚线之间的宽度
     */
    var dashGap: Float? = null

    override fun applyTo(drawable: GradientDrawable)
    {
        width?.let { width ->
            color?.let { color ->
                drawable.setStroke(width, color, dashWidth ?: 0f, dashGap ?: 0f)
            }
        }
    }
}