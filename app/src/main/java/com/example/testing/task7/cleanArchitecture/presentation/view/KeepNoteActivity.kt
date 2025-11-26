package com.example.testing.task7.cleanArchitecture.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.databinding.ActivityKeepNoteBinding
import com.example.testing.task7.Task7Application
import com.example.testing.task7.cleanArchitecture.presentation.adapter.KeepNoteAdapter
import com.example.testing.task7.cleanArchitecture.presentation.entity.KeepNoteUI
import com.example.testing.task7.cleanArchitecture.presentation.factory.KeepViewModelFactory
import com.example.testing.task7.cleanArchitecture.presentation.viewModel.KeepNoteViewModel

class KeepNoteActivity : AppCompatActivity() {

    private var binding: ActivityKeepNoteBinding? = null

    private val app by lazy {
        application as Task7Application
    }

    private val factory by lazy {
        KeepViewModelFactory(app.keepNoteInteractor)
    }

    private val keepNoteViewModel by lazy {
        ViewModelProvider(this, factory)[KeepNoteViewModel::class.java]
    }

    private var keepNoteUi: KeepNoteUI = KeepNoteUI(-1,"", "")
    private var isEdit = false

    private var listAdapter: KeepNoteAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeepNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        keepNoteViewModel.getAllNote()

        listAdapter = KeepNoteAdapter(
            onDelete = {
                keepNoteViewModel.deleteNote(it.id)
            },
            onEdit = {
                keepNoteUi = it
                keepNoteViewModel.setEditState()
            })


        setupButton()
        setupObserver()
        setupAdapter()


    }


    private fun setupButton() {
        withBinding {
            if (isEdit){
                addNotes.setText("saveEdit")
                editViewTitle.setText(keepNoteUi.title)
                editViewDescription.setText(keepNoteUi.description)
                addNotes.setOnClickListener {
                    keepNoteViewModel.editNote(
                        keepNoteUi.copy(title = editViewTitle.text.toString(), description = editViewDescription.text.toString())
                    )
                    editViewTitle.setText("")
                    editViewDescription.setText("")
                    keepNoteViewModel.setAddState()
                    Log.i("CheckFile", "state: $isEdit")
                }
            }
            else{
                addNotes.setText("addNote")
                addNotes.setOnClickListener {

                    keepNoteViewModel.addNote(
                        KeepNoteUI(
                            id = -1,
                            title = editViewTitle.text.toString(),
                            description = editViewDescription.text.toString()
                        )
                    )

                    editViewTitle.setText("")
                    editViewDescription.setText("")
                    Log.i("CheckFile", "activity: write")
                    Log.i("CheckFile", "state: $isEdit")
                }
            }


        }
    }

    private fun setupAdapter() {


        withBinding {
            recView.adapter = listAdapter
            recView.layoutManager = LinearLayoutManager(this@KeepNoteActivity)
        }
    }

    private fun setupObserver() {
        keepNoteViewModel.keepNotes.observe(this) {
            listAdapter?.submitList(it)
        }

        keepNoteViewModel.isEditState.observe(this) {
            isEdit = it
            setupButton()
        }

    }


    private fun withBinding(block: ActivityKeepNoteBinding.() -> Unit) {
        binding?.let {
            block.invoke(it)
        }
    }

}



