package me.xiaolei.dropshapexml.selector.color

import android.content.Context
import androidx.core.content.ContextCompat
import java.util.*

class ColorSelectorEdition(private val context: Context) : LinkedList<ColorItem>()
{
    fun item(block: ColorItem.() -> Unit) = this.add(ColorItem().apply(block))

    fun stateArray(): Array<IntArray>
    {
        val items = this.filterNot { (it.color == null && it.colorId == null) || it.isEmpty() }
        return items.map { it.toIntArray() }.toTypedArray()
    }
    
    fun colorArray(): IntArray
    {
        val items = this.filterNot { (it.color == null && it.colorId == null) || it.isEmpty() }
        return items.mapNotNull { item ->
            item.color ?: item.colorId?.let {
                ContextCompat.getColor(context, it)
            }
        }.toIntArray()
    }
}