package com.example.justdo.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.justdo.Model.Notes


@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

}