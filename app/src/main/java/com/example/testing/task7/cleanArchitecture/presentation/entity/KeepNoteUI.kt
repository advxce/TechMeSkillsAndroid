package com.example.testing.task7.cleanArchitecture.presentation.entity

import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain

data class KeepNoteUI(
    val id: Int,
    val title: String,
    val description: String,
    val date:String = ""
)

fun KeepNoteDomain.toUI(): KeepNoteUI{
    return KeepNoteUI(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
    )
}

fun KeepNoteUI.toDomain(): KeepNoteDomain{
    return KeepNoteDomain(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
    )
}