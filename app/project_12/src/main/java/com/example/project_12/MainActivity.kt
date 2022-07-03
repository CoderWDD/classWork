package com.example.project_12

import android.annotation.SuppressLint
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.project_12.NewAdapter.OnItemDeleteListener
import java.util.*

class MainActivity : AppCompatActivity() {
    private var newsList: MutableList<News> =  mutableListOf()

    private lateinit var swipe: SwipeRefreshLayout

    private lateinit var titles: Array<String>
    private lateinit var authors: Array<String>

    private lateinit var images: TypedArray

    private lateinit var newsAdapter: NewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        newsAdapter = NewAdapter(this,R.layout.activity_list_item,newsList)

        var lvNewsList: ListView = findViewById(R.id.lv_news_list)

        newsAdapter.setOnItemDeleteListener(listener = object : OnItemDeleteListener {
            override fun onDelete(id: Int) {
                removeData(id)
            }
        })

        lvNewsList.adapter = newsAdapter

        swipe = findViewById<SwipeRefreshLayout>(R.id.swipe)

        swipe.setOnRefreshListener {
            refreshData()
        }
    }

    private fun refreshData(){
        var random: Random = Random()

        val index: Int = random.nextInt(19)

        var news: News = News(titles[index], author = authors[index], imageId = images.getResourceId(index,-1   ))

        newsAdapter.insert(news,0)
        newsAdapter.notifyDataSetChanged()

        swipe.isRefreshing = false
    }

    private fun removeData(id: Int){
        newsList.removeAt(id)
        newsAdapter.notifyDataSetChanged()
    }

    @SuppressLint("ResourceType")
    private fun initData(){
        var length: Int

        titles = resources.getStringArray(R.array.titles)
        authors = resources.getStringArray(R.array.authors)

        images = resources.obtainTypedArray(R.array.images)

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