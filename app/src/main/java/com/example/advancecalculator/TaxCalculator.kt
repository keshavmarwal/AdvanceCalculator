package com.example.advancecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.advancecalculator.databinding.ActivityGstcalculaterBinding

class TaxCalculator : AppCompatActivity() {
   private  lateinit var binding: ActivityGstcalculaterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding = ActivityGstcalculaterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateBTN.setOnClickListener {
            calculateGST()
        }
    }

    private fun calculateGST() {
        // Retrieve user inputs
        val amount = binding.amountET.text.toString().toDoubleOrNull()
        val gst = binding.gstET.text.toString().toDoubleOrNull()
        val spinner = binding.spinerView.selectedItem.toString()

        // Validate inputs
        if (amount == null || gst == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        when (spinner) {
            "Inclusive" -> {
                // For Inclusive GST
                val actualAmount = (amount * 100) / (100 + gst)
                val gstAmount = amount - actualAmount

                // Update UI
                binding.amountTXT.text = String.format("₹%.2f ", actualAmount)
                binding.gstTXT.text = String.format("₹%.2f ", gstAmount)
                binding.totalAmountTXT.text = String.format("₹%.2f ", amount)
            }
            "Exclusive" -> {
                // For Exclusive GST
                val gstAmount = (amount * gst) / 100
                val totalAmount = amount + gstAmount

                // Update UI
                binding.amountTXT.text = String.format("₹%.2f ", amount)
                binding.gstTXT.text = String.format("₹%.2f", gstAmount)
                binding.totalAmountTXT.text = String.format("₹%.2f", totalAmount)
            }
            else -> {
                Toast.makeText(this, "Invalid tax type selected", Toast.LENGTH_SHORT).show()
            }
        }


    }
}