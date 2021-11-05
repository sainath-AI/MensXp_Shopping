package com.masai.sainath.mensxp.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.masai.sainath.mensxp.databinding.FragmentFeedBinding
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {


    lateinit var binding: FragmentFeedBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webview2.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }

        webview2.loadUrl("https://www.mensxp.com/technology/news.html")
        webview2.settings.javaScriptEnabled = true
        webview2.settings.allowContentAccess = true
        webview2.settings.domStorageEnabled = true
        webview2.settings.useWideViewPort = true

    }
}