package com.example.work_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.work_2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private val prizeRepository = PrizeRepository()
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.rouletteView.setOnClickListenerButtonSpin {
            rotateWheel()
        }
    }

    private fun rotateWheel() {
        with(binding.rouletteView) {
            buttonSpinIsEnabled(false)
            clearPrizeField()

            val section = Random.nextInt(1, 8)
            val rotationTime = Random.nextLong(3000, 6001)
            rotateWheelToSection(section, rotationTime)

            scope.launch {
                delay(rotationTime)
                runOnUiThread {
                    showPrize(section)
                    buttonSpinIsEnabled(true)
                }
            }
        }
    }

    private fun showPrize(section: Int) {
        val prize = prizeRepository.getPrize(section)
        when (prize.type) {
            Prize.PrizeType.TEXT -> {
                binding.rouletteView.setTextToResult(prize.value)
            }

            Prize.PrizeType.IMAGE -> {
                binding.rouletteView.setImageToResult(prize.value)
            }
        }
    }
}