package com.example.project_09

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(context: Context, resource: Int, objects: MutableList<News>) :
    RecyclerView.Adapter<NewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvAuthor: TextView
        var ivImage: ImageView
        init {
            tvTitle = itemView.findViewById(R.id.tx_title)
            tvAuthor = itemView.findViewById(R.id.tv_subtitle)
            ivImage = itemView.findViewById(R.id.iv_image)
        }
    }

    private var mNewsData: List<News>

    private var mcontext: Context

    private var resourceId: Int? = null

    init {
        mNewsData = objects
        resourceId = resource
        mcontext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(mcontext).inflate(resourceId!!, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var news: News = mNewsData[position]
        holder.tvTitle.text = news.title
        holder.tvAuthor.text = news.author

        if (news.imageId != -1){
            holder.ivImage.setImageResource(news.imageId)
        }
    }

    override fun getItemCount(): Int {
        return mNewsData.size
    }
}