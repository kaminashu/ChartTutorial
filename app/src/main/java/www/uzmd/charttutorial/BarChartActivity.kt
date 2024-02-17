package www.uzmd.charttutorial

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import www.uzmd.charttutorial.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBarChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            verticalChartView.animation.duration = animateDuration //umumiy sigim berib yuborildi
            verticalChartView.animate(barSetVertical.map {
                Pair(
                    it.first.substring(0, 3),
                    it.second
                )
            }) //list ga ishlov berdim first listdagi elementlni birinchi qismi, second 2- qismi
            verticalChartView.barRadius =
                30F //vertikalga ham horizantalgaham shunday radius bersa boladi
            verticalChartView.onDataPointTouchListener={index, _, _ ->
                Toast.makeText(this@BarChartActivity, "${barSetVertical[index].first}", Toast.LENGTH_SHORT).show()

            }


            horizantalChart.animation.duration = animateDuration
            horizantalChart.barsColor = Color.parseColor("#7F52FF")
            horizantalChart.barRadius = 30F
            horizantalChart.animate(setHorizantal)
        }
    }

    companion object {
        private val barSetVertical = listOf(
            "Ortiqboy" to 5F,
            "Zuhra" to 1.1F,
            "Anaxon" to 2F,
            "Navrozbek" to 3F,
            "Multifilm" to 4F,
            "Multifilm" to 4F,
            "Multifilm" to 4F,
            "Multifilm" to 4F,
        )
        private val setHorizantal = listOf(
            "Ortiqboy" to 7F,
            "Zuhra" to 2F,
            "Anaxon" to 1F,
            "Navrozbek" to 9F,
            "Multifilm" to 0.1F
        )
        private const val animateDuration = 1000L

        fun newInstance(context: Context): Intent {
            return Intent(context, BarChartActivity::class.java)
        }
    }
}