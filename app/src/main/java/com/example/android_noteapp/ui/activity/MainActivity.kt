package com.example.android_noteapp.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_noteapp.R
import com.example.android_noteapp.ui.IOnBackPressed
import com.example.android_noteapp.ui.SettingAll
import com.example.android_noteapp.ui.adapter.NoteAdapter
import com.example.android_noteapp.ui.fragment.AddNoteBlankFragment
import com.example.android_noteapp.ui.fragment.HomeBlankFragment
import kotlinx.android.synthetic.main.fragment_add_note_blank.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//
//        val button1 = findViewById<ImageView>(R.id.imgMenuItem)
//        button1.setOnClickListener {
//                //Creating the instance of PopupMenu
//                val popup = PopupMenu(this@MainActivity, button1)
//                //Inflating the Popup using xml file
//                popup.menuInflater
//                    .inflate(R.menu.menu1, popup.menu)
//
//                //registering popup with OnMenuItemClickListener
//                popup.setOnMenuItemClickListener { item ->
//                    Toast.makeText(
//                        this@MainActivity,
//                        "You Clicked : " + item.title,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    true
//                }
//                popup.show() //showing popup menu
//
//        }
    }


    override fun onBackPressed() {
        super.onBackPressed()

        if(SettingAll.numberView == 1){
            SettingAll.numberView = 0

            SettingAll.listNote[SettingAll.id].title = AddNoteBlankFragment.edtTitle.text.toString()
            SettingAll.listNote[SettingAll.id].content = AddNoteBlankFragment.edtContent.text.toString()
            SettingAll.adapter.notifyDataSetChanged()
            AddNoteBlankFragment.edtTitle.setText("")
            AddNoteBlankFragment.edtContent.setText("")
        }
//        SettingAll.noteMain.id = ""
//        SettingAll.noteMain.content = ""
//        SettingAll.noteMain.title = ""
    }
}