package me.xiaolei.dropshapexml.selector.drawable

import android.graphics.drawable.StateListDrawable

interface DrawableSelectorSetter
{
    fun applyTo(drawable: StateListDrawable)
}