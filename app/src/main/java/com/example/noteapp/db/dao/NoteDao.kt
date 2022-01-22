package com.example.noteapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.entities.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("select * from notes order by id desc")
    fun getAllNotes(): LiveData<List<Note>>
}