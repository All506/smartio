package com.example.smartio.ui.questions.adapter

import android.graphics.Canvas
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class HorizontalMarginItemDecoration(private val margin: Int, private val alpha: Int) :
    RecyclerView.ItemDecoration() {

    private val paint = Paint()

    init {
        paint.alpha = alpha
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val itemCount = parent.adapter?.itemCount ?: 0
        val centerX = parent.width / 2f

        for (i in 0 until itemCount) {
            val child = parent.getChildAt(i) ?: continue

            val childCenterX = (child.left + child.right) / 2f

            val distanceFromCenter = Math.abs(centerX - childCenterX)
            val scale = 1f - (distanceFromCenter / centerX)
            child.scaleX = scale
            child.scaleY = scale

            val alpha = (scale * alpha).toInt()
            paint.alpha = alpha

            c.drawRect(
                child.left.toFloat(),
                child.top.toFloat(),
                child.right.toFloat(),
                child.bottom.toFloat(),
                paint
            )
        }
    }
}
