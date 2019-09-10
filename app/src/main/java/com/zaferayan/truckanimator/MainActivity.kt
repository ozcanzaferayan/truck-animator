package com.zaferayan.truckanimator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val boxStart = -55f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val box = findViewById<View>(R.id.box)
        val truck = findViewById<View>(R.id.truck)
        val topDoor = findViewById<View>(R.id.topDoor)
        val bottomDoor = findViewById<View>(R.id.bottomDoor)
        val headlights = findViewById<View>(R.id.headlights)
        val road = findViewById<View>(R.id.road)
        val orderCompleted = findViewById<View>(R.id.orderCompleted)
        val completeOrder = findViewById<View>(R.id.completeOrder)
        val button = findViewById<View>(R.id.button)

        val completeOrderAnimatorEnlargeX = ObjectAnimator.ofFloat(button, "scaleX", 1f, 1.3f).apply {
            duration = 200
            startDelay = 0
        }
        val completeOrderAnimatorShrinkX = ObjectAnimator.ofFloat(button, "scaleX", 1.3f, 1f).apply {
            duration = 200
            startDelay = 200
        }

        val completeOrderAnimatorEnlargeY = ObjectAnimator.ofFloat(button, "scaleY", 1f, 1.3f).apply {
            duration = 200
            startDelay = 0
        }
        val completeOrderAnimatorShrinkY = ObjectAnimator.ofFloat(button, "scaleY", 1.3f, 1f).apply {
            duration = 200
            startDelay = 200
        }

        val completeOrderAnimatorFadeOut = ObjectAnimator.ofFloat(completeOrder, "alpha", 1f, 0f).apply {
            duration = 500
            startDelay = 400
        }
        val boxAnimator1 = ObjectAnimator.ofFloat(box, "translationX", boxStart, 30f).apply {
            duration = 1500
            startDelay = 500
        }

        val truckAnimator1 = ObjectAnimator.ofFloat(truck, "translationX", 0f, -390f).apply {
            duration = 1500
            startDelay = 500
        }

        val topDoorAnimator1 = ObjectAnimator.ofFloat(topDoor, "rotation", 0f, 135f).apply {
            duration = 1000
            startDelay = 1500
        }
        val bottomDoorAnimator1 = ObjectAnimator.ofFloat(bottomDoor, "rotation", 0f, -135f).apply {
            duration = 1000
            startDelay = 1750
        }

        val boxAnimator2 = ObjectAnimator.ofFloat(box, "translationX", 30f, 230f).apply {
            duration = 1500
            startDelay = 1800
        }
        val boxAnimator2Alpha = ObjectAnimator.ofFloat(box, "alpha", 1f, 0f).apply {
            duration = 100
            startDelay = 3000
        }
        val topDoorAnimator2 = ObjectAnimator.ofFloat(topDoor, "rotation", 135f, 0f).apply {
            duration = 1000
            startDelay = 3000
        }
        val bottomDoorAnimator2 = ObjectAnimator.ofFloat(bottomDoor, "rotation", -135f, 0f).apply {
            duration = 1000
            startDelay = 3250
        }
        val headlightsAnimator = ObjectAnimator.ofFloat(headlights, "alpha", 0f, 1f).apply {
            duration = 1000
            startDelay = 4250
        }
        val roadAnimatorVisible = ObjectAnimator.ofFloat(road, "alpha", 0f, 1f).apply {
            duration = 1
            startDelay = 4250
        }
        val roadAnimator = ObjectAnimator.ofFloat(road, "translationX", 0f, -2000f).apply {
            duration = 5000
            startDelay = 4250
        }



        val truckForward = ObjectAnimator.ofFloat(truck, "translationX", -390f, -290f).apply {
            duration = 1000
            startDelay = 4250
        }


        val truckBackward = ObjectAnimator.ofFloat(truck, "translationX", -290f, -550f).apply {
            duration = 2000
            startDelay = 5250
        }

        val truckFast = ObjectAnimator.ofFloat(truck, "translationX", -550f, -0f).apply {
            duration = 1500
            startDelay = 7250
        }

        val roadAnimatorAlpha = ObjectAnimator.ofFloat(road, "alpha", 1f, 0f).apply {
            duration = 1000
            startDelay = 7700
        }
        val orderCompletedAnimator = ObjectAnimator.ofFloat(orderCompleted, "alpha", 0f, 1f).apply {
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
            topDoorAnimator1, bottomDoorAnimator1, boxAnimator2, boxAnimator2Alpha, topDoorAnimator2, bottomDoorAnimator2, headlightsAnimator,
            roadAnimatorVisible,
            roadAnimator, roadAnimatorAlpha,
            truckForward, truckBackward, truckFast, orderCompletedAnimator)



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
