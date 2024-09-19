package com.example.imcapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imcapp.constants.ActivityIntentExtraParams
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var heightField: TextInputEditText
    private lateinit var weightField: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        submitButton = findViewById(R.id.submit)
        heightField = findViewById(R.id.edit_height)
        weightField = findViewById(R.id.edit_weight)

        submitButton.setOnClickListener {

            val weight = weightField.text.toString()
            val height = heightField.text.toString()

            if(weight.isNotEmpty() && height.isNotEmpty()) {
                startActivity(
                    Intent(this, ResultActivity::class.java)
                        .putExtra(ActivityIntentExtraParams.WEIGHT.name, weight.toDouble())
                        .putExtra(ActivityIntentExtraParams.HEIGHT.name, height.toDouble())
                )
            }
        }
    }
}