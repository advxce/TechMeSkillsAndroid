package com.example.testing.task7.cleanArchitecture.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testing.task7.cleanArchitecture.domain.interactor.KeepNoteInteractor
import com.example.testing.task7.cleanArchitecture.presentation.entity.KeepNoteUI
import com.example.testing.task7.cleanArchitecture.presentation.entity.toDomain
import com.example.testing.task7.cleanArchitecture.presentation.entity.toUI

class KeepNoteViewModel (
    private val interactor: KeepNoteInteractor
): ViewModel() {

    private val _keepNotes = MutableLiveData<List<KeepNoteUI>>()
    val keepNotes: LiveData<List<KeepNoteUI>>
        get() = _keepNotes

    fun getAllNote():List<KeepNoteUI>{
        val listNoteUI = interactor.getAllNote(FILE_NAME).map { it.toUI() }
        _keepNotes.value = listNoteUI
        return listNoteUI
    }

    fun addNote(note: KeepNoteUI){
        interactor.addNote(note.toDomain(), FILE_NAME)
    }

    fun deleteNote(noteId:Int){
        interactor.deleteNote(noteId, FILE_NAME)
    }

    fun editNote(note: KeepNoteUI){
        interactor.editNote(note.toDomain(), FILE_NAME)
    }

    companion object{
        const val FILE_NAME = "notes.json"
    }

}