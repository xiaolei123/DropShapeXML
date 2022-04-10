package me.xiaolei.dropshapexml.bitmap

import android.graphics.PorterDuff
import android.graphics.Shader
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes

class BitmapEdition
{
    /**
     * 图片资源
     */
    @DrawableRes
    var src: Int? = null

    /**
     * 抗锯齿
     */
    var antialias: Boolean? = null

    /**
     * 开启或关闭图像抖动。当使用图片的dpi和屏幕不匹配时，开启图像抖动可以获得更好的显示效果
     */
    var dither: Boolean? = null

    /**
     * 开启或关闭滤镜。当需要对图片进行缩放操作时，开启滤镜可以使图片更加平滑
     */
    var filter: Boolean? = null

    /**
     * 贴图模式。详细见下文。该属性与gravity是互斥的。
     */
    var tiltMode: Shader.TileMode? = null

    /**
     * 重心。详细见下文。该属性与tileMode是互斥的。
     */
    var gravity: Int? = null

    /**
     * 设置着色。有种盖一个色层在图片上的感觉。
     */
    @ColorInt
    var tint: Int? = null

    /**
     * 设置着色模式。详细见下文。
     */
    var tintMode: PorterDuff.Mode? = null

    /**
     * 是否将图片标记为mipmap，使用mipmap能够提高显示性能，默认为false
     */
    var mipMap: Boolean? = null
}