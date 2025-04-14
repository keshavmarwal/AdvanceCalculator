package com.example.advancecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.advancecalculator.databinding.ActivityIntersestCalculatorBinding
import kotlin.math.pow

class InterestCalculator : AppCompatActivity() {
    lateinit var binding: ActivityIntersestCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntersestCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBTN.setOnClickListener {
            calculateInterest()
        }
    }

    private fun calculateInterest() {
        // Retrieve user inputs and validate
        val Pa = binding.initialET.text.toString().toDoubleOrNull()
        val R = binding.interestET.text.toString().toDoubleOrNull()
        val Ty = binding.yearET.text.toString().toDoubleOrNull()
        val TM = binding.monthET.text.toString().toDoubleOrNull()
        val selectedOption = binding.spinerView.selectedItem.toString()

        if (Pa == null || R == null || Ty == null || TM == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Convert percentage rate to decimal
        val annualRate = R / 100
        val totalYears = Ty + (TM / 12) // Convert months to years

        // Determine compounding frequency
        val compoundingFrequency = when (selectedOption) {
            "Annually" -> 1
            "Monthly" -> 12
            "Quarterly" -> 4
            "Weekly" -> 52
            "Daily" -> 365
            else -> {
                Toast.makeText(this, "Invalid selection", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Calculate final amount and interest earned
        val (finalAmount, interestEarned) = calculateCompoundInterest(Pa, annualRate, totalYears, compoundingFrequency)

        // Update UI
        binding.iatxt.text = String.format("Initial Amount: %.2f", Pa)
        binding.itxt.text = String.format("Interest Amount: %.2f", interestEarned)
        binding.fatxt.text = String.format("Final Amount: %.2f", finalAmount)
    }

    private fun calculateCompoundInterest(P: Double, r: Double, t: Double, n: Int): Pair<Double, Double> {
        val A = P * (1 + r / n).pow(n * t) // Compound interest formula
        val interest = A - P // Interest earned
        return Pair(A, interest)
    }
}
