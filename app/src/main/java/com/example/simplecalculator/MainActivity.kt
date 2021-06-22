package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simplecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button0.setOnClickListener { fillOperationString(bindingClass.button0.text.toString()) }
        bindingClass.button1.setOnClickListener { fillOperationString(bindingClass.button1.text.toString()) }
        bindingClass.button2.setOnClickListener { fillOperationString(bindingClass.button2.text.toString()) }
        bindingClass.button3.setOnClickListener { fillOperationString(bindingClass.button3.text.toString()) }
        bindingClass.button4.setOnClickListener { fillOperationString(bindingClass.button4.text.toString()) }
        bindingClass.button5.setOnClickListener { fillOperationString(bindingClass.button5.text.toString()) }
        bindingClass.button6.setOnClickListener { fillOperationString(bindingClass.button6.text.toString()) }
        bindingClass.button7.setOnClickListener { fillOperationString(bindingClass.button7.text.toString()) }
        bindingClass.button8.setOnClickListener { fillOperationString(bindingClass.button8.text.toString()) }
        bindingClass.button9.setOnClickListener { fillOperationString(bindingClass.button9.text.toString()) }
        bindingClass.buttonLeftBracket.setOnClickListener { fillOperationString(bindingClass.buttonLeftBracket.text.toString()) }
        bindingClass.buttonRightBracket.setOnClickListener { fillOperationString(bindingClass.buttonRightBracket.text.toString()) }
        bindingClass.buttonMinus.setOnClickListener { fillOperationString(bindingClass.buttonMinus.text.toString()) }
        bindingClass.buttonMultiply.setOnClickListener { fillOperationString(bindingClass.buttonMultiply.text.toString()) }
        bindingClass.buttonPlus.setOnClickListener { fillOperationString(bindingClass.buttonPlus.text.toString()) }
        bindingClass.buttonDivide.setOnClickListener { fillOperationString(bindingClass.buttonDivide.text.toString()) }

        bindingClass.buttonAC.setOnClickListener {
            bindingClass.operation.text = ""
            bindingClass.operationResult.text = ""
        }

        bindingClass.buttonBack.setOnClickListener {
            var operationString: String = bindingClass.operation.text.toString()

            if (operationString.isNotEmpty()) {
                bindingClass.operation.text =
                    operationString.substring(0, operationString.length - 1)
                bindingClass.operationResult.text = ""
            }
        }

        bindingClass.buttonEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(bindingClass.operation.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()) {
                    bindingClass.operationResult.text = longResult.toString()
                } else {
                    bindingClass.operationResult.text = result.toString()
                }
            } catch (e: Exception) {
                Log.d("Error", "Error: ${e.message}")
            }
        }

        bindingClass.buttonPoint.setOnClickListener { fillOperationString(bindingClass.buttonPoint.text.toString()) }
    }

    private fun fillOperationString(string: String) {
        if (bindingClass.operationResult.text.isNotEmpty()) {
            bindingClass.operation.text = bindingClass.operationResult.text
            bindingClass.operationResult.text = ""
        }

        bindingClass.operation.append(string)
    }
}