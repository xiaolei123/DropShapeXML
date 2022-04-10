package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

/**
 * 圆角
 */
class Corners : ShapeSetter
{
    /**
     * 左上角
     */
    var leftTopRadius: Float? = null

    /**
     * 右上角
     */
    var rightTopRadius: Float? = null

    /**
     * 右下角
     */
    var rightBottomRadius: Float? = null

    /**
     * 左下角
     */
    var leftBottomRadius: Float? = null

    /**
     * 整体设置，如果其他角度已经设置，则使用已设置的，如果其他角度没有设置，则使用整体角度
     */
    var radius: Float = 0f

    override fun applyTo(drawable: GradientDrawable)
    {
        drawable.cornerRadii = floatArrayOf(
            leftTopRadius ?: radius,
            leftTopRadius ?: radius,
            rightTopRadius ?: radius,
            rightTopRadius ?: radius,
            rightBottomRadius ?: radius,
            rightBottomRadius ?: radius,
            leftBottomRadius ?: radius,
            leftBottomRadius ?: radius,
        )
    }
}
