package com.example.noteapp_mvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteapp_mvvm.Database.NotesDatabase
import com.example.noteapp_mvvm.Database.NotesRepository
import com.example.noteapp_mvvm.Model.Notes

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    val repository: NotesRepository

    init {
        //ye Repository class ko call kary ga
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes) {
        repository.InsertNotes(notes)
    }

    fun getAllNotes(): LiveData<List<Notes>> = repository.getAllNotes()
    fun getLowNotes():LiveData<List<Notes>> = repository.getLowNotes()
    fun getMediumNotes():LiveData<List<Notes>> = repository.getMediumNotes()
    fun getHighNotes():LiveData<List<Notes>> = repository.getHighNotes(

    )
    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }

}