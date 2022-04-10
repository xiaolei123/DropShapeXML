package me.xiaolei.dropshapexml.layer_list

import android.graphics.drawable.LayerDrawable

enum class PaddingMode(val value: Int)
{
    NEST(LayerDrawable.PADDING_MODE_NEST),
    STACK(LayerDrawable.PADDING_MODE_STACK)
}