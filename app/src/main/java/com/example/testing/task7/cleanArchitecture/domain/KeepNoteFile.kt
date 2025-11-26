package com.example.testing.task7.cleanArchitecture.domain

import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain
import java.io.File

interface KeepNoteFile {
    fun createFileToSaveNotes(fileName: String): File
    fun writeAllKeepNotes(list: List<KeepNoteDomain>, fileName: String): File
    fun editKeepNote(newNote: KeepNoteDomain, fileName: String)
    fun addKeepNote(newNote: KeepNoteDomain, fileName: String)
    fun getAllKeepNotes(fileName: String): List<KeepNoteDomain>
    fun deleteKeepNote(noteId: Int, fileName: String)
}