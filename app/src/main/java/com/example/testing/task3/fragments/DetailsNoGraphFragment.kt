package com.example.testing.task3.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.testing.R
import androidx.navigation.fragment.findNavController
import com.example.testing.databinding.FragmentDetailsBinding
import com.example.testing.databinding.FragmentDetailsNoGraphBinding
import com.example.testing.databinding.FragmentTask3Binding

class DetailsNoGraphFragment: Fragment() {
    var binding: FragmentDetailsNoGraphBinding? = null
    var text: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsNoGraphBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        binding?.let { bind->
            bind.toSettingsFragment.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerNoGraph, SettingsFragment())
                    .addToBackStack(null)
                    .commit()
            }

            bind.edtCheckDetails.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(p0: Editable?) {
                    text = p0.toString()
                }

                override fun beforeTextChanged(
                    p0: CharSequence?,
                    p1: Int,
                    p2: Int,
                    p3: Int
                ) {

                }

                override fun onTextChanged(
                    p0: CharSequence?,
                    p1: Int,
                    p2: Int,
                    p3: Int
                ) {

                }

            })



        }


    }


}