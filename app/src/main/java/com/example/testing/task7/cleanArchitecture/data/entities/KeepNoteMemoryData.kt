package com.example.testing.task7.cleanArchitecture.data.entities

import android.os.Parcel
import android.os.Parcelable
import com.example.testing.task7.cleanArchitecture.domain.entity.KeepNoteDomain
import kotlinx.serialization.Serializable


@Serializable
data class KeepNoteMemoryData(
    val id: Int,
    val title: String,
    val description: String,
    val date:String
)

fun KeepNoteMemoryData.toDomain(): KeepNoteDomain{
    return KeepNoteDomain(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
    )
}

fun KeepNoteDomain.toData(): KeepNoteMemoryData{
    return KeepNoteMemoryData(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
    )
}