package com.example.testing.task7.cleanArchitecture.domain.repository

import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain

interface KeepNoteRepository {

    fun getAllKeepNotes(fileName:String):List<KeepNoteDomain>

    fun addKeepNote(newNote: KeepNoteDomain, fileName: String)

    fun deleteKeepNote(noteId: Int, fileName: String)

    fun editKeepNote(keepNote: KeepNoteDomain, fileName: String)

}