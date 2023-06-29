package com.example.work_2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.work_2.databinding.ViewRouletteBinding

class RouletteView(
    context: Context,
    attr: AttributeSet,
) : ConstraintLayout(context, attr) {
    private val binding: ViewRouletteBinding

    init {
        binding = ViewRouletteBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        binding.viewRouletteImageButtonClear.setOnClickListener {
            clearPrizeField()
            it.isVisible = false
        }
    }

    fun setOnClickListenerButtonSpin(l: OnClickListener) {
        binding.viewRouletteButtonSpin.setOnClickListener(l)
    }

    fun clearPrizeField() {
        binding.viewRouletteTextViewResult.text = null
        binding.viewRouletteImageViewResult.setImageDrawable(null)
    }

    fun setTextToResult(text: String) {
        binding.viewRouletteTextViewResult.text = text
        binding.viewRouletteImageButtonClear.isVisible = true
    }

    fun setImageToResult(url: String) {
        Glide.with(this)
            .load(url)
            .into(binding.viewRouletteImageViewResult)
        binding.viewRouletteImageButtonClear.isVisible = true
    }

    fun rotateWheelToSection(section: Int, rotationTime: Long) {
        binding.viewRouletteWheelView.rotateWheelToSection(section, rotationTime)
    }

    fun buttonSpinIsEnabled(isEnabled: Boolean) {
        binding.viewRouletteButtonSpin.isEnabled = isEnabled
    }
}