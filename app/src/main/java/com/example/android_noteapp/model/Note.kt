package com.example.android_noteapp.model

class Note (id:String,title:String,content:String,){
    var id: String? = null
    var title: String? = null
    var content: String? = null
    init{
        this.id = id
        this.title = title
        this.content = content
    }
}