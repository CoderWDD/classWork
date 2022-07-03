package com.example.project_09

import android.annotation.SuppressLint
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var newsList: MutableList<News> =  mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        var newsAdapter: NewAdapter = NewAdapter(this,R.layout.activity_list_item,newsList)

        var recyclerView: RecyclerView = findViewById(R.id.lv_news_list)

        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = newsAdapter

    }

    @SuppressLint("ResourceType")
    private fun initData(){
        var length: Int

        var titles = resources.getStringArray(R.array.titles)
        var authors = resources.getStringArray(R.array.authors)

        var images: TypedArray = resources.obtainTypedArray(R.array.images)

        if (titles.size > authors.size) {
            length = authors.size
        }else{
            length = titles.size
        }

        for (i in 0 until  (length - 1)){
            var news: News = News(title = titles[i], author = authors[i], imageId = images.getResourceId(i,0))
            newsList.add(news)
        }
    }
}