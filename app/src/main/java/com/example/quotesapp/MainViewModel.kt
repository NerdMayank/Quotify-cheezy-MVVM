package com.example.quotesapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(var context:Context):ViewModel() {
    private var quoteList:Array<Quote> = emptyArray()
    private var index: Int=0
    init {
        quoteList= loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {
        val inputStream=context.assets.open("quote.json")
        val size:Int= inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer, Charsets.UTF_8)
        val gson=Gson()
        return gson.fromJson(json,Array<Quote>::class.java)
    }

     fun getQuote()=quoteList[index]
    fun nextQuote(){
        index++
        index%=quoteList.size
    }
    fun previousquote(){
        index--
        index=(index+quoteList.size)%quoteList.size
    }

}