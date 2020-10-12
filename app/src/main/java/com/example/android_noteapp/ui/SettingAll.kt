package com.example.android_noteapp.ui

import android.view.View
import android.widget.TextView
import com.example.android_noteapp.model.Note
import com.example.android_noteapp.ui.adapter.NoteAdapter


internal object SettingAll {
    var numberView:Int = 0
    var idNoteDt:Int = -1
    var id:Int = -1
    var noteMain:Note = Note("","","")
    var listNote = mutableListOf<Note>()
     lateinit var adapter: NoteAdapter
//    lateinit var viewAddNote:View

}