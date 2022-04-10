package me.xiaolei.test

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import me.xiaolei.dropshapexml.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        // 普通背景
        val normal = shape {
            shape = RECTANGLE
            solid { color = Color.parseColor("#f00000") }
            corners { radius = 15f.dp }
        }
        // 按下去的背景
        val pressed = layerList {
            item {
                drawable = shape {
                    solid { color = Color.parseColor("#C15454") }
                    corners { radius = 15f.dp }
                }
            }
            item {
                top = 50.dp
                drawable = shape {
                    solid { color = Color.parseColor("#155473") }
                    corners {
                        leftBottomRadius = 15f.dp
                        rightBottomRadius = 15f.dp
                    }
                }
            }
        }
        // 设置背景selector
        textView.background = selector {
            item {
                drawable = normal
                state_pressed = false
            }
            item {
                drawable = pressed
                state_pressed = true
            }
        }
        // 设置文字颜色
        textView.setTextColor(colorSelector {
            item {
                state_pressed = true
                color = Color.WHITE
            }
            item {
                state_pressed = false
                color = Color.GREEN
            }
        })
    }
}

inline val Int.dp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()

inline val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
