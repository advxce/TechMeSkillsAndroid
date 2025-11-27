package com.example.testing.task3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testing.R
import com.example.testing.databinding.FragmentDetailsNoGraphBinding
import com.example.testing.databinding.FragmentHomeBinding
import com.example.testing.databinding.FragmentHomeNoGraphBinding
import com.example.testing.databinding.FragmentTask3Binding

class HomeNoGraphFragment: Fragment() {
    var binding: FragmentHomeNoGraphBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeNoGraphBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {




        binding?.let {bId->


            bId.toDetailsFragNoGraph.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerNoGraph, DetailsNoGraphFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}