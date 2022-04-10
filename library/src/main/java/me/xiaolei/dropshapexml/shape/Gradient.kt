package me.xiaolei.dropshapexml.shape

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

/**
 * 渐变
 */
class Gradient : ShapeSetter
{
    /**
     * 渐变角度
     */
    var angle: Angle? = null

    /**
     * 开始颜色
     */
    var startColor: Int? = null

    /**
     * 中间颜色
     */
    var centerColor: Int? = null

    /**
     * 结束颜色
     */
    var endColor: Int? = null

    /**
     * 中心X
     */
    var centerX: Float? = null

    /**
     * 中心Y
     */
    var centerY: Float? = null

    /**
     * 渐变圆角度
     */
    var gradientRadius: Float? = null

    /**
     * 渐变类型
     */
    var type: GradientType? = null

    /**
     * 设置此可绘制对象的level属性是否将用于缩放渐变。如果不使用渐变，则此属性无效
     */
    var useLevel: Boolean? = null
    
    override fun applyTo(drawable: GradientDrawable)
    {
        if (startColor != null || endColor != null)
        {
            drawable.colors = if (centerColor != null)
            {
                intArrayOf(
                    startColor ?: Color.TRANSPARENT,
                    centerColor ?: Color.TRANSPARENT,
                    endColor ?: Color.TRANSPARENT,
                )
            } else
            {
                intArrayOf(startColor ?: Color.TRANSPARENT, endColor ?: Color.TRANSPARENT)
            }
        }
        angle?.let {
            drawable.orientation = it.value
        }
        if (centerX != null || centerY != null)
        {
            drawable.setGradientCenter(centerX ?: 0.5f, centerY ?: 0.5f)
        }
        gradientRadius?.let {
            drawable.gradientRadius = it
        }
        type?.let {
            drawable.gradientType = it.value
        }
        useLevel?.let {
            drawable.useLevel = it
        }
    }
}