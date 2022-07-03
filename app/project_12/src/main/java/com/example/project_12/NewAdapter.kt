package com.example.project_12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class NewAdapter(context: Context, resource: Int, objects: MutableList<News>) :
    ArrayAdapter<News>(context, resource, objects) {

    private var mNewsData: MutableList<News>

    private var mcontext: Context

    private var resourceId: Int? = null

    private lateinit var listener: OnItemDeleteListener

    init {
        mNewsData = objects
        resourceId = resource
        mcontext = context
    }

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
            viewHolder.ivDelete = view.findViewById(R.id.iv_delete)
            view.tag = viewHolder
        }else{
            // 如果被缓存过，则直接用
            view = convertView
            viewHolder = view.getTag() as ViewHolder
        }


        viewHolder.txTitle.text = news!!.title
        viewHolder.txAuthor.text = news!!.author
        viewHolder.ivImage.setImageResource(news!!.imageId)

        viewHolder.ivDelete.tag = position

        viewHolder.ivDelete.setOnClickListener {
            mNewsData.removeAt(it.tag as Int)
            notifyDataSetChanged()
            listener.onDelete(it.tag as Int)
        }

        return view

    }

    fun setOnItemDeleteListener(listener: OnItemDeleteListener){
        this.listener = listener
    }

    interface OnItemDeleteListener{
        fun onDelete(id: Int)
    }

    class ViewHolder{
        lateinit var txTitle: TextView
        lateinit var txAuthor: TextView
        lateinit var ivImage: ImageView
        lateinit var ivDelete: ImageView
    }
}