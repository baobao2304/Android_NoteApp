package com.example.android_noteapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.android_noteapp.R
import com.example.android_noteapp.model.Note
import com.example.android_noteapp.ui.SettingAll
import kotlinx.android.synthetic.main.rcv_item_note.view.*


class NoteAdapter(private val context: Context): RecyclerView.Adapter<NoteAdapter.NotesViewHolder>() {
    //    lateinit var _context:Context
    private var listPR = mutableListOf<Note>()

    fun setListData(data:MutableList<Note>){
        listPR = data
    }
    override fun getItemCount(): Int {
        if (listPR.size > 0)
            return listPR.size
        else
            return 0
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):NotesViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.rcv_item_note,parent,false)
//        var prvhd:ProductsViewHolder =  ProductsViewHolder(view)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val itemPr:Note = listPR[position]
        holder.bindView(itemPr,position)
    }

    inner class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        fun bindView(itemNt:Note,position: Int){
//            Glide.with(context).load(itemPr._imageUrl).into(itemView.imageMainPR)
            itemView.txtTitleNote.text = itemNt.title
            itemView.txtContentNote.text = itemNt.content
            itemView.setOnClickListener {
                SettingAll.numberView = 1
                SettingAll.id = position
                SettingAll.noteMain.id = itemNt.id
                SettingAll.noteMain.content = itemNt.content
                SettingAll.noteMain.title = itemNt.title
                Navigation.findNavController(itemView).navigate(R.id.action_homeBlankFragment_to_addNoteBlankFragment)
            }
        }


    }
}