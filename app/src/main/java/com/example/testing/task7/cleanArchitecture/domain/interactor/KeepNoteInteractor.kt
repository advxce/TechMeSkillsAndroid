package com.example.testing.task7.cleanArchitecture.domain.interactor

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.testing.task7.cleanArchitecture.domain.KeepNoteRepository
import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface KeepNoteInteractor{
    fun deleteNote(noteId:Int, fileName:String)
    fun addNote(note: KeepNoteDomain,fileName:String)
    fun getAllNote(fileName:String):List<KeepNoteDomain>
    fun editNote(note: KeepNoteDomain, fileName:String)
}

class KeepNoteInteractorImpl(
    private val repository: KeepNoteRepository
): KeepNoteInteractor {
    override fun deleteNote(noteId: Int, fileName: String) {
        repository.deleteKeepNote(noteId, fileName)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDate():String{
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formattedDateTime = currentDateTime.format(formatter)
        return formattedDateTime
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun addNote(note: KeepNoteDomain, fileName:String) {

        val newNote = note.copy(date = getDate())
        repository.addKeepNote(newNote, fileName)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAllNote(fileName: String): List<KeepNoteDomain> {

       return repository.getAllKeepNotes(fileName).map { it.copy(date = getDate())  }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun editNote(
        note: KeepNoteDomain,
        fileName: String
    ) {
        val editKeepNote = note.copy(date = getDate())
        repository.editKeepNote(editKeepNote, fileName)
    }
}