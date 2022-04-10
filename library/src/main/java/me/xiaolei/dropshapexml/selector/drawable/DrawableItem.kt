package me.xiaolei.dropshapexml.selector.drawable

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import me.xiaolei.dropshapexml.selector.SelectorIeItem

class DrawableItem : SelectorIeItem()
{
    /**
     * 不想解释了
     */
    @DrawableRes
    var drawableId: Int? = null
    var drawable: Drawable? = null
}