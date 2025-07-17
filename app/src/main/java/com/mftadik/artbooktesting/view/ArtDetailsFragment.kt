package com.mftadik.artbooktesting.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import com.mftadik.artbooktesting.R
import com.mftadik.artbooktesting.databinding.FragmentArtDetailsBinding
import com.mftadik.artbooktesting.databinding.FragmentArtsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtDetailsFragment @Inject constructor(val glide : RequestManager) : Fragment(R.layout.fragment_art_details) {

    private var fragmentBinding : FragmentArtDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtDetailsBinding.bind(view)
        fragmentBinding = binding

        binding.artImageView.setOnClickListener {
            findNavController().navigate(ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageApiFragment())
        }


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }
}