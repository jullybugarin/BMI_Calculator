package com.comunidadedevspace.imc

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


        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btncalcular = findViewById<Button>(R.id.button_calcular)


        btncalcular.setOnClickListener {
            val pesostr: String = edtpeso.text.toString()
            val alturastr: String = edtaltura.text.toString()
            if (pesostr == "" && alturastr == "") {

                Snackbar.make(
                    edtpeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val peso = pesostr.toFloat()
                val altura = alturastr.toFloat()

                val alturaq2 = altura * altura
                val resultado = peso / alturaq2

                println("Isso é um botão " + resultado)
            }
        }
    }
}