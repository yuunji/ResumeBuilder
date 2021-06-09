/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.pdfrendererbasic

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.resumebuilder_v0.R


/**
 * This fragment has a big [ImageView] that shows PDF pages, and 2 [Button]s to move between pages.
 */
class PdfRendererBasicFragment : Fragment(R.layout.pdf_renderer_basic_fragment) {

    private val viewModel: PdfRendererBasicViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // View references.
        val image: ImageView = view.findViewById(R.id.image)

        viewModel.pageBitmap.observe(viewLifecycleOwner, { image.setImageBitmap(it) })

    }

}

/* PREV AND NEXT BUTTON SETUP

--------------------FRAGMENT CODE--------

        val buttonPrevious: Button = view.findViewById(R.id.previous)
        val buttonNext: Button = view.findViewById(R.id.next)

        viewModel.previousEnabled.observe(viewLifecycleOwner, Observer {
            buttonPrevious.isEnabled = it
        })
        viewModel.nextEnabled.observe(viewLifecycleOwner, Observer {
            buttonNext.isEnabled = it
        })

        // Bind events.
        buttonPrevious.setOnClickListener { viewModel.showPrevious() }
        buttonNext.setOnClickListener { viewModel.showNext() }



 ------------------------XML----------------------------
         <Button
            android:id="@+id/previous"
            style="?android:attr/buttonBarButtonStyle"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/previous" />

        <Button
            android:id="@+id/next"
            style="?android:attr/buttonBarButtonStyle"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/next" />

------------------VIEWMODEL CODE--------------

    private val _previousEnabled = MutableLiveData<Boolean>()
    val previousEnabled: LiveData<Boolean>
        get() = _previousEnabled

    private val _nextEnabled = MutableLiveData<Boolean>()
    val nextEnabled: LiveData<Boolean>
        get() = _nextEnabled

        fun showPrevious() {
        scope.launch {
            currentPage?.let { page ->
                if (page.index > 0) {
                    showPage(page.index - 1)
                }
            }
        }
    }

    fun showNext() {
        scope.launch {
            pdfRenderer?.let { renderer ->
                currentPage?.let { page ->
                    if (page.index + 1 < renderer.pageCount) {
                        showPage(page.index + 1)
                    }
                }
            }
        }
    }


 ~~~~inside showpage on viewmodel~~~~~

   _previousEnabled.postValue(index > 0)
   _nextEnabled.postValue(index + 1 < count)

 */


