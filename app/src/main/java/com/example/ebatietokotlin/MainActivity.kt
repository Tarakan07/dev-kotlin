package com.example.ebatietokotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Находим TextView и сохраняем ссылку на него
        textView = findViewById(R.id.textView)

        // Устанавливаем слушатель на кнопку "Toast"
        findViewById<Button>(R.id.toast_btn).setOnClickListener { showToast() }

        // Устанавливаем слушатель на кнопку "Count"
        findViewById<Button>(R.id.count_btn).setOnClickListener { incrementCount() }

        // Устанавливаем слушатель на кнопку "Random"
        findViewById<Button>(R.id.random_btn).setOnClickListener { random() }

        // Устанавливаем слушатель на главный layout, чтобы обработать системные отступы
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showToast() {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }

    private fun incrementCount() {
        var count = textView.text.toString().toIntOrNull() ?: 0
        count++
        textView.text = count.toString()
    }
    private fun random(){
        val randomIntent=Intent(this,SecondActivity::class.java)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT,textView.text.toString().toIntOrNull())
        startActivity(randomIntent);
    }
}


