package com.example.work_2

import android.animation.Animator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import java.lang.Float.min


class WheelView(
    context: Context,
    attr: AttributeSet,
) : View(context, attr) {
    private val oval = RectF()
    private val paint = Paint()
    private var sectionsNumber = 7

    override fun onDraw(canvas: Canvas?) {
        paint.style = Paint.Style.FILL

        val diameter = min(height.toFloat(), width.toFloat())

        val centerX = width / 2
        val centerY = height / 2
        val left = centerX - diameter / 2
        val top = centerY - diameter / 2
        val right = centerX + diameter / 2
        val bottom = centerY + diameter / 2
        oval.set(left, top, right, bottom)

        val oneAngle = 360f / sectionsNumber
        paint.color = Color.BLACK
        canvas?.drawArc(oval, 0f, oneAngle, true, paint)
        paint.color = Color.BLUE
        canvas?.drawArc(oval, oneAngle * 1, oneAngle, true, paint)
        paint.color = Color.RED
        canvas?.drawArc(oval, oneAngle * 2, oneAngle, true, paint)
        paint.color = Color.GREEN
        canvas?.drawArc(oval, oneAngle * 3, oneAngle, true, paint)
        paint.color = Color.CYAN
        canvas?.drawArc(oval, oneAngle * 4, oneAngle, true, paint)
        paint.color = Color.MAGENTA
        canvas?.drawArc(oval, oneAngle * 5, oneAngle, true, paint)
        paint.color = Color.GRAY
        canvas?.drawArc(oval, oneAngle * 6, oneAngle, true, paint)
    }

    fun rotateWheelToSection(section: Int, rotationTime: Long) {
        val angleOfIndexSection = 360f / sectionsNumber * section
        val wheelItemCenter = 270 - angleOfIndexSection + 360 / sectionsNumber / 2

        animate().setDuration(0).rotation(0f).start()

        animate().setInterpolator(DecelerateInterpolator())
            .setDuration(rotationTime)
            .rotation(360 * 15 + wheelItemCenter)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    clearAnimation()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
            .start()
    }
}