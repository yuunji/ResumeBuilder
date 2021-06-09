package com.example.resumebuilder_v0

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import com.example.resumebuilder_v0.databinding.ActivityScrollingBinding
import com.google.android.material.textfield.TextInputLayout

import java.io.Serializable

class ScrollingActivity : AppCompatActivity() {

    lateinit var binding: ActivityScrollingBinding
    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title

        val inputInfo = ResumeInfo()

        //submit button
        submit = findViewById(R.id.submit_button)
        submit.setOnClickListener{

            //get input and place into object
            inputInfo.name = findViewById<TextInputLayout>(R.id.input_name).editText!!.text.toString()
            inputInfo.education = findViewById<TextInputLayout>(R.id.input_education).editText!!.text.toString()
            inputInfo.major = findViewById<TextInputLayout>(R.id.input_major).editText!!.text.toString()
            inputInfo.work = findViewById<TextInputLayout>(R.id.input_work).editText!!.text.toString()
            inputInfo.contact = findViewById<TextInputLayout>(R.id.input_contact).editText!!.text.toString()

            //goes to next screen with inputted info
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("ResumeInfo", inputInfo)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    //input info object
    class ResumeInfo : Serializable
    {
        var name : String = ""
        var education : String = ""
        var major : String = ""
        var work : String = ""
        var contact : String = ""
    }

    private fun showToast(text: String) { Toast.makeText(this, text, Toast.LENGTH_SHORT).show() }

}

