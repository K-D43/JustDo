package com.example.justdo.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.justdo.Model.Notes


@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("SELECT * FROM Notes WHERE priority=3")
    fun getHighNotes(): LiveData<List<Notes>>
    @Query("SELECT * FROM Notes WHERE priority=1")
    fun getMediumNotes():  LiveData<List<Notes>>
    @Query("SELECT * FROM Notes WHERE priority=2")
    fun getLowNotes():  LiveData<List<Notes>>

    @Delete
    fun deleteNotes(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

}