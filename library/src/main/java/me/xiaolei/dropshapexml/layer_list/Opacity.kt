package me.xiaolei.dropshapexml.layer_list

import android.graphics.PixelFormat

enum class Opacity(val value: Int)
{
    // 不透明
    OPAQUE(PixelFormat.OPAQUE),

    // 透明
    TRANSPARENT(PixelFormat.TRANSPARENT),

    // 半透明
    TRANSLUCENT(PixelFormat.TRANSLUCENT)
}