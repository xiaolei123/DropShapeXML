package me.xiaolei.dropshapexml.layer_list

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

class LayerItem
{
    /**
     * 层的标识符。这可用于从可绘制容器中检索图层。
     */
    var id: Int? = null

    /**
     * 层的宽度。默认为图层的固有宽度。
     */
    var width: Int? = null

    /**
     * 层的高度。默认为图层的固有高度。
     */
    var height: Int? = null

    /**
     * 底部插图应用于图层。
     */
    var bottom: Int? = null

    /**
     * 用于渲染图层的可绘制对象。
     */
    var drawable: Drawable? = null

    @DrawableRes
    var drawableId: Int? = null

    /**
     * 结束插图应用于图层。根据布局方向覆盖 {@code left} 或 {@code right}。
     */
    var end: Int? = null

    /**
     * 重力用于在其容器内对齐图层。如果未指定值，则默认行为取决于是否设置了显式宽度或高度。
     * 如果未设置尺寸，则该方向的重力默认为 {@code fill_horizontal}
     * 或 {@code fill_vertical}；
     *
     * 否则，它默认为 {@code left} 或 {@code top}。
     */
    var gravity: Int? = null

    /**
     * 左插图应用于图层。
     */
    var left: Int? = null

    /**
     * 右插图应用于图层。
     */
    var right: Int? = null

    /**
     * 开始插入以应用于图层。根据布局方向覆盖 {@code left} 或 {@code right}。
     */
    var start: Int? = null

    /**
     * 应用于图层的顶部插图。
     */
    var top: Int? = null
}