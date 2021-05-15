package com.example.resumebuilder_v0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.resumebuilder_v0.databinding.ActivityResultBinding
import java.io.Serializable

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)




        //gets info from previous activity, setup download button
        var info  = intent.getSerializableExtra("ResumeInfo") as? ScrollingActivity.ResumeInfo
        val downloadButton = findViewById<Button>(R.id.downloadButton)
        downloadButton.setOnClickListener{
            showToast(info!!.name)
            showToast(info.education)
            showToast(info.major)
            showToast(info.work)
            showToast(info.contact)
        }


        //button to return to original screen
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener{
            val intent = Intent(this, ScrollingActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}