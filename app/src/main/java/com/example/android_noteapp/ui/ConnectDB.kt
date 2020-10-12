package com.example.android_noteapp.ui

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper


class ConnectDB(context: Context?, name: String?, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    // query sql : Insert , update, delete .....
    fun QueryData(sql: String?) {
        val database = writableDatabase
        database.execSQL(sql)
    }

    // select db
    fun getData(sql: String?): Cursor {
        val database = readableDatabase
        return database.rawQuery(sql, null)
    }

    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    fun updateNote(id: Int, title: String, content: String): Int {

        val mDb = this.writableDatabase
        val args = ContentValues()
        args.put("title", title)
        args.put("content", content)
        return mDb.update("Note", args, "Id ="+ id, null)
    }
}
