package com.example.noteapp_mvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp_mvvm.Model.Notes
import com.example.noteapp_mvvm.Model.NotesDao

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun myNotesDao(): NotesDao

    companion object {
        @Volatile
        var Instances: NotesDatabase? = null
        fun getDatabaseInstance(context: Context): NotesDatabase {
            val tempInstances = Instances
            if (tempInstances != null) {
                return tempInstances
            }
            synchronized(this) {
                //Database create
                val roomDatabaseInstances =
                    Room.databaseBuilder(context, NotesDatabase::class.java, "Notes")
                        .allowMainThreadQueries().build()
                Instances = roomDatabaseInstances
                return return roomDatabaseInstances
            }
        }
    }
}