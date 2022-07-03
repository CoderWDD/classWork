package com.example.project_09

data class News(val title: String,val author: String,val content: String = "",val imageId: Int){
    private var mTitle:String = title
    private var mAuthor:String = author
    private var mContent:String = content
    private var mImageId:Int = imageId

}