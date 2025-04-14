package com.example.advancecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import com.example.advancecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            ListCustom(R.drawable.tex,"Tax Calculator","description"),
            ListCustom(R.drawable.interest,"Interest Calculator","description"),
            ListCustom(R.drawable.bmi,"BMI Calculator","description"),
            ListCustom(R.drawable.units,"Unit Converter","description"),
            ListCustom(R.drawable.currency1,"Currency Converter","description"),
        )

        val activityMap =mapOf(
            "Tax Calculator" to TaxCalculator::class.java,
            "Interest Calculator" to InterestCalculator::class.java,
            "BMI Calculator" to BMICalculator::class.java,
            "Unit Converter" to UnitConverter::class.java,
            "Currency Converter" to CurrencyConverter::class.java
        )
        binding.listView.adapter = ListCustomAdapter(this,items)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as ListCustom
            // Handle item click here
            val targetedActivity = activityMap[selectedItem.title]
            if(targetedActivity != null){
                val intent = Intent(this,targetedActivity)
                startActivity(intent)
                Toast.makeText(this, " ${selectedItem.title} ", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No activity found for ${selectedItem.title}", Toast.LENGTH_SHORT).show()
            }


        }



    }
}