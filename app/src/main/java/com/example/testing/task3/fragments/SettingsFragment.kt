package com.example.testing.task3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testing.R
import com.example.testing.databinding.FragmentSettingsBinding


class SettingsFragment: Fragment() {
    var binding: FragmentSettingsBinding? = null

    private val arguments: SettingsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textFromFrag = arguments.text
        binding?.let {bind->
            bind.tvGetTxt.text = textFromFrag
            bind.toDetailsFrag.setOnClickListener {
                val bundle = Bundle().apply {
                    putString("data_key", "From SettingsFragment")
                }
                setFragmentResult("data_from_settings", bundle)
                findNavController().navigateUp()
            }

        }


    }
}