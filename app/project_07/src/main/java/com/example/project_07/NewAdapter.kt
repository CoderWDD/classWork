package com.example.project_07

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class NewAdapter(context: Context, resource: Int, objects: MutableList<News>) :
    ArrayAdapter<News>(context, resource, objects) {

    private var mNewsData: List<News>

    private var mcontext: Context

    private var resourceId: Int? = null

    init {
        mNewsData = objects
        resourceId = resource
        mcontext = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var news: News? = getItem(position)

        var view: View = LayoutInflater.from(context).inflate(resourceId!!,parent,false)

        var tvTitle: TextView = view.findViewById(R.id.tx_title)
        var tvAuthor: TextView = view.findViewById(R.id.tv_subtitle)
        var ivImage: ImageView = view.findViewById(R.id.iv_image)

        tvTitle.text = news!!.title
        tvAuthor.text = news!!.author
        ivImage.setImageResource(news!!.imageId)

        return view

    }
}