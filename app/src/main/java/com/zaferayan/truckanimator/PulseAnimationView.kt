package com.zaferayan.truckanimator

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.R.attr.radius
import android.graphics.Color
import android.view.MotionEvent
import android.animation.ObjectAnimator






class PulseAnimationView : View
{
    private var mRadius: Float = 0.toFloat()
    private val mPaint = Paint()
    private val COLOR_ADJUSTER = 5
    private var mX: Float = 0.toFloat()
    private var mY: Float = 0.toFloat()
    private val ANIMATION_DURATION = 4000
    private val ANIMATION_DELAY: Long = 1000


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet):    super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?,    defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setRadius(radius: Float) {
        mRadius = radius
        mPaint.color = Color.GREEN + radius.toInt() / COLOR_ADJUSTER

        invalidate()
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.actionMasked == MotionEvent.ACTION_DOWN) {
            mX = event.x
            mY = event.y
        }
        return super.onTouchEvent(event)
    }
}