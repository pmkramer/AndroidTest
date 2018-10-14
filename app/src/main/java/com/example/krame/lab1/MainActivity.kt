package com.example.krame.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.krame.lab1.R.id.button4
import com.example.krame.lab1.R.string.long_click
//import com.example.krame.lab1.R.id.sample_text
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        // sample_text.text = stringFromJNI()

        // Long Click Listener
        button4.setOnLongClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this@MainActivity, "You held down for longer than usual!!!", Toast.LENGTH_SHORT).show()
            true
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello User!!!!!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun changeText(view: View) {
        textView.text = "You have changed the text"
    }

    fun toggleText(view: View) {
        if (textView.visibility == View.INVISIBLE)
            textView.visibility = View.VISIBLE
        else
            textView.visibility = View.INVISIBLE
    }
}
