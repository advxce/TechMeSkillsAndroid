package com.example.testing.task7.cleanArchitecture.data

import android.content.Context
import android.util.Log
import com.example.testing.task7.cleanArchitecture.data.entities.KeepNoteMemoryData
import com.example.testing.task7.cleanArchitecture.data.entities.toData
import com.example.testing.task7.cleanArchitecture.data.entities.toDomain
import com.example.testing.task7.cleanArchitecture.domain.KeepNoteFile
import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain
import kotlinx.serialization.json.Json

import java.io.File

class KeepNoteFileImpl(private val context: Context): KeepNoteFile {


    override fun createFileToSaveNotes(fileName: String): File {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) {
            file.createNewFile()
            Log.i("File", "File created: ${file.absolutePath}")
        }
        return file
    }

    override fun writeAllKeepNotes(list: List<KeepNoteDomain>, fileName: String): File {
        val file = createFileToSaveNotes(fileName)
        val jsonString = Json.encodeToString(list.map { it.toData() })
        file.writeText(jsonString)
        return file

    }

    override fun editKeepNote(newNote: KeepNoteDomain, fileName: String) {
        val notes = getAllKeepNotes(fileName).toMutableList()
        val index = notes.indexOfFirst { it.id == newNote.id }

        if (index != -1) {
            val currentNote = notes[index]
            notes[index] = newNote.copy(id = currentNote.id)
            writeAllKeepNotes(notes, fileName)
        }

    }


    override fun addKeepNote(newNote: KeepNoteDomain, fileName: String) {
        val notes = getAllKeepNotes(fileName).toMutableList()


        notes.add(newNote)
        writeAllKeepNotes(notes, fileName)
    }

    override fun getAllKeepNotes(fileName: String): List<KeepNoteDomain> {
        val file = createFileToSaveNotes(fileName)
        val jsonString = file.readText()
        if (jsonString.isBlank()) {
            Log.i("KeepNoteFile", "File is empty, returning empty list")
            return emptyList()
        }else{

            val list = Json.decodeFromString<List<KeepNoteMemoryData>>(jsonString)
            return list.map { it.toDomain() }

        }
    }

    override fun deleteKeepNote(noteId: Int, fileName: String) {
        val notes = getAllKeepNotes(fileName)
        val newList = notes.filterNot { it.id == noteId }
        writeAllKeepNotes(newList, fileName)
    }


}