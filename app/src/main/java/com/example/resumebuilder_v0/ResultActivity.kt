package com.example.resumebuilder_v0

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.internal.ViewUtils.getContentView
import java.io.OutputStream


class ResultActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi", "SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var info  = intent.getSerializableExtra("ResumeInfo") as? ScrollingActivity.ResumeInfo


        /*
        val resumePDF = PdfDocument()
        val pageInfo = PageInfo.Builder(100, 100, 1).create()
        var page = resumePDF.startPage(pageInfo)
        val content = this.findViewById<View>(android.R.id.content)
        content.draw(page.canvas)
        resumePDF.finishPage(page)
        resumePDF.writeTo()
        resumePDF.close()
         */



        //setup download button
        val downloadButton = findViewById<Button>(R.id.downloadButton)
        downloadButton.setOnClickListener{

            var testText = findViewById<TextView>(R.id.resultText)
            testText.text = info!!.name + info.education + info.major + info.work + info.contact
            /*
            showToast(info!!.name)
            showToast(info.education)
            showToast(info.major)
            showToast(info.work)
            showToast(info.contact)
             */
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