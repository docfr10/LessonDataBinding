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
        binding.lifecycleOwner = this // Для автоматического обновления UI

        val text1 = Text("123")
        val text2 = Text("1234")
        binding.setVariable(1, text1) // Установливаем значение 123 в 1 элемент <data>
        binding.setVariable(2, text2) // Установливаем значение 1234 во 2 элемент <data>

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