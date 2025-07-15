package com.example.SummerPractice2025.homework_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.SummerPractice2025.homework_1.R
import com.example.SummerPractice2025.homework_1.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayUserData()
    }

    private fun displayUserData() {
        binding.emailTextView.text = getString(R.string.email_label, args.email)
        binding.passwordTextView.text = getString(R.string.password_label, args.password)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}