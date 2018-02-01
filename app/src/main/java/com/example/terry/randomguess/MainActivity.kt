package com.example.terry.randomguess

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    var number = ((Math.random() * 100001) + 1 ) . toInt()

        Toast.makeText( this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show()
        val nmb = findViewById<EditText>(R.id.nmb)
        val guessBtn = findViewById<Button>(R.id.guessBtn)
        val toastBtn = findViewById<Button>(R.id.toastBtn)

    guessBtn.setOnClickListener {
        if (number == nmb.text.toString() .toInt()){
            Toast.makeText(  this,  "Great Job", Toast.LENGTH_LONG) . show()
            nmb.setText ("")
        }
        else {
            Toast.makeText (  this,  "Not quite. Try again", Toast.LENGTH_LONG) .show()
            nmb.setText ("")

        }
    hideKeyboard()
    }

    toastBtn.setOnClickListener {
        number = ((Math.random() * 100001) + 1 ) . toInt()
        println (number)
        Toast.makeText (  this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show()
    }

    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)

        } catch (e: Exception) {
        }
    }
}
