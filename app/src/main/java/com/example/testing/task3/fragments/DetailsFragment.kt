package com.example.testing.task3.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.NavController
import com.example.testing.R
import androidx.navigation.fragment.findNavController
import com.example.testing.databinding.FragmentDetailsBinding
import com.example.testing.databinding.FragmentTask3Binding

class DetailsFragment : Fragment() {
    var binding: FragmentDetailsBinding? = null
    var text: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navController = findNavController()





        binding?.let { bind ->
            bind.toSettingsFragment.setOnClickListener {
                navController.navigate(
                    DetailsFragmentDirections.actionDetailFragmentToSettingsFragment(
                        text.toString()
                    )
                )
            }
            setFragmentResultListener("data_from_settings") { text, bundle ->

                bind.tvDetailsFrag.text = bundle.getString("data_key")

            }


            bind.edtCheckDetails.addTextChangedListener(object : TextWatcher {
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
        if (savedInstanceState != null) {
            text = savedInstanceState.getString("details_state")
            binding?.edtCheckDetails?.setText(text)
        }

        Log.i("check_txt", text.toString())

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("details_state", text)
    }
}