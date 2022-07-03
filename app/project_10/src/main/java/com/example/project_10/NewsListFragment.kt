package com.example.project_10

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

class NewsListFragment : Fragment() {
    private var newsList: MutableList<News> =  mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_news_list, container, false)

        var newsAdapter = NewAdapter(requireContext(),R.layout.activity_list_item,newsList)

        var lvNewsList: ListView = rootView.findViewById(R.id.lv_news_list)

        lvNewsList.adapter = newsAdapter

        return rootView
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
            var news = News(title = titles[i], author = authors[i], imageId = images.getResourceId(i,0))
            newsList.add(news)
        }
    }
}