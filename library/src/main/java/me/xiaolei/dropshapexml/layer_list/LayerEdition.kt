package me.xiaolei.dropshapexml.layer_list

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.os.Build
import androidx.core.content.ContextCompat
import java.util.*

class LayerEdition(private val context: Context)
{
    /**
     * 指示可绘制对象在其布局方向为 RTL（从右到左）时是否需要镜像。
     */
    var autoMirrored: Boolean? = null

    /**
     * 指示图层的不透明度。这对于允许系统启用绘图优化很有用。默认值为半透明。
     */
    var opacity: Opacity? = null

    /**
     * 左边距
     */
    var paddingStart: Int? = null

    /**
     * 左边距
     */
    var paddingLeft: Int? = null

    /**
     * 顶边距
     */
    var paddingTop: Int? = null

    /**
     * 右边距
     */
    var paddingEnd: Int? = null

    /**
     * 右边距
     */
    var paddingRight: Int? = null

    /**
     * 底边距
     */
    var paddingBottom: Int? = null

    /**
     * 指示层填充应如何影响后续层的边界。默认填充模式值为嵌套。
     */
    var paddingMode: PaddingMode? = null


    private val items = LinkedList<LayerItem>()

    fun item(block: LayerItem.() -> Unit)
    {
        items.add(LayerItem().apply(block))
    }

    fun drawable(): LayerDrawable
    {
        val realItems = items.dropWhile { it.drawable == null && it.drawableId == null }
        val itemDrawables = realItems.mapNotNull {
            it.drawable ?: it.drawableId?.let { id ->
                ContextCompat.getDrawable(context, id)
            }
        }
        val drawable = LayerDrawable(itemDrawables.toTypedArray())

        realItems.forEachIndexed { index, layerItem ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                layerItem.width?.let { drawable.setLayerWidth(index, it) }
                layerItem.height?.let { drawable.setLayerHeight(index, it) }
                layerItem.gravity?.let { drawable.setLayerGravity(index, it) }
            }
            drawable.setLayerInset(
                index,
                layerItem.left ?: layerItem.start ?: 0,
                layerItem.top ?: 0,
                layerItem.right ?: layerItem.end ?: 0,
                layerItem.bottom ?: 0
            )
            layerItem.id?.let { drawable.setId(index, it) }
        }

        autoMirrored?.let { drawable.isAutoMirrored = it }

        opacity?.let { drawable.opacity = it.value }

        if (paddingStart != null || paddingLeft != null ||
            paddingTop != null ||
            paddingEnd != null || paddingRight != null ||
            paddingBottom != null
        )
        {
            val left = paddingLeft ?: paddingStart ?: 0
            val top = paddingTop ?: 0
            val right = paddingEnd ?: paddingRight ?: 0
            val bottom = paddingBottom ?: 0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                drawable.setPadding(left, top, right, bottom)
            }
        }

        paddingMode?.let {
            drawable.paddingMode = it.value
        }
        return drawable
    }

}