package com.example.noteapp.repositories

import com.example.noteapp.db.AppDatabase
import com.example.noteapp.entities.Note

class NoteRepository(private val db: AppDatabase) {

    suspend fun insertNote(note: Note) = db.noteDao().insertNote(note)
    suspend fun updateNote(note: Note) = db.noteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.noteDao().deleteNote(note)

    fun getAllNotes() = db.noteDao().getAllNotes()
}