package com.example.testing.task6.entity

sealed class Entities {
    data class ButtonData(
        val text:String,
    ): Entities()
    data class PictureData(
        val picture:Int,
        val text:String,
    ): Entities()
    data class AuthorData(
        val name:String,
        val text:String,
    ): Entities()
}