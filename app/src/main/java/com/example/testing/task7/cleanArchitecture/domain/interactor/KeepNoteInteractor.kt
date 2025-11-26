package com.example.testing.task7.cleanArchitecture.domain.interactor

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.testing.task7.cleanArchitecture.domain.repository.KeepNoteRepository
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




    private fun getId():Int{
        val list = repository.getAllKeepNotes("notes.json")
        val listWithId = list.map { it.id }.toSet()
        for(i in 1..list.size){
            if(!listWithId.contains(i)){
                return i
            }
        }
        return list.size
    }



    override fun deleteNote(noteId: Int, fileName: String) {

        repository.deleteKeepNote(noteId, fileName)
    }




    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDate():String{
        val currentDate = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formattedDateTime =currentDate.format(formatter)
        return formattedDateTime
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun addNote(note: KeepNoteDomain, fileName:String) {
        val id = getId()
        val newNote = note.copy(id =id, date = getDate())
        repository.addKeepNote(newNote, fileName)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAllNote(fileName: String): List<KeepNoteDomain> {

       return repository.getAllKeepNotes(fileName)
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