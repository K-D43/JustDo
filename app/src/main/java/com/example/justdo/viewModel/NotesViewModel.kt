package com.example.justdo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.justdo.Database.NotesDatabase
import com.example.justdo.Model.Notes
import com.example.justdo.repository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application){


    val repository:NotesRepository

    init {
        val dao=NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository=NotesRepository(dao)
    }


    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun getNotes():LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(notes: Notes)=CoroutineScope(Dispatchers.Main).launch { db.myNotesDao().deleteNotes(notes) }

    fun updateNotes(notes: Notes){
        db.myNotesDao().updateNotes(notes)
    }

}