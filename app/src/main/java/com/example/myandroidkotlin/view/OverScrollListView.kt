package com.example.myandroidkotlin.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.ListView
import com.example.myandroidkotlin.R

/**
 * Created by zn on 2016/12/25.
 * 具有弹性的listview
 */
class OverScrollListView : ListView {
    private var mMaxOverDistance = 25 //弹性超过距离
    private var mContext: Context? = null

    constructor(context: Context?) : super(context, null) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        initView(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        mContext = context
        initView(attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        mContext = context
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val metrics = mContext!!.resources.displayMetrics
        val density = metrics.density //基准屏幕比率
        //获取数据
        val typeArray = mContext!!.obtainStyledAttributes(attrs, R.styleable.overscoll_listview)
        mMaxOverDistance = typeArray.getInt(R.styleable.overscoll_listview_distance, 25)
        mMaxOverDistance = (density * mMaxOverDistance).toInt()
    }

    /**
     * 实现弹性滑动的效果
     * @param deltaX
     * @param deltaY
     * @param scrollX
     * @param scrollY
     * @param scrollRangeX
     * @param scrollRangeY
     * @param maxOverScrollX
     * @param maxOverScrollY
     * @param isTouchEvent
     * @return
     */
    override fun overScrollBy(
        deltaX: Int,
        deltaY: Int,
        scrollX: Int,
        scrollY: Int,
        scrollRangeX: Int,
        scrollRangeY: Int,
        maxOverScrollX: Int,
        maxOverScrollY: Int,
        isTouchEvent: Boolean
    ): Boolean {
        return super.overScrollBy(
            deltaX,
            deltaY,
            scrollX,
            scrollY,
            scrollRangeX,
            scrollRangeY,
            maxOverScrollX,
            mMaxOverDistance,
            isTouchEvent
        )
    }
}