package com.example.project_11

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

    // 如果 convertView 不为空，则表示已经被缓存过
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var news: News? = getItem(position)

        var view: View

        var viewHolder: ViewHolder

        if (convertView == null){
            // 如果没有被缓存过，则生成一个，并将其放到viewHolder中缓存
            view = LayoutInflater.from(context).inflate(resourceId!!,parent,false)

            viewHolder = ViewHolder()

            viewHolder.txTitle = view.findViewById(R.id.tx_title)
            viewHolder.txAuthor = view.findViewById(R.id.tv_subtitle)
            viewHolder.ivImage = view.findViewById(R.id.iv_image)
            view.tag = viewHolder
        }else{
            // 如果被缓存过，则直接用
            view = convertView
            viewHolder = view.getTag() as ViewHolder
        }


        viewHolder.txTitle.text = news!!.title
        viewHolder.txAuthor.text = news!!.author
        viewHolder.ivImage.setImageResource(news!!.imageId)

        return view

    }


    class ViewHolder{
        lateinit var txTitle: TextView
        lateinit var txAuthor: TextView
        lateinit var ivImage: ImageView
    }
}