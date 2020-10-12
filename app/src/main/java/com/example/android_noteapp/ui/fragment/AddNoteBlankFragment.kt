package com.example.android_noteapp.ui.fragment

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.android_noteapp.R
import com.example.android_noteapp.model.Note
import com.example.android_noteapp.ui.SettingAll
import kotlinx.android.synthetic.main.fragment_add_note_blank.view.*


class AddNoteBlankFragment : Fragment() {
//    lateinit var edtTitle:EditText
//    lateinit var edtContent:EditText
    companion object {
        lateinit var edtTitle:EditText
        lateinit var edtContent:EditText
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view  = inflater.inflate(R.layout.fragment_add_note_blank, container, false);
        HandleEvent(view)
        HandleDefault(view)
        // Inflate the layout for this fragment
        return view
    }
    fun HandleEvent(view: View){
        edtContent = view.findViewById<EditText>(R.id.edtContent)
        edtTitle = view.findViewById<EditText>(R.id.edtTitle)
        if(HomeBlankFragment.checkAdd == 0){
            edtTitle.setText("")
            edtContent.setText("")

        }

        view.imgBackArow.setOnClickListener {
            if(HomeBlankFragment.checkAdd == 0){
                HomeBlankFragment.checkAdd = -1
                HomeBlankFragment.db!!.QueryData("INSERT INTO Note VALUES (null,'" + edtTitle.text.toString() + "','" + edtContent.text.toString() + "');");

                HomeBlankFragment.dbTableNote = HomeBlankFragment.db!!.getData("SELECT  * FROM Note ORDER BY ID DESC")
                while (HomeBlankFragment.dbTableNote!!.moveToNext()) {
                    val id: String = HomeBlankFragment.dbTableNote!!.getString(0)
                    val title: String = HomeBlankFragment.dbTableNote!!.getString(1)
                    val content: String = HomeBlankFragment.dbTableNote!!.getString(2)
                    if(title == edtTitle.text.toString() && content == edtContent.text.toString()){
                        SettingAll.listNote.add(
                            Note(
                                id.toString(),
                                edtTitle.text.toString(),
                                edtContent.text.toString()
                            )
                        )
                        break
                    }
                }


                SettingAll.adapter.notifyDataSetChanged()
//                HomeBlankFragment.db.QueryData("INSERT INTO SinhVien VALUES (null,'28/11/2017','Android','12:30','90','A201s');");

            }
            if(SettingAll.numberView == 1){
                SettingAll.listNote[SettingAll.id].title = edtTitle.text.toString()
                SettingAll.listNote[SettingAll.id].content = edtContent.text.toString()
                SettingAll.adapter.notifyDataSetChanged()
                SettingAll.numberView = 0
                HomeBlankFragment.db!!.updateNote(SettingAll.noteMain.id!!.toInt(), edtTitle.text.toString(),
                    edtContent.text.toString())
            }

            edtTitle.setText("")
            edtContent.setText("")

            Navigation.findNavController(view).navigate(R.id.action_addNoteBlankFragment_to_homeBlankFragment)
        }

    }
    fun HandleDefault(view: View){
        if(HomeBlankFragment.checkAdd == 0){
            view.edtTitle.setText("")
            view.edtContent.setText("")
        }
        else{
            view.edtTitle.setText(SettingAll.noteMain.title)
            view.edtContent.setText(SettingAll.noteMain.content)
        }
    }


}