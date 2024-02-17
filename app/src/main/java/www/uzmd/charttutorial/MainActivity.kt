package www.uzmd.charttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.uzmd.charttutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickButtons()
    }

    private fun onClickButtons() {
        binding.apply {
            barChart.setOnClickListener {
                startActivity(BarChartActivity.newInstance(this@MainActivity))
            }
            doonutChart.setOnClickListener {
                startActivity(DountChartActivity.newInstance(this@MainActivity))
            }
            lineChart.setOnClickListener {
                startActivity(LineChartActivity.newInstance(this@MainActivity))
            }
        }
    }

}