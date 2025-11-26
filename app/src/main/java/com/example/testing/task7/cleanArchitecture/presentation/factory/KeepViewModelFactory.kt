package com.example.testing.task7.cleanArchitecture.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testing.task7.cleanArchitecture.domain.interactor.KeepNoteInteractor
import com.example.testing.task7.cleanArchitecture.presentation.viewModel.KeepNoteViewModel

class KeepViewModelFactory(private val interactor: KeepNoteInteractor): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(KeepNoteViewModel::class.java)){
            return KeepNoteViewModel(interactor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}