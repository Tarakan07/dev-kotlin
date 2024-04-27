package com.example.ebatietokotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Instant
import kotlin.math.log
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    private lateinit var textRandom: TextView
    private lateinit var textFrom: TextView

    companion object {
        const val TOTAL_COUNT = "init count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textRandom = findViewById(R.id.textViewRandom)
        textFrom = findViewById(R.id.textViewFrom)
        getExtraData()
    }



    private fun getExtraData() {
        val getData = intent.getIntExtra(TOTAL_COUNT, 0)

        textFrom.text = getString(R.string.random_from, getData)
        var randomInt = 0
        if (getData > 0) {
            randomInt = Random.nextInt(getData + 1);
        }
        textRandom.text = randomInt.toString()
    }
}