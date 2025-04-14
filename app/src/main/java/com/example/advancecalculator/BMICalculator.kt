package com.example.advancecalculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.advancecalculator.databinding.ActivityBmicalculatorBinding

class BMICalculator : AppCompatActivity() {
    lateinit var binding: ActivityBmicalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding =ActivityBmicalculatorBinding.inflate(layoutInflater)
       setContentView(binding.root)

       binding.calculateBTN.setOnClickListener {
           val height = binding.heightET.text.toString().toFloatOrNull()?.div(100)
           val weight = binding.weightET.text.toString().toFloatOrNull()
           if(height == null || weight == null || height == 0f){
               Toast.makeText(this,"Please enter valid numbers",Toast.LENGTH_SHORT).show()
               Log.d("BMI","Height or weight is null")
               return@setOnClickListener
           }
           val bmi = weight / (height * height)
           binding.resultTXT.text = "Your BMI is: %.2f".format(bmi)
           if(bmi < 18.5){
               binding.resultTXT.setTextColor(getColor(R.color.red))
               Toast.makeText(this, "Underweight", Toast.LENGTH_SHORT).show()
           }else if(bmi >=25){
               binding.resultTXT.setTextColor(getColor(R.color.red))
               Toast.makeText(this, "Overweight", Toast.LENGTH_SHORT).show()
           }
           else{
               binding.resultTXT.setTextColor(getColor(R.color.black))
               Toast.makeText(this,"You are fit",Toast.LENGTH_SHORT).show()
           }
       }

    }
}