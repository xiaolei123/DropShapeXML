package me.xiaolei.dropshapexml

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.StateListDrawable
import me.xiaolei.dropshapexml.bitmap.BitmapEdition
import me.xiaolei.dropshapexml.layer_list.LayerEdition
import me.xiaolei.dropshapexml.selector.color.ColorSelectorEdition
import me.xiaolei.dropshapexml.selector.drawable.DrawableSelectorEdition
import me.xiaolei.dropshapexml.shape.Angle
import me.xiaolei.dropshapexml.shape.GradientType
import me.xiaolei.dropshapexml.shape.Shape
import me.xiaolei.dropshapexml.shape.ShapeEdition

/**
 * 用来代替Shape.xml
 */
fun Context.shape(block: ShapeEdition.() -> Unit): GradientDrawable
{
    val drawable = GradientDrawable()
    val edition = ShapeEdition(this)
    edition.block()
    edition.applyTo(drawable)
    return drawable
}

/**
 * 用来代替Selector.xml
 */
fun Context.selector(block: DrawableSelectorEdition.() -> Unit): StateListDrawable
{
    val drawable = StateListDrawable()
    val edition = DrawableSelectorEdition(this)
    edition.block()
    edition.applyTo(drawable)
    return drawable
}

/**
 * 用来代替颜色的Selector.xml
 */
fun Context.colorSelector(block: ColorSelectorEdition.() -> Unit): ColorStateList
{
    val edition = ColorSelectorEdition(this)
    edition.block()
    return ColorStateList(edition.stateArray(), edition.colorArray())
}

/**
 * 用来代替layer_list.xml的
 */
fun Context.layerList(block: LayerEdition.() -> Unit): LayerDrawable
{
    return LayerEdition(this).apply(block).drawable()
}

/**
 * 用来代替bitmap.xml的
 */
fun Context.bitmap(block: BitmapEdition.() -> Unit): BitmapDrawable
{
    val edition = BitmapEdition().apply(block)
    val resource = this.resources
    val bitmap = edition.src?.let {
        BitmapFactory.decodeResource(resource, it)
    } ?: Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
    val drawable = BitmapDrawable(resource, bitmap)
    edition.antialias?.let { drawable.setAntiAlias(it) }
    edition.dither?.let { drawable.setDither(it) }
    edition.filter?.let { drawable.isFilterBitmap = it }
    edition.tiltMode?.let { drawable.setTileModeXY(it, it) }
    edition.gravity?.let { drawable.gravity = it }
    edition.tint?.let { drawable.setTint(it) }
    edition.tintMode?.let { drawable.setTintMode(it) }
    edition.mipMap?.let { drawable.setMipMap(it) }
    return drawable
}


// 图像类型
val OVAL = Shape.OVAL
val RECTANGLE = Shape.RECTANGLE
val LINE = Shape.LINE
val RING = Shape.RING

// 渐变类型
val LINEAR_GRADIENT = GradientType.LINEAR_GRADIENT
val RADIAL_GRADIENT = GradientType.RADIAL_GRADIENT
val SWEEP_GRADIENT = GradientType.SWEEP_GRADIENT

// 渐变方向
val TOP_BOTTOM = Angle.TOP_BOTTOM
val TR_BL = Angle.TR_BL
val RIGHT_LEFT = Angle.RIGHT_LEFT
val BR_TL = Angle.BR_TL
val BOTTOM_TOP = Angle.BOTTOM_TOP
val BL_TR = Angle.BL_TR
val LEFT_RIGHT = Angle.LEFT_RIGHT
val TL_BR = Angle.TL_BR