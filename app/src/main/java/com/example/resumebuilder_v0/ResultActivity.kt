package com.example.resumebuilder_v0

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color.rgb
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.example.android.pdfrendererbasic.PdfRendererBasicFragment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


@RequiresApi(Build.VERSION_CODES.KITKAT)
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //get input info and display on test text
        val info  = intent.getSerializableExtra("ResumeInfo") as? ScrollingActivity.ResumeInfo
        val testText = findViewById<TextView>(R.id.resultText)
        testText.text = info!!.name + info.education + info.major + info.work + info.contact

        //setup download button
        val downloadButton = findViewById<Button>(R.id.downloadButton)
        downloadButton.setOnClickListener{
            showToast("View PDF")

            //show pdf
            if (savedInstanceState == null) {
                supportFragmentManager.commitNow {
                    replace(R.id.resultContainer, PdfRendererBasicFragment())
                }
            }

        }

        //button to return to original screen
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener{
            val intent = Intent(this, ScrollingActivity::class.java)
            startActivity(intent)
        }
     }


    private fun createPDF(data : String) {
        val directory = this.getExternalFilesDir(null).toString()
        val fol = File(directory, "pdf")
        val folder = File(fol, "pdf")
        if (!folder.exists()) {
            folder.mkdir()
        }
        try {
            val file = File(folder, "userResume.pdf")
            val fOut = FileOutputStream(file)
            val resumePDF = PdfDocument()
            val pageInfo = PageInfo.Builder(100, 100, 1).create()
            val page = resumePDF.startPage(pageInfo)
            val canvas: Canvas = page.canvas
            val paint = Paint()
            paint.color = rgb(80, 40, 80)
            canvas.drawText(data, 100F, 100F, paint)
            resumePDF.finishPage(page)
            resumePDF.writeTo(fOut)
            resumePDF.close()
        } catch (e: IOException) {
            Log.i("error", e.getLocalizedMessage()!!)
        }

    }

    fun showToast(text: String) { Toast.makeText(this, text, Toast.LENGTH_LONG).show() }

}






//var testText = findViewById<TextView>(R.id.resultText)
//testText.text = info!!.name + info.education + info.major + info.work + info.contact

//var testresume = createPDF("TEST TEXT");


//pdf generation
// var testPDF = createPDF("TEST TEXT");

//val pfd = ParcelFileDescriptor.
//val renderer = PdfRenderer(pfd)


//this.openFileInput()
//val path: Uri = Uri.fromFile(pdfFile)

/*
            Log.d("abc","FILE ABSOLUTE PATH " + file.absolutePath)
            Log.d("abc","FILE ABSOLUTE PATH " + file.absolutePath)
            Log.d("abc","FILE  PATH " + file.path)
            Log.d("abc","FILE  ISABOSLUTE?  " + file.isAbsolute.toString())
            Log.d("abc","FILE NAME? " + file.name)
            Log.d("abc","FILE PARENT " + file.parentFile)
            Log.d("abc","FILE HIDDEN? " + file.isHidden.toString())
            Log.d("abc","FILE EXISTS? " + file.isFile.toString())

    //TROUBLE GETTING FILE. IT'S EITHER NEVER MADE PROPERLY OR I'M ACCESSING IT INCORRECTLY
    //testText.text = File(filedirectory).isFile.toString()
    //var testfile = File(filedirectory)
    Log.d("abc", "CAN READ? " + testfile.canRead().toString()) //false
    Log.d("abc", "TO STRING " + testfile.toString())
    Log.d("abc", "FILE LENGTH? " + testfile.length().toString())
    Log.d("abc", "FILE EXISTS?? " + testfile.exists().toString()) //false
    Log.d("abc", "FILE READ BYTES?? " + testfile.readBytes()) //stops here
    Log.d("abc", "FILE READ TEXT UTF8?? " + testfile.readText(Charsets.UTF_8))

*/

// val pdfIntent = Intent(Intent.ACTION_VIEW)
// var path = Uri.fromFile(testfile)
//pdfIntent.setDataAndType(path, "application/pdf")
//  pdfIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

//testfile.
//startActivity(pdfIntent)


/*
var gotResume = File(filedirectory)
var path =  Uri.fromFile(gotResume);
val pdfIntent = Intent(Intent.ACTION_VIEW)
pdfIntent.setDataAndType(path, "application/pdf")
pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
startActivity(pdfIntent);

//viewPdf("userResume.pdf",)

showToast(info!!.name)
showToast(info.education)
showToast(info.major)
showToast(info.work)
showToast(info.contact)
 */




