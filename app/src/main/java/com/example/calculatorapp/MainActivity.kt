package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    //Declaring the binding variable
    private lateinit var binding: ActivityMainBinding

    //Declaring some variables to work with
    var lastNumeric = false // to check if the last entered number was numeric or not
    var stateError = false // to check if there is any error in the statement passed by the user
    var lastDot = false // to check if the last entered digit was a dot


    private lateinit var expression: Expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onOperatorClick(view: View) {

        if (!stateError && lastNumeric){
            binding.dataTv.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqual()
        }
    }
    fun onEqualClick(view: View) {
        onEqual()
        binding.dataTv.text = binding.solutionTv.text.toString().drop(1)
    }
    fun onAllClearClick(view: View) {

        binding.dataTv.text = ""
        binding.solutionTv.text = ""
        stateError = false
        lastDot = false
        lastNumeric = false
        binding.solutionTv.visibility = View.GONE
    }
    fun onClearClick(view: View) {
        binding.dataTv.text = ""
        lastNumeric = false
    }
    fun onBackClick(view: View) {
        binding.dataTv.text = binding.dataTv.text.toString().dropLast(1) //continously dropping the last character

        //try..catch expression to handle the logic of the last character being dropped

        try {
            val lastChar = binding.dataTv.text.toString().last() // declaring the last character

            if (lastChar.isDigit()){ //If the last character is a digit, the onEqual function is called
                onEqual()
            }
        }catch (e: Exception){ //the case where the last character is not a digit
            binding.solutionTv.text = ""
            binding.solutionTv.visibility = View.GONE
            Log.d("last character error",e.toString())

        }
    }
    fun onDigitClick(view: View) {
        if (stateError){
            binding.dataTv.text = (view as Button).text
            stateError = false
        }else{
            binding.dataTv.append((view as Button).text)
        }

        lastNumeric = true
        onEqual()
    }


    //A function that will evaluate an expression that the user will enter
    private fun onEqual(){

        if (lastNumeric && !stateError){ //if lastNumeric == true and stateError == false
            val txt = binding.dataTv.text.toString()
            expression = ExpressionBuilder(txt).build() //building the expression

            //try ... catch to evaluate the expression

            try {
                val solution = expression.evaluate()
                binding.solutionTv.visibility = View.VISIBLE
                binding.solutionTv.text = "=" + solution.toString()


            }catch (ex: ArithmeticException){
                Log.d("error", ex.toString())
                binding.solutionTv.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }

    }


}