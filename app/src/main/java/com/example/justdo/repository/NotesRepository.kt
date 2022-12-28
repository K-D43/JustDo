package com.example.justdo.repository

import androidx.lifecycle.LiveData
import com.example.justdo.Dao.NotesDao
import com.example.justdo.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes():LiveData<List<Notes>>{
        return dao.getNotes()
    }
    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun getHighNotes():LiveData<List<Notes>> = dao.getHighNotes()
    fun getMediumNotes():LiveData<List<Notes>> = dao.getMediumNotes()
    fun getLowNotes():LiveData<List<Notes>> = dao.getLowNotes()

    fun deleteNotes(notes: Notes){
        dao.deleteNotes(notes)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }


}