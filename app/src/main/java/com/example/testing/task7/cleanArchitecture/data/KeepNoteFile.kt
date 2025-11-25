package com.example.testing.task7.cleanArchitecture.data

import android.content.Context
import android.util.Log
import com.example.testing.task7.cleanArchitecture.data.entities.KeepNoteMemoryData
import kotlinx.serialization.json.Json

import java.io.File

class KeepNoteFile(private val context: Context) {


    fun createFileToSaveNotes(fileName: String): File {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) {
            file.createNewFile()
            Log.i("File", "File created: ${file.absolutePath}")
        }
        return file
    }

    fun writeAllKeepNotes(list: List<KeepNoteMemoryData>, fileName: String): File {
        val file = createFileToSaveNotes(fileName)
        val jsonString = Json.encodeToString(list)
        file.writeText(jsonString)
        return file

    }

    fun editKeepNote(newNote: KeepNoteMemoryData, fileName: String) {
        val notes = getAllKeepNotes(fileName).toMutableList()
        val index = notes.indexOfFirst { it.id == newNote.id }

        if (index != -1) {
            val currentNote = notes[index]
            notes[index] = newNote.copy(id = currentNote.id, title = currentNote.title + 1)
            writeAllKeepNotes(notes, fileName)
        }

    }


    fun addKeepNote(newNote: KeepNoteMemoryData, fileName: String) {
        val notes = getAllKeepNotes(fileName).toMutableList()


        notes.add(newNote)
        writeAllKeepNotes(notes, fileName)
    }

    fun getAllKeepNotes(fileName: String): List<KeepNoteMemoryData> {
        val file = createFileToSaveNotes(fileName)
        if (file.exists()) {

            val jsonString = file.readText()
            val list = Json.decodeFromString<List<KeepNoteMemoryData>>(jsonString)
            return list

        } else {
            Log.i("CheckFile", "File not created")
            return emptyList()
        }
    }

    fun deleteKeepNote(noteId: Int, fileName: String) {
        val notes = getAllKeepNotes(fileName)
        val newList = notes.filterNot { it.id == noteId }
        writeAllKeepNotes(newList, fileName)
    }


}