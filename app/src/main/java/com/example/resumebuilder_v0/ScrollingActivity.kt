package com.example.resumebuilder_v0

import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.resumebuilder_v0.databinding.ActivityScrollingBinding
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class ScrollingActivity : AppCompatActivity() {


    lateinit var binding: ActivityScrollingBinding
    lateinit var name: String
    lateinit var education: String
    lateinit var major: String
    lateinit var work: String
    lateinit var contact: String
    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title


        //finding and setting values of buttons and text


        submit = findViewById(R.id.submit_button)
        submit.setOnClickListener{
            name = findViewById<TextInputLayout>(R.id.input_name).editText!!.text.toString()
            showToast(name)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }



    private fun showToast(text: String) {
       Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}


/*
submit.setOnClickListener{

            name = findViewById<TextInputLayout>(R.id.input_name).editText!!.text.toString()
            showToast(name)
    name = findViewById<TextInputLayout>(R.id.input_name).editText.toString()
    education = findViewById<TextInputLayout>(R.id.input_education).editText.toString()
    major = findViewById<TextInputLayout>(R.id.input_major).editText.toString()
    work = findViewById<TextInputLayout>(R.id.input_work).editText.toString()
    contact = findViewById<TextInputLayout>(R.id.input_contact).editText.toString()


               education = findViewById<TextInputLayout>(R.id.input_education).editText!!.text.toString()
            major = findViewById<TextInputLayout>(R.id.input_major).editText!!.text.toString()
            work = findViewById<TextInputLayout>(R.id.input_work).editText!!.text.toString()
            contact = findViewById<TextInputLayout>(R.id.input_contact).editText!!.text.toString()
            showToast(name)
            showToast(education)
            showToast(major)
            showToast(work)
            showToast(contact)
}

 */