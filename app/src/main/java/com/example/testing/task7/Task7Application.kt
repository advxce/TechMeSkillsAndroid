package com.example.testing.task7

import android.app.Application
import com.example.testing.task7.cleanArchitecture.data.KeepNoteFileImpl
import com.example.testing.task7.cleanArchitecture.data.KeepNoteRepositoryImpl
import com.example.testing.task7.cleanArchitecture.domain.interactor.KeepNoteInteractorImpl

class Task7Application: Application(){

    val keepNoteFile by lazy {
        KeepNoteFileImpl(this)
    }
    val keepNoteRepository by lazy {
        KeepNoteRepositoryImpl(keepNoteFile)
    }
    val keepNoteInteractor by lazy {
        KeepNoteInteractorImpl(keepNoteRepository)
    }

}