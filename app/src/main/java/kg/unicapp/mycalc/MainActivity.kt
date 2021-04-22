package kg.unicapp.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt_0 = findViewById<TextView>(R.id.bt_zero)
        val bt_1 = findViewById<TextView>(R.id.bt_1)
        val bt_2 = findViewById<TextView>(R.id.bt_2)
        val bt_3 = findViewById<TextView>(R.id.bt_3)
        val bt_4 = findViewById<TextView>(R.id.bt_4)
        val bt_5 = findViewById<TextView>(R.id.bt_5)
        val bt_6 = findViewById<TextView>(R.id.bt_6)
        val bt_7 = findViewById<TextView>(R.id.bt_7)
        val bt_8 = findViewById<TextView>(R.id.bt_8)
        val bt_9 = findViewById<TextView>(R.id.bt_9)
        val bt_div = findViewById<TextView>(R.id.bt_div)
        val bt_multiple = findViewById<TextView>(R.id.bt_miltiple)
        val bt_plus = findViewById<TextView>(R.id.bt_plus)
        val bt_minus = findViewById<TextView>(R.id.bt_minus)
        val bt_brackO = findViewById<TextView>(R.id.bt_brO)
        val bt_brackC = findViewById<TextView>(R.id.bt_brC)
        val inputNum = findViewById<TextView>(R.id.inputNum)
        val resultText = findViewById<TextView>(R.id.result)
        val clear = findViewById<TextView>(R.id.bt_ac)
        val bt_back = findViewById<TextView>(R.id.bt_bck)
        val bt_equal = findViewById<TextView>(R.id.bt_eq)
        val bt_point = findViewById<TextView>(R.id.bt_point)

        bt_0.setOnClickListener { setText("0") }
        bt_1.setOnClickListener { setText("1") }
        bt_2.setOnClickListener { setText("2") }
        bt_3.setOnClickListener { setText("3") }
        bt_4.setOnClickListener { setText("4") }
        bt_5.setOnClickListener { setText("5") }
        bt_6.setOnClickListener { setText("6") }
        bt_7.setOnClickListener { setText("7") }
        bt_8.setOnClickListener { setText("8") }
        bt_9.setOnClickListener { setText("9") }
        bt_div.setOnClickListener { setText("/") }
        bt_minus.setOnClickListener { setText("-") }
        bt_plus.setOnClickListener { setText("+") }
        bt_multiple.setOnClickListener { setText("*") }
        bt_brackC.setOnClickListener { setText(")") }
        bt_brackO.setOnClickListener { setText("(") }
        bt_point.setOnClickListener { setText(".") }



        clear.setOnClickListener {
            inputNum.text = ""
            resultText.text = ""
        }
        bt_back.setOnClickListener{
            val btnback = inputNum.text.toString()
            if(btnback.isNotEmpty())
                inputNum.text = btnback.substring(0, btnback.length - 1)
                resultText.text = ""

        }
        bt_equal.setOnClickListener {
            try{
                val expres = ExpressionBuilder(inputNum.text.toString()).build()
                val result = expres.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    resultText.text = longResult.toString()
                else
                    resultText.text = result.toString()
                
            } catch (e:Exception){
                Log.d("Внимание", "код: ${e.message}")
            }
        }







    }
    fun setText(str: String) {
        val inputNum = findViewById<TextView>(R.id.inputNum)
        val resultText = findViewById<TextView>(R.id.result)
        if(resultText.text  != "") {
            inputNum.text = resultText.text
            resultText.text = ""
        }

        inputNum.append(str)
    }
}

