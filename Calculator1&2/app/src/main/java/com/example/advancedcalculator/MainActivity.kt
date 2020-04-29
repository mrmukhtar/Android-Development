package com.example.advancedcalculator

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private var textContent: TextView?= null
    private var text: String? = null

    private var dotCount = 0
    private var number1 = 0.0
    private var number2 = 0.0
    private var result = 0.0
    private var resultFactorial = 0.0

    private var zero:Button?= null
    private var one:Button?= null
    private var two:Button?= null
    private var three:Button?= null
    private var four:Button?= null
    private var five:Button?= null
    private var six:Button?= null
    private var seven:Button?= null
    private var eight:Button?= null
    private var nine:Button?= null
    private var dott:Button? = null
    private var clear:Button?= null
    private var delete:Button? = null
    private var add:Button?= null
    private var minus:Button? = null
    private var divide:Button?= null
    private var multiply:Button? = null
    private var root:Button? = null
    private var square:Button? = null
    private var percent:Button? = null
    private var sin:Button? = null
    private var cos:Button? = null
    private var tan:Button? = null
    private var ln:Button? = null
    private var log:Button? = null
    private var nroot:Button? = null
    private var powerY:Button? = null
    private var pi:Button?= null
    private var buttonFactorial:Button? = null
    private var equal:Button? = null

    private var sign:Sign?= null

    enum class Sign {
        PLUS, MINUS, MUL, DIV, YPOW, NROOT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUIViews()

        zero?.setOnClickListener(this)
        one?.setOnClickListener(this)
        two?.setOnClickListener(this)
        three?.setOnClickListener(this)
        four?.setOnClickListener(this)
        five?.setOnClickListener(this)
        six?.setOnClickListener(this)
        seven?.setOnClickListener(this)
        eight?.setOnClickListener(this)
        nine?.setOnClickListener(this)
        dott?.setOnClickListener(this)
        clear?.setOnClickListener(this)
        delete?.setOnClickListener(this)
        add?.setOnClickListener(this)
        minus?.setOnClickListener(this)
        divide?.setOnClickListener(this)
        multiply?.setOnClickListener(this)
        root?.setOnClickListener(this)
        square?.setOnClickListener(this)
        percent?.setOnClickListener(this)
        equal?.setOnClickListener(this)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            sin!!.setOnClickListener(this);
            cos!!.setOnClickListener(this);
            tan!!.setOnClickListener(this);
            ln!!.setOnClickListener(this);
            log!!.setOnClickListener(this);
            nroot!!.setOnClickListener(this);
            buttonFactorial!!.setOnClickListener(this);
            powerY!!.setOnClickListener(this);
            pi!!.setOnClickListener(this);
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NumberInput", textContent?.text.toString())
        outState.putDouble("number1", number1)
        outState.putDouble("number2", number2)
        outState.putDouble("result", result)
        outState.putSerializable("enum", sign)
    }



    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number1 = savedInstanceState.getDouble("number1")
        number2 = savedInstanceState.getDouble("number2")
        result = savedInstanceState.getDouble("result")
        sign = savedInstanceState.getSerializable("enum") as Sign?
        text  = savedInstanceState.getString("NumberInput")
        textContent!!.text = text
    }

    private fun setUpUIViews(){
        textContent = findViewById(R.id.tv_content)

        zero = findViewById(R.id.btn_zero)
        one = findViewById(R.id.btn_one)
        two = findViewById(R.id.btn_two)
        three = findViewById(R.id.btn_three)
        four  = findViewById(R.id.btn_four)
        five = findViewById(R.id.btn_five)
        six = findViewById(R.id.btn_six)
        seven = findViewById(R.id.btn_seven)
        eight = findViewById(R.id.btn_eight)
        nine = findViewById(R.id.btn_nine)

        clear = findViewById(R.id.btn_clear)
        delete = findViewById(R.id.btn_delete_all)

        root = findViewById(R.id.btn_root)
        square = findViewById(R.id.btn_square)
        percent = findViewById(R.id.btn_percent)
        dott = findViewById(R.id.btn_dot)
        equal = findViewById(R.id.btn_equal)

        add = findViewById(R.id.btn_add)
        minus = findViewById(R.id.btn_minus)
        multiply = findViewById(R.id.btn_multiple)
        divide = findViewById(R.id.btn_divide)

        sin = findViewById(R.id.btn_sin)
        cos = findViewById(R.id.btn_cos)
        tan = findViewById(R.id.btn_tan)
        ln = findViewById(R.id.btn_ln)
        log = findViewById(R.id.btn_log)
        nroot = findViewById(R.id.btn_n_root)
        buttonFactorial = findViewById(R.id.btn_factorial)
        powerY = findViewById(R.id.btn_Ypow)
        pi= findViewById(R.id.btn_pi)
    }

    private var factorial: Long = 1
    private fun calcFactorial(){
        run {
            var i = 1
            while (i <= number1) {
                factorial = i * factorial
                i++
            }
        }
    }

    override fun onClick(v: View?) {
        val id: Int = v!!.id

        when(id){
            R.id.btn_zero -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0 && dotCount != 1)
                    textContent?.text = ""
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("0")
            }
            R.id.btn_one -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("1")
            }
            R.id.btn_two -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("2")
            }
            R.id.btn_three -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("3")
            }
            R.id.btn_four -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("4")
            }
            R.id.btn_five -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("5")
            }
            R.id.btn_six -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("6")
            }
            R.id.btn_seven -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("7")
            }
            R.id.btn_eight -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("8")
            }
            R.id.btn_nine -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                textContent?.append("9")
            }
            R.id.btn_dot -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0)
                    textContent?.text = "0."
                if(textContent?.text!!.contains("."))
                    dotCount = 1
                else
                    textContent?.append(".")
                dotCount = 1
            }
            R.id.btn_clear -> {
                textContent?.text = null
            }
            R.id.btn_delete_all -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text?.length == 0)
                    textContent?.text = null
                var s: String = textContent?.text.toString()
                val len: Int = s.length
                if(len > 0) {
                    s = s.substring(0, len - 1)
                    textContent?.text = s
                }
            }
            R.id.btn_add -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = null
                sign = Sign.PLUS
            }
            R.id.btn_minus -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = null
                sign = Sign.MINUS
            }
            R.id.btn_divide -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = null
                sign = Sign.DIV
            }
            R.id.btn_multiple -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = null
                sign = Sign.MUL
            }
            R.id.btn_root -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                number1 = Math.sqrt(number1)
                textContent?.text =number1?.toString()
            }
            R.id.btn_square -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                number1 = Math.pow(number1 , 2.0)
                textContent?.text =number1?.toString()
            }
            R.id.btn_percent ->{
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = (number1/100).toString()
            }
            R.id.btn_pi ->{
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 1 && textContent?.text?.get(0) == '0')
                    textContent?.text = ""
                result = Math.PI
                textContent?.text = result.toString()
            }
            R.id.btn_factorial -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                calcFactorial()
                resultFactorial = factorial.toDouble()
                textContent?.text = resultFactorial.toString()
                factorial = 1
            }
            R.id.btn_sin -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                result = Math.sin(Math.toRadians(number1))
                textContent?.text = result.toString()
            }
            R.id.btn_cos -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                result = Math.cos(Math.toRadians(number1))
                textContent?.text = result.toString()
            }
            R.id.btn_tan -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                result = Math.tan(Math.toRadians(number1))
                textContent?.text = result.toString()
            }
            R.id.btn_ln -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                result = Math.log(number1)
                textContent?.text = result.toString()
            }
            R.id.btn_log -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                result = Math.log10(number1)
                textContent?.text = result.toString()
            }
            R.id.btn_n_root -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = null
                sign = Sign.NROOT
            }
            R.id.btn_Ypow -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                    number1 = 0.0
                }
                try {
                    number1 = textContent?.text.toString().toDouble()
                }catch (e : NumberFormatException){
                    textContent?.text = "Error"
                }
                dotCount = 0
                textContent?.text = null
                sign = Sign.YPOW
            }
            R.id.btn_equal -> {
                if(textContent?.text.toString().equals("Error"))
                    textContent?.text = null
                if(textContent?.text.toString().length == 0) {
                    textContent?.text = null
                }
                number2 = textContent?.text.toString().toDouble()

                if(sign == Sign.PLUS){
                    textContent?.text =(number1 + number2).toString()
                }
                else if(sign == Sign.MINUS){
                    textContent?.text =(number1 - number2).toString()
                }
                else if(sign == Sign.MUL){
                    textContent?.text =(number1 * number2).toString()
                }
                else if(sign == Sign.DIV){
                    if(number2 == 0.toDouble()){
                        textContent?.text = "Error"
                        number1 = 0.0
                    }else {
                        textContent?.text = (number1 / number2).toString()
                    }
                }
                else if(sign == Sign.YPOW){
                    textContent?.text =((Math.pow(number1, number2))).toString()
                }
                else if(sign == Sign.NROOT){
                    textContent?.text =((Math.pow(number1, 1/number2))).toString()
                }
            }
        }
    }
}