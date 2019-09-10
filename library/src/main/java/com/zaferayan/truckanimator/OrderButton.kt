package com.zaferayan.truckanimator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator.ofFloat
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout


class OrderButton : ConstraintLayout {

    private var boxStart = 0f
    private var boxMove1 = 0f
    private var boxMove2 = 0f
    private var truckStart = 0f
    private var truckMoveBackwardBoxLoading = 0f
    private var truckMoveForward = 0f
    private var truckMoveBackward = 0f
    private var truckMoveExit = 0f
    private var roadMove = 0f

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.control_truck_animator, this)

        val box = findViewById<View>(R.id.box)
        val truck = findViewById<View>(R.id.truck)
        val topDoor = findViewById<View>(R.id.topDoor)
        val bottomDoor = findViewById<View>(R.id.bottomDoor)
        val headlights = findViewById<View>(R.id.headlights)
        val road = findViewById<View>(R.id.road)
        val orderCompleted = findViewById<View>(R.id.orderCompleted)
        val completeOrder = findViewById<View>(R.id.completeOrder)
        val button = findViewById<View>(R.id.button)

        button.clipToOutline = true

        val displayMetrics = resources.displayMetrics
        val widthPixels = displayMetrics.widthPixels
        val heightPixels = displayMetrics.heightPixels
        val selectedSize = if (widthPixels < heightPixels) widthPixels else heightPixels
        boxStart = -(selectedSize / 7.2f)
        boxMove2 = selectedSize / 3.13f
        truckMoveBackwardBoxLoading = -(selectedSize / 1.44f)
        truckMoveForward = -(selectedSize / 2.25f)
        truckMoveBackward = -(selectedSize / 1.02f)
        roadMove = -(selectedSize / 0.36f)

        val completeOrderAnimatorEnlargeX = ofFloat(button, "scaleX", 1f, 1.3f).apply {
            duration = 200
            startDelay = 0
        }
        val completeOrderAnimatorShrinkX = ofFloat(button, "scaleX", 1.3f, 1f).apply {
            duration = 200
            startDelay = 200
        }

        val completeOrderAnimatorEnlargeY = ofFloat(button, "scaleY", 1f, 1.3f).apply {
            duration = 200
            startDelay = 0
        }
        val completeOrderAnimatorShrinkY = ofFloat(button, "scaleY", 1.3f, 1f).apply {
            duration = 200
            startDelay = 200
        }

        val completeOrderAnimatorFadeOut = ofFloat(completeOrder, "alpha", 1f, 0f).apply {
            duration = 500
            startDelay = 400
        }
        val boxAnimator1 = ofFloat(box, "translationX", boxStart, boxMove1).apply {
            duration = 1250
            startDelay = 500
        }

        val truckAnimator1 =
            ofFloat(truck, "translationX", truckStart, truckMoveBackwardBoxLoading).apply {
                duration = 1500
                startDelay = 500
            }

        val topDoorAnimator1 = ofFloat(topDoor, "rotation", 0f, 135f).apply {
            duration = 1000
            startDelay = 1500
        }
        val bottomDoorAnimator1 = ofFloat(bottomDoor, "rotation", 0f, -135f).apply {
            duration = 1000
            startDelay = 1750
        }


        val boxAnimator2 = ofFloat(box, "translationX", boxMove1, boxMove2).apply {
            duration = 1500
            startDelay = 1800
        }
        val boxAnimator2Alpha = ofFloat(box, "alpha", 1f, 0f).apply {
            duration = 100
            startDelay = 3000
        }
        val topDoorAnimator2 = ofFloat(topDoor, "rotation", 135f, 0f).apply {
            duration = 1000
            startDelay = 3000
        }
        val bottomDoorAnimator2 = ofFloat(bottomDoor, "rotation", -135f, 0f).apply {
            duration = 1000
            startDelay = 3250
        }
        val headlightsAnimator = ofFloat(headlights, "alpha", 0f, 1f).apply {
            duration = 1000
            startDelay = 4250
        }
        val roadAnimatorVisible = ofFloat(road, "alpha", 0f, 1f).apply {
            duration = 1
            startDelay = 4000
        }
        val roadAnimator = ofFloat(road, "translationX", 0f, roadMove).apply {
            duration = 5000
            startDelay = 4000
        }
        val truckForward =
            ofFloat(truck, "translationX", truckMoveBackwardBoxLoading, truckMoveForward).apply {
                duration = 1000
                startDelay = 4250
            }
        val truckBackward =
            ofFloat(truck, "translationX", truckMoveForward, truckMoveBackward).apply {
                duration = 2000
                startDelay = 5250
            }

        val truckFast = ofFloat(truck, "translationX", truckMoveBackward, truckMoveExit).apply {
            duration = 1500
            startDelay = 7250
        }

        val roadAnimatorAlpha = ofFloat(road, "alpha", 1f, 0f).apply {
            duration = 1000
            startDelay = 7700
        }
        val orderCompletedAnimator = ofFloat(orderCompleted, "alpha", 0f, 1f).apply {
            duration = 1000
            startDelay = 8500
        }
        val animatorSet1 = AnimatorSet()


        animatorSet1.playTogether(
            completeOrderAnimatorEnlargeX,
            completeOrderAnimatorEnlargeY,
            completeOrderAnimatorShrinkX,
            completeOrderAnimatorShrinkY,
            completeOrderAnimatorFadeOut,
            boxAnimator1,
            truckAnimator1,
            topDoorAnimator1,
            bottomDoorAnimator1,
            boxAnimator2,
            boxAnimator2Alpha,
            topDoorAnimator2,
            bottomDoorAnimator2,
            headlightsAnimator,
            roadAnimatorVisible,
            roadAnimator,
            roadAnimatorAlpha,
            truckForward,
            truckBackward,
            truckFast,
            orderCompletedAnimator
        )
        button.setOnClickListener {
            initializeView(box, completeOrder, orderCompleted, headlights)
            animatorSet1.start()
        }
    }
    private fun initializeView(
        box: View,
        completeOrder: View,
        orderCompleted: View,
        headlights: View
    ) {
        box.translationX = boxStart
        box.alpha = 1f
        completeOrder.alpha = 1f
        orderCompleted.alpha = 0f
        headlights.alpha = 0f


    }

}
