package www.uzmd.charttutorial

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.uzmd.charttutorial.databinding.ActivityBarChartBinding
import www.uzmd.charttutorial.databinding.ActivityDountChartBinding

class DountChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDountChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDountChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            chartViewId.animation.duration = ANIMATE_DURATION
            chartViewId.animate(setDuration)
            chartViewId.donutColors= intArrayOf(Color.parseColor("#B125EA"),Color.parseColor("#E24462"),Color.parseColor("#7F52FF"))
        }
    }

    companion object {
        private const val ANIMATE_DURATION = 1000L
        private val setDuration= listOf(
            100F,
            50F,
            645F
        )
        fun newInstance(context: Context): Intent {
            return Intent(context, DountChartActivity::class.java)
        }
    }
}