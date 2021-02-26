package com.example.layouthw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonHandler(view: View) {
        val btn = findViewById<Button>(view.id);
        val textView = findViewById<TextView>(R.id.script);

        if(btn.text == getString(R.string.remove)) {
            if(textView.text.length <= 1) {
                if(textView.text != "0") {
                    textView.text = "0";
                }
                else {
                    return;
                }
            }
            else {
                textView.text = textView.text.toString().substring(0, textView.text.length - 1);
            }

        }
        else if (btn.text == "=") {
            val res = onEqual(textView.text.toString());
            textView.text = res.toString();
        }
        else {
            textView.text = textView.text.toString() + btn.text.toString();
        }
    }

    private fun onEqual(textString: String): Number {
        try {
            val expression = ExpressionBuilder(textString).build();
            val result = expression.evaluate();

            return result;
        } catch (e: Exception) {
            println(e.message);
        }
        return 0;
    }
}

