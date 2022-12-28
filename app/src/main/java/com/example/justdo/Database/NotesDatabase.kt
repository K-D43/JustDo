package com.example.justdo.Database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.justdo.Dao.NotesDao
import com.example.justdo.Model.Notes
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.util.IllegalFormatCodePointException

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun myNotesDao() : NotesDao

    companion object
    {
        @Volatile
        private var INSTANCE:NotesDatabase ?= null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabaseInstance(context: Context): NotesDatabase{



            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){

                val roomDatabaseInstance= Room.databaseBuilder(context,NotesDatabase::class.java,"Notes").allowMainThreadQueries().build()
                INSTANCE=roomDatabaseInstance
                return INSTANCE!!
            }
        }
    }
}