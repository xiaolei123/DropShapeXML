package me.xiaolei.dropshapexml.selector

import java.util.*

abstract class SelectorIeItem : LinkedList<Int>()
{
    /**
     * 状态值，表示 Drawable 处于硬件加速的视图中。这意味着该设备至少可以以 60fps 的速度渲染一个全屏缩放位图，
     * 其中包含一层文本和合成位图。
     * 设置后，即使 colorBackgroundCacheHint 指定了纯色，
     * 它也会被忽略，因为不需要优化。
     */
    var state_accelerated: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_accelerated
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 在视图或其父视图已“激活”时设置，这意味着用户当前已将其标记为感兴趣。
     * 这是 state_checked 的另一种表示形式，用于将状态向下传播到视图层次结构。
     */
    var state_activated: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_activated
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 在视图或可绘制对象被其宿主视为“活动”时设置。实际使用情况可能因视图而异。有关详细信息，请参阅主机视图文档。
     */
    var state_active: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_active
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 指示对象<var>可能<var>显示复选标记的状态标识符。请参阅 {@link android.R.attrstate_checked} 以获取指示它是否实际被检查的标识符。
     */
    var state_checkable: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_checkable
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 指示当前检查对象的状态标识符。请参阅 {@link android.R.attrstate_checkable}
     * 以获取可以指示任何对象是否可以显示检查的附加标识符，无论当前是否设置了 state_checked。
     */
    var state_checked: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_checked
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 指示 Drawable 位于能够接受拖放操作中当前正在操作的内容的放置的视图中。
     */
    var state_drag_can_accept: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_drag_can_accept
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 指示拖动操作（Drawable 的视图是有效接收者）当前位于 Drawable 上方。
     */
    var state_drag_hovered: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_drag_hovered
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 在启用视图时设置。
     */
    var state_enabled: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_enabled
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当视图或可绘制对象位于有序集中的第一个位置时设置。实际使用情况可能因视图而异。有关详细信息，请参阅主机视图文档。
     */
    var state_first: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_first
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当视图具有输入焦点时设置。
     */
    var state_focused: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_focused
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当指针悬停在视图上时设置。
     */
    var state_hovered: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_hovered
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当视图或可绘制对象位于有序集中的最后位置时设置。实际使用情况可能因视图而异。有关详细信息，请参阅主机视图文档。
     */
    var state_last: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_last
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当视图或可绘制对象位于有序集中的中间位置时设置。实际使用情况可能因视图而异。有关详细信息，请参阅主机视图文档。
     */
    var state_middle: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_middle
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当用户在视图中按下时设置。
     */
    var state_pressed: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_pressed
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当前选择视图（或其父视图之一）时设置。
     */
    var state_selected: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_selected
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当视图或可绘制对象被其宿主视为“单个”时设置。实际使用情况可能因视图而异。有关详细信息，请参阅主机视图文档。
     */
    var state_single: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_single
            if (!value)
                state = -state
            this.add(state)
        }

    /**
     * 当视图的窗口具有输入焦点时设置。
     */
    var state_window_focused: Boolean? = null
        set(value)
        {
            field = value
            value ?: return
            var state = android.R.attr.state_window_focused
            if (!value)
                state = -state
            this.add(state)
        }
}