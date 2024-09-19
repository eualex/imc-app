package com.example.imcapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imcapp.constants.ActivityIntentExtraParams

class ResultActivity : AppCompatActivity() {
    private lateinit var resultHeightText: TextView
    private lateinit var resultWeightText: TextView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultWeightText = findViewById(R.id.result_weight)
        resultHeightText = findViewById(R.id.result_height)
        resultText = findViewById(R.id.result)

        val extra = intent.extras ?: return

        val height = extra.getDouble(ActivityIntentExtraParams.HEIGHT.name)
        val weight = extra.getDouble(ActivityIntentExtraParams.WEIGHT.name)

        resultWeightText.text = "Peso informado: $weight kg"
        resultHeightText.text = "Altura informada: $height m"

        val imc = weight / (height * height)

        resultText.text = when {
            imc < 18.5 -> "Baixo"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidade"
        }
    }
}