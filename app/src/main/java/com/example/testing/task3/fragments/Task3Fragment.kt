package com.example.testing.task3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testing.R
import com.example.testing.databinding.FragmentTask3Binding

class Task3Fragment: Fragment() {

    var binding: FragmentTask3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTask3Binding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dataFromActivity = arguments?.getString("txt")
        binding?.tvDataFromAct?.text = dataFromActivity
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}