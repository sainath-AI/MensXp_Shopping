package com.masai.sainath.mensxp.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.masai.sainath.mensxp.R
import kotlinx.android.synthetic.main.activity_terms_and_coditions.*

class TermsAndCoditions : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_coditions)
        webview1.webViewClient
        webview1.loadUrl("https://shop.mensxp.com/terms-and-conditions")
    }
}