package com.example.android_noteapp.ui.fragment

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_noteapp.R
import com.example.android_noteapp.model.Note
import com.example.android_noteapp.ui.ConnectDB
import com.example.android_noteapp.ui.SettingAll
import com.example.android_noteapp.ui.adapter.NoteAdapter
import kotlinx.android.synthetic.main.fragment_home_blank.*
import kotlinx.android.synthetic.main.fragment_home_blank.view.*


class HomeBlankFragment : Fragment() {
    lateinit var drawerLayout: DrawerLayout
    private lateinit var adapter:NoteAdapter


    companion object {
        lateinit var adapter:NoteAdapter
        private var v: View? = null
        var db: ConnectDB? = null
        var checkAdd:Int = -1
        var dbTableNote: Cursor? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v  = inflater.inflate(R.layout.fragment_home_blank, container, false);

        HandleEvent(v!!)

        HandleDrawer(v!!)
        handleDB(v!!)
        HandleRCVData(v!!)
        // Inflate the layout for this fragment
        return v
    }

    fun HandleEvent(view: View) {
//        view.btnFloatingAction.setOnClickListener {
////            Navigation.findNavController(view).navigate(R.id.action_homeBlankFragment_to_noteContentBlankFragment)
//            print("alo alo btn ")
//        }
        view.btnFloatingAction.setOnClickListener {
            checkAdd = 0
            Navigation.findNavController(view).navigate(R.id.action_homeBlankFragment_to_addNoteBlankFragment)
        }
        view.sortHome.setOnClickListener {
            print("image sort home ")
            Toast.makeText(context, "This is a message2", Toast.LENGTH_SHORT).show();
//            Navigation.findNavController(view).navigate(R.id.action_homeBlankFragment_to_noteContentBlankFragment2)
        }
        view.searchHome.setOnClickListener {
            print("image sort home ")
            Toast.makeText(context, "This is a message22", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view).navigate(R.id.action_homeBlankFragment_to_searchBlankFragment)
        }
        view.loginHome.setOnClickListener {
            print("image sort home ")
            Toast.makeText(context, "This is a message3", Toast.LENGTH_SHORT).show();
        }


        view.lnThonBao.setOnClickListener{
            print("image sort home ")
            Toast.makeText(context, "This is a message4", Toast.LENGTH_SHORT).show();
        }
        view.lnLoiNhac.setOnClickListener{
            print("image sort home ")
            Toast.makeText(context, "This is a message5", Toast.LENGTH_SHORT).show();
        }
        view.lnTaoMau.setOnClickListener{
            print("image sort home ")
            Toast.makeText(context, "This is a message6", Toast.LENGTH_SHORT).show();
        }
        view.lnLuuTru.setOnClickListener{
            print("image sort home ")
            Toast.makeText(context, "This is a message7", Toast.LENGTH_SHORT).show();
        }
        view.lnThungRac.setOnClickListener{
            print("image sort home ")
        }
        view.lnCaiDat.setOnClickListener{
            print("image sort home ")
        }
        view.lnTroGiup.setOnClickListener{
            print("image sort home ")
        }
    }

    fun HandleRCVData(view: View){

        SettingAll.adapter = NoteAdapter(view.context)
            val rcv = view.findViewById<RecyclerView>(R.id.rcv_Note)
            rcv.hasFixedSize()
            rcv.layoutManager = GridLayoutManager(view.context, 2)
            rcv.adapter = SettingAll.adapter

//        SettingAll.adapter = adapter

        SettingAll.adapter.setListData(SettingAll.listNote)
        SettingAll.adapter.notifyDataSetChanged()

        Toast.makeText(view.context, "RCV CHANGE", Toast.LENGTH_LONG).show();
    }

    fun handleDB(view: View) {
        if(SettingAll.listNote.isEmpty()){
            db = ConnectDB(view.context, "Baihoc.sqlite", null, 1)
            db!!.QueryData("CREATE TABLE IF NOT EXISTS Note(Id INTEGER PRIMARY KEY AUTOINCREMENT, title nvarchar,content nvarchar)")


            dbTableNote = db!!.getData("select * from Note")
            while (dbTableNote!!.moveToNext()) {
                val id: String = dbTableNote!!.getString(0)
                val title: String = dbTableNote!!.getString(1)
                val content: String = dbTableNote!!.getString(2)
                SettingAll.listNote.add(Note(id, title, content))
            }
        }

    }


    fun HandleDrawer(view: View){
        drawerLayout = view.findViewById(R.id.drawer_layout)
        view.drawerHome.setOnClickListener {
            print("image sort home ")
            openDrawer(drawerLayout)
        }
    }
    fun openDrawer(drawerLayout: DrawerLayout){
        drawerLayout.openDrawer(GravityCompat.START)
    }

    fun closeDrawer(drawerLayout: DrawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onPause() {
        super.onPause()
        closeDrawer(drawer_layout)
    }

//        fun handleNavigate(){
//            val extras = FragmentNavigatorExtras(
//                img_nvg_searchHOME to "img_nvg_searchHOME"
//            )
//            findNavController().navigate(R.id.action_homeBlankFragment_to_searchBlankFragment, null, null, extras)
//
//        }
//        view.img_nvg_searchHOME.setOnClickListener {
//            val extras = FragmentNavigatorExtras(
//                img_nvg_searchHOME to "img_nvg_searchHOME"
//            )
//            findNavController().navigate(R.id.action_homeBlankFragment_to_searchBlankFragment, null, null, extras)
//        }

}