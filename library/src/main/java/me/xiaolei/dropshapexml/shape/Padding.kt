package me.xiaolei.dropshapexml.shape

import android.graphics.drawable.GradientDrawable
import android.os.Build

/**
 * 边距
 */
class Padding : ShapeSetter
{
    var left: Int? = null
    var top: Int? = null
    var right: Int? = null
    var bottom: Int? = null

    override fun applyTo(drawable: GradientDrawable)
    {
        if (left != null || top != null || right != null || bottom != null)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            {
                drawable.setPadding(left ?: 0, top ?: 0, right ?: 0, bottom ?: 0)
            }
        }
    }
}