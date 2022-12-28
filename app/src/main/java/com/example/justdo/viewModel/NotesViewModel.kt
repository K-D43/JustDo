package com.example.justdo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.justdo.Database.NotesDatabase
import com.example.justdo.Model.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(val db:NotesDatabase): ViewModel(){


    fun addNotes(notes: Notes)= CoroutineScope(Dispatchers.Main).launch{
        db.myNotesDao().insertNotes(notes)
    }

    fun getNotes():LiveData<List<Notes>> = db.myNotesDao().getNotes()

    fun deleteNotes(notes: Notes)=CoroutineScope(Dispatchers.Main).launch { db.myNotesDao().deleteNotes(notes) }

    fun updateNotes(notes: Notes){
        db.myNotesDao().updateNotes(notes)
    }

}