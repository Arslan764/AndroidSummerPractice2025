package com.example.SummerPractice2025.homework_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.SummerPractice2025.homework_1.R
import com.example.SummerPractice2025.homework_1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val picturesList = listOf(
        "https://i.pinimg.com/1200x/29/d2/29/29d22922e58399e97068ebce9da51cf7.jpg",
        "https://i.pinimg.com/736x/50/64/71/506471fd47af65177960861a5abc6b7a.jpg",
        "https://i.pinimg.com/736x/da/fc/51/dafc51bd5087cd608f33a27dc1a07e2f.jpg",
        "https://i.pinimg.com/736x/55/c1/b5/55c1b5eb2eff669863d72d651f53a7ca.jpg",
        "https://i.pinimg.com/1200x/7a/52/c4/7a52c4bed040377347bafbbb068e6f01.jpg",
        "https://i.pinimg.com/736x/37/f0/3c/37f03ca284e89947658835acfb25e0bf.jpg",
        "https://i.pinimg.com/736x/37/f0/3c/37f03ca284e89947658835acfb25e0bf.jpg",
        "https://i.pinimg.com/736x/37/f0/3c/37f03ca284e89947658835acfb25e0bf.jpg",
        "https://i.pinimg.com/736x/37/f0/3c/37f03ca284e89947658835acfb25e0bf.jpg",
        "https://i.pinimg.com/736x/37/f0/3c/37f03ca284e89947658835acfb25e0bf.jpg"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.changeImageButton.setOnClickListener {
            loadRandomImage()
        }

        binding.nextButton.setOnClickListener {
            navigateToSecondScreen()
        }
    }

    private fun loadRandomImage() {
        val randomImageUrl = picturesList.random()
        Glide.with(this)
            .load(randomImageUrl)
            .placeholder(R.color.purple_200)
            .into(binding.imageView)
    }

    private fun navigateToSecondScreen() {
        findNavController().navigate(R.id.action_main_to_second)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}