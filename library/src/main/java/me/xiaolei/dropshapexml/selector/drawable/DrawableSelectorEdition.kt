package me.xiaolei.dropshapexml.selector.drawable

import android.content.Context
import android.graphics.drawable.StateListDrawable
import androidx.core.content.ContextCompat
import java.util.*

class DrawableSelectorEdition(private val context: Context) :LinkedList<DrawableItem>(), DrawableSelectorSetter
{
    fun item(block: DrawableItem.() -> Unit) = this.add(DrawableItem().apply(block))
    
    override fun applyTo(drawable: StateListDrawable)
    {
        for (item in this)
        {
            val draw = item.drawable ?: item.drawableId?.let {
                ContextCompat.getDrawable(context, it)
            } ?: continue
            if (item.isEmpty()) continue
            drawable.addState(item.toIntArray(), draw)
        }
    }
}