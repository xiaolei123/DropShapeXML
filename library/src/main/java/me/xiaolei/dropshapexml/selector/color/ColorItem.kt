package me.xiaolei.dropshapexml.selector.color

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import me.xiaolei.dropshapexml.selector.SelectorIeItem

class ColorItem : SelectorIeItem()
{
    /**
     * 不想解释了
     */
    @ColorInt
    var color: Int? = null

    @ColorRes
    var colorId: Int? = null
}