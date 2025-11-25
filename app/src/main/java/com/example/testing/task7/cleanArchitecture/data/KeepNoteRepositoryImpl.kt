package com.example.testing.task7.cleanArchitecture.data

import android.content.Context
import com.example.testing.task7.cleanArchitecture.data.entities.KeepNoteMemoryData
import com.example.testing.task7.cleanArchitecture.data.entities.toData
import com.example.testing.task7.cleanArchitecture.data.entities.toDomain
import com.example.testing.task7.cleanArchitecture.domain.KeepNoteRepository
import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain

class KeepNoteRepositoryImpl(
    private val context:Context,
    private var keepNoteFile: KeepNoteFile
) : KeepNoteRepository {

    init {
        keepNoteFile = KeepNoteFile(context)
    }

    override fun getAllKeepNotes(fileName: String): List<KeepNoteDomain> {
        val list = keepNoteFile.getAllKeepNotes(fileName)
        return list.map { it.toDomain() }
    }

    override fun addKeepNote(
        newNote: KeepNoteDomain,
        fileName: String
    ) {
        keepNoteFile.addKeepNote(newNote.toData(), fileName)
    }

    override fun deleteKeepNote(noteId: Int, fileName: String) {
        keepNoteFile.deleteKeepNote(noteId, fileName)
    }

    override fun editKeepNote(
        keepNote: KeepNoteDomain,
        fileName: String
    ) {
        keepNoteFile.editKeepNote(keepNote.toData(), fileName)
    }
}