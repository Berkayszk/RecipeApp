package com.example.recipeapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private var _binding : FragmentWebViewBinding?=null
    private val binding get() = _binding!!
    private val args : WebViewFragmentArgs by navArgs()
    private lateinit var recipe : com.example.recipeapp.model.Result

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipe = args.recipe
        setUpWebView()
    }

    private fun setUpWebView(){
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(recipe.href)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}