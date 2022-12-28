package com.example.justdo.repository

import androidx.lifecycle.LiveData
import com.example.justdo.Dao.NotesDao
import com.example.justdo.Model.Notes

class NotesRepository(val dao: NotesDao) {

    suspend fun getAllNotes():LiveData<List<Notes>>{
        return dao.getNotes()
    }
    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(notes: Notes){
        dao.deleteNotes(notes)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }


}