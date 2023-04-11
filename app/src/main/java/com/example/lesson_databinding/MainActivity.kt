package com.example.lesson_databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.lesson_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btSubmit.setOnClickListener {
            val sText = binding.etInput.text.toString().trim()
            // Check condition
            if (sText != "")
                binding.tvOutput.text = sText
            else
                Toast.makeText(applicationContext, "Please enter text", Toast.LENGTH_SHORT).show()
        }
    }
}