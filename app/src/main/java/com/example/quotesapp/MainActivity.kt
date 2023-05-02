package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel=ViewModelProvider(this, MainViewModelFactory(applicationContext))[MainViewModel::class.java]
        setQuote(mainViewModel.getQuote())
    }

    private fun setQuote(quote: Quote) {
        binding.quoteText.text=quote.text
        binding.quoteAuthor.text=quote.author
    }

    fun onPrevious(view: View) {
       mainViewModel.previousquote()
        setQuote(mainViewModel.getQuote())
    }
    fun onNext(view: View) {
        mainViewModel.nextQuote()
        setQuote(mainViewModel.getQuote())
    }
    fun onShare(view: View) {}
}