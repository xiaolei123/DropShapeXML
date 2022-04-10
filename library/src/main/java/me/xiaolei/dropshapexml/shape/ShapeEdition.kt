package me.xiaolei.dropshapexml.shape

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.os.Build
import me.xiaolei.dropshapexml.RECTANGLE

/**
 * 设置属性的入口
 */
class ShapeEdition(private val context: Context) : ShapeSetter
{
    /**
     * 图像类型
     */
    var shape: Shape = RECTANGLE

    /**
     * 抖动
     */
    var dither: Boolean? = null

    /**
     * 配置环的内半径
     */
    var innerRadius: Int? = null

    /**
     * 环的内半径表示为环宽度的比率
     */
    var innerRadiusRatio: Float? = null

    /**
     * 配置环的厚度
     */
    var thickness: Int? = null

    /**
     * 配置环的厚度，表示为环宽度的比率。
     */
    var thicknessRatio: Float? = null

    /**
     * 指定此可绘制对象的色调颜色。Drawable 的绘图内容在绘制到屏幕之前将与其色调混合在一起。
     * 这个功能类似于setColorFilter(int, PorterDuff.Mode) 。
     */
    var tint: Int? = null

    /**
     * 为此可绘制对象指定色调混合模式。
     * 定义在绘制到屏幕之前应如何将此可绘制对象的淡色混合到可绘制对象中。
     * 默认色调模式是PorterDuff.Mode.SRC_IN
     */
    var tintMode: PorterDuff.Mode? = null

    /**
     * 设置此可绘制对象的level属性是否将用于缩放渐变。如果不使用渐变，则此属性无效。
     * 缩放行为因梯度类型而异
     */
    var useLevel: Boolean? = null

    /**
     * 设置此 Drawable 是否可见。这通常不会影响 Drawable 的行为，
     * 但可以作为一些 Drawable 使用的提示，例如，决定是否运行动画。
     */
    var visible: Boolean? = null

    private var solid: Solid? = null

    private var corners: Corners? = null

    private var gradient: Gradient? = null

    private var padding: Padding? = null

    private var size: Size? = null

    private var stroke: Stroke? = null

    /**
     * 设置背景色
     */
    fun solid(block: Solid.() -> Unit)
    {
        if (solid == null)
            solid = Solid(context)
        solid?.block()
    }

    /**
     * 设置圆角
     */
    fun corners(block: Corners.() -> Unit)
    {
        if (corners == null)
            corners = Corners()
        corners?.block()
    }

    /**
     * 设置渐变
     */
    fun gradient(block: Gradient.() -> Unit)
    {
        if (gradient == null)
            gradient = Gradient()
        gradient?.block()
    }

    /**
     * 设置边距
     */
    fun padding(block: Padding.() -> Unit)
    {
        if (padding == null)
            padding = Padding()
        padding?.block()
    }

    /**
     * 设置size
     */
    fun size(block: Size.() -> Unit)
    {
        if (size == null)
            size = Size()
        size?.block()
    }

    /**
     * 设置边框
     */
    fun stroke(block: Stroke.() -> Unit)
    {
        if (stroke == null)
            stroke = Stroke()
        stroke?.block()
    }

    override fun applyTo(drawable: GradientDrawable)
    {
        drawable.shape = shape.value

        dither?.let { drawable.setDither(it) }

        innerRadius?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            {
                drawable.innerRadius = it
            }
        }
        innerRadiusRatio?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            {
                drawable.innerRadiusRatio = it
            }
        }
        thickness?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            {
                drawable.thickness = it
            }
        }
        thicknessRatio?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            {
                drawable.thicknessRatio = it
            }
        }

        tint?.let { drawable.setTint(it) }

        tintMode?.let { drawable.setTintMode(it) }

        useLevel?.let { drawable.useLevel = it }

        visible?.let { drawable.setVisible(it, true) }

        solid?.applyTo(drawable)
        corners?.applyTo(drawable)
        gradient?.applyTo(drawable)
        padding?.applyTo(drawable)
        size?.applyTo(drawable)
        stroke?.applyTo(drawable)
    }
}
