package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var firstNumber:Float = 1F
    private var secondNumber:Float = 1F
    private var operation:Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(){operation(" + ")}
        minus.setOnClickListener(){ operation(" - ") }
        divide.setOnClickListener(){operation(" / ")}
        multiply.setOnClickListener(){operation(" * ")}

        calculate.setOnClickListener(){
            secondNumber = input.text.toString().toFloat()
            equation.text = equation.text.toString() + input.text.toString()
            var result = 0.0F
            when(operation){
                '+' -> result = firstNumber + secondNumber
                '-' -> result = firstNumber - secondNumber
                '/' -> result = firstNumber / secondNumber
                '*' -> result = firstNumber * secondNumber
            }
            input.setText(result.toString())
        }

        reset.setOnClickListener(){
            equation.text = ""
            input.setText("")
        }
    }

    fun operation(opn: String) {
        when(opn){
            " + " -> {
                equation.text = input.text.toString() + " + "
                firstNumber = input.text.toString().toFloat()
                operation = '+'
                input.text = null
            }
            " - " -> {
                equation.text = input.text.toString() + " - "
                firstNumber = input.text.toString().toFloat()
                input.text = null
                operation ='-'
            }
            " / " -> {
                equation.text = input.text.toString() + " / "
                firstNumber = input.text.toString().toFloat()
                input.text = null
                operation='/'
            }
            " * " ->{
                equation.text = input.text.toString() + " * "
                firstNumber = input.text.toString().toFloat()
                input.text = null
                operation='*'
            }
        }
    }
}
