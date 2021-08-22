package hart.syrinx.priceaverager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hart.syrinx.priceaverager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    var entrys: Int = 0
    var value: Int = 0
    var totalCapital: Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcButton.setOnClickListener { calculate() }
        binding.addRow.setOnClickListener { addTransaction() }
    }

    fun calculate()
    {
        val priceAverage: Int = value / (entrys * (totalCapital / entrys))
        binding.priceAverageText.text = priceAverage.toString()

    }

    fun addTransaction()
    {
        entrys++

        value += binding.assetValue0.text.toString().toInt() * binding.capitalValue0.text.toString().toInt()
        totalCapital += binding.capitalValue0.text.toString().toInt()

        binding.assetsHistorical.text = binding.assetsHistorical.text.toString()+ "\n" + binding.assetValue0.text.toString()
        binding.capitalHistorical.text = binding.capitalHistorical.text.toString()+ "\n" + binding.capitalValue0.text.toString()

        binding.assetValue0.text = null
        binding.capitalValue0.text = null
    }
}