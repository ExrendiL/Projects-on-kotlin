package com.example.mmm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { enternum("0") }
        btn_1.setOnClickListener { enternum("1") }
        btn_2.setOnClickListener { enternum("2") }
        btn_3.setOnClickListener { enternum("3") }
        btn_4.setOnClickListener { enternum("4") }
        btn_5.setOnClickListener { enternum("5") }
        btn_6.setOnClickListener { enternum("6") }
        btn_7.setOnClickListener { enternum("7") }
        btn_8.setOnClickListener { enternum("8") }
        btn_9.setOnClickListener { enternum("9") }
        btn_point.setOnClickListener { enternum(".") }
        btn_plus.setOnClickListener { enternum("+") }
        btn_min.setOnClickListener { enternum("-") }
        btn_mul.setOnClickListener { enternum("*") }
        btn_div.setOnClickListener { enternum("/") }
        btn_fn1.setOnClickListener { enternum("(") }
        btn_fn2.setOnClickListener { enternum(")") }
        btn_cl.setOnClickListener { math_oper.text="" }

        btn_cl.setOnClickListener {
            res.text=""
            math_oper.text=""
        }

        btn_ers.setOnClickListener {
            val str = math_oper.text.toString()
        if (str.isNotEmpty())
            math_oper.text=str.substring(0, str.length-1)
        res.text=""
        }

        btn_res.setOnClickListener {
            try{
                val ex = ExpressionBuilder(math_oper.text.toString()).build()
                val resik = ex.evaluate()
                val longres = resik.toLong()
                if(resik==longres.toDouble())
                    res.text=longres.toString()
                else
                    res.text=resik.toString()
            }
                catch (e:Exception){
                    Log.d("Error","Message ${e.message}")
                }
        }
    }
    fun enternum (str:String){
        if(res.text !=""){
            math_oper.text= res.text
            res.text=""
        }
        math_oper.append(str)
    }
}