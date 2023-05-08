package xyz.lurkyphish2085.sliderseekbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.slider.Slider
import com.google.android.material.slider.Slider.OnChangeListener
import xyz.lurkyphish2085.sliderseekbardemo.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continuosSlider.addOnChangeListener(object: Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                binding.continuosSliderValue.text = String.format("%.2f", value)
            }
        })

        binding.discreteSlider.addOnChangeListener(object : Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                binding.discreteSliderValue.text = value.toString()
            }
        })

        binding.continuosSliderMonetary.setLabelFormatter { value ->
            return@setLabelFormatter "$${value.roundToInt()}"
        }

        binding.continuosSliderMonetary.addOnChangeListener(object: Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                binding.continuosSliderMonetaryValue.text = "$${value.roundToInt()}"
            }
        })
    }
}