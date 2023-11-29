package com.example.noteapp_mvvm.Database

import androidx.lifecycle.LiveData
import com.example.noteapp_mvvm.Model.Notes
import com.example.noteapp_mvvm.Model.NotesDao

class NotesRepository(val dao: NotesDao) {
    fun getAllNotes(): LiveData<List<Notes>> = dao.getNotes()

    fun getLowNotes(): LiveData<List<Notes>> = dao.getLowNotes()
    fun getMediumNotes(): LiveData<List<Notes>> =dao.getMediumNotes()
    fun getHighNotes(): LiveData<List<Notes>> = dao.getHighNotes()


    fun InsertNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }
}