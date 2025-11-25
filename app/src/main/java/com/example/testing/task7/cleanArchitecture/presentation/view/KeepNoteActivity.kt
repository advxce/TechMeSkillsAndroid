package com.example.testing.task7.cleanArchitecture.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.databinding.ActivityKeepNoteBinding
import com.example.testing.task7.cleanArchitecture.data.KeepNoteFile
import com.example.testing.task7.cleanArchitecture.data.entities.KeepNoteMemoryData
import com.example.testing.task7.cleanArchitecture.presentation.entity.KeepNoteUI
import com.example.testing.task7.cleanArchitecture.presentation.viewModel.KeepNoteViewModel

class KeepNoteActivity: AppCompatActivity() {

    private var binding: ActivityKeepNoteBinding? = null

    private val keepNoteFile = KeepNoteFile(context = this)

    private val keepNoteViewModel: KeepNoteViewModel by viewModels()

    val file = "user.json"

    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeepNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        keepNoteViewModel.getAllNote()

        keepNoteViewModel.keepNotes.observe(this) {
            Log.i("CheckFile", "viewModel ${it}")
        }

        binding?.let {
            it.addNotes.setOnClickListener {
                keepNoteViewModel.addNote(KeepNoteUI(id = 1, title = "title", description = "description"))

                Log.i("CheckFile", "activity: write")
            }
            it.getNotes.setOnClickListener {

                Log.i("CheckFile", "activity: ${keepNoteViewModel.getAllNote()}")
            }
            it.deleteNote.setOnClickListener {
                keepNoteViewModel.deleteNote(2)
            }

            it.editNote.setOnClickListener {
                keepNoteViewModel.editNote(KeepNoteUI(id = 1, title = "title4", description = "description"))
            }
        }


    }

}