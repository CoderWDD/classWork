package com.example.project_07

import android.annotation.SuppressLint
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private var newsList: MutableList<News> =  mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        val newsAdapter: NewAdapter = NewAdapter(this,R.layout.activity_list_item,newsList)
        val lvNewsList: ListView = findViewById(R.id.lv_news_list)
        lvNewsList.adapter = newsAdapter
    }

    @SuppressLint("ResourceType")
    private fun initData(){
        val length: Int
        val titles = resources.getStringArray(R.array.titles)
        val authors = resources.getStringArray(R.array.authors)
        val images: TypedArray = resources.obtainTypedArray(R.array.images)
        length = if (titles.size > authors.size) {
            authors.size
        }else{
            titles.size
        }
        for (i in 0 until  (length - 1)){
            val news: News = News(title = titles[i], author = authors[i], imageId = images.getResourceId(i,0))
            newsList.add(news)
        }
    }
}