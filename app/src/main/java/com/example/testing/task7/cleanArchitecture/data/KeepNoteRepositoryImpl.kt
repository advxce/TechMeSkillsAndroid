package com.example.testing.task7.cleanArchitecture.data


import com.example.testing.task7.cleanArchitecture.domain.KeepNoteFile
import com.example.testing.task7.cleanArchitecture.domain.repository.KeepNoteRepository
import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain

class KeepNoteRepositoryImpl(
    private var keepNoteFile: KeepNoteFile
) : KeepNoteRepository {


    override fun getAllKeepNotes(fileName: String): List<KeepNoteDomain> {
        val list = keepNoteFile.getAllKeepNotes(fileName)
        return list
    }

    override fun addKeepNote(
        newNote: KeepNoteDomain,
        fileName: String
    ) {
        keepNoteFile.addKeepNote(newNote, fileName)
    }

    override fun deleteKeepNote(noteId: Int, fileName: String) {
        keepNoteFile.deleteKeepNote(noteId, fileName)
    }

    override fun editKeepNote(
        keepNote: KeepNoteDomain,
        fileName: String
    ) {
        keepNoteFile.editKeepNote(keepNote, fileName)
    }
}