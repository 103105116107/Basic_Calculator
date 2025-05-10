package com.example.calculator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtResult: TextView
    private var currentInput = ""
    private var sum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult = findViewById(R.id.resultText)
    }

    fun onDigitClick(view: View) {
        val button = view as Button
        currentInput += button.text
        txtResult.text = currentInput
    }

    fun onOperatorClick(view: View) {
        if (currentInput.isNotEmpty()) {
            sum += currentInput.toInt()
            currentInput = ""
            txtResult.text = "+"
        }
    }

    fun onEqualsClick(view: View) {
        if (currentInput.isNotEmpty()) {
            sum += currentInput.toInt()
            txtResult.text = sum.toString()
            currentInput = ""
            sum = 0
        }
    }

    fun onClearClick(view: View) {
        currentInput = ""
        sum = 0
        txtResult.text = "0"
    }
}