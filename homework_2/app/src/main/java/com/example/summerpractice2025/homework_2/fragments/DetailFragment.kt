package com.example.summerpractice2025.homework_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.SummerPractice2025.homework_1.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args by navArgs<DetailFragmentArgs>()

        binding.detailTitle.text = args.title
        binding.detailDescription.text = args.description
        Glide.with(this)
            .load(args.imageUrl)
            .into(binding.detailImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}