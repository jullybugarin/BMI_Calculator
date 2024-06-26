package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtweight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtheight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnevaluate = findViewById<Button>(R.id.button_evaluate)


        btnevaluate.setOnClickListener {
            val weight_str: String = edtweight.text.toString()
            val height_str: String = edtheight.text.toString()
            if (weight_str == "" && height_str == "") {

                Snackbar.make(
                    edtweight,
                    "Enter all necessary information",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val weight_final = weight_str.toFloat()
                val height_final = height_str.toFloat()

                val height_q2 = height_final * height_final
                val result_ibm = weight_final / height_q2

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BMI, result_ibm)
                startActivity(intent)

            }
        }
    }
}