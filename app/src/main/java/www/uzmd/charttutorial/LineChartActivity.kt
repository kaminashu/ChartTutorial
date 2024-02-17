package www.uzmd.charttutorial

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import www.uzmd.charttutorial.databinding.ActivityLineChartBinding

class LineChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLineChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLineChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            lineChartView.animation.duration = animateduration
            lineChartView.animate(setLine)
            lineChartView.gradientFillColors =
                intArrayOf(Color.parseColor("#7F52FF"), Color.TRANSPARENT)
            lineChartView.onDataPointTouchListener = { index, _, _ ->
                tvChartData.text = setLine[index].second.toString()
            }

        }
    }

    companion object {
        private val setLine = listOf(
            "label 1" to 3F,
            "label 2" to 5F,
            "label 3" to 2F,
            "label 4" to 4F,
            "label 5" to 8F,
            "label 6" to 3F,
        )// ma`lumotlar turu float bolshi kereak
        private const val animateduration = 1000L //umumiy sigimi
        fun newInstance(context: Context): Intent {
            return Intent(context, LineChartActivity::class.java)
        }
    }
}