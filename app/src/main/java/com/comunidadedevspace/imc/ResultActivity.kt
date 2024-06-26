package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_RESULT_BMI, 0f)
        val tvresult = findViewById<TextView>(R.id.tv_result)
        val tvrating = findViewById<TextView>(R.id.tv_class)
        tvresult.text = result.toString()



        var (rating, color) = when {
            result <= 18.5 -> {
                "UNDERWEIGHT" to R.color.bright_red
            }

            result > 18.5f && result <= 24.9f -> {
                "NORMAL" to R.color.green
            }

            result > 25 && result <= 29.9 -> {
                "OVERWEIGHT" to R.color.yellow
            }

            result > 30 && result <= 39.9 -> {
                "OBESITY" to R.color.bright_red
            }

            else -> {
                "SEVERE OBESITY" to R.color.dark_red
            }
        }

        tvrating.setTextColor(ContextCompat.getColor(this, color))

        tvrating.text = rating


    }

}
