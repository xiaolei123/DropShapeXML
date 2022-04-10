package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable

// 渐变方向
enum class Angle(val value: GradientDrawable.Orientation)
{
    /** 从上到下绘制渐变 */
    TOP_BOTTOM(GradientDrawable.Orientation.TOP_BOTTOM),

    /** 绘制从右上角到左下角的渐变 */
    TR_BL(GradientDrawable.Orientation.TR_BL),

    /** 从右到左绘制渐变 */
    RIGHT_LEFT(GradientDrawable.Orientation.RIGHT_LEFT),

    /** 绘制从右下角到左上角的渐变 */
    BR_TL(GradientDrawable.Orientation.BR_TL),

    /** 从底部到顶部绘制渐变 */
    BOTTOM_TOP(GradientDrawable.Orientation.BOTTOM_TOP),

    /** 从左下角到右上角绘制渐变 */
    BL_TR(GradientDrawable.Orientation.BL_TR),

    /** 从左到右绘制渐变 */
    LEFT_RIGHT(GradientDrawable.Orientation.LEFT_RIGHT),

    /** 从左上角到右下角绘制渐变 */
    TL_BR(GradientDrawable.Orientation.TL_BR),
}