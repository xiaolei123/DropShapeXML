package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

/**
 * 渐变类型
 */
enum class GradientType(val value: Int)
{
    /**
     * 渐变是线性的
     */
    LINEAR_GRADIENT(GradientDrawable.LINEAR_GRADIENT),

    /**
     * 渐变是圆形的
     */
    RADIAL_GRADIENT(GradientDrawable.RADIAL_GRADIENT),

    /**
     * 渐变是一种扫描
     */
    SWEEP_GRADIENT(GradientDrawable.SWEEP_GRADIENT)
}