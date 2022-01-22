package com.example.noteapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.entities.Note
import com.example.noteapp.repositories.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {
    fun addNote(note: Note) = viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun deleteNote(note: Note) = viewModelScope.launch {
            noteRepository.deleteNote(note)
        }

    fun updateNote(note: Note) = viewModelScope.launch {
            noteRepository.updateNote(note)
        }


    fun getAllNote() = noteRepository.getAllNotes()

}
