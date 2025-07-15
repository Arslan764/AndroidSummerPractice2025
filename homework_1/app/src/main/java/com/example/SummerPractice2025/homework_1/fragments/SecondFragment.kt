package com.example.SummerPractice2025.homework_1.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.SummerPractice2025.homework_1.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTextWatchers()
        setupSubmitButton()
    }

    private fun setupTextWatchers() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateInputs()
            }
        }

        binding.emailEditText.addTextChangedListener(textWatcher)
        binding.passwordEditText.addTextChangedListener(textWatcher)
    }

    private fun setupSubmitButton() {
        binding.submitButton.setOnClickListener {
            submitForm()
        }
    }

    private fun validateInputs() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        val isEmailValid = email.matches(emailPattern.toRegex())
        val isPasswordValid = isPasswordValid(password)

        binding.submitButton.isEnabled = isEmailValid && isPasswordValid
    }

    private fun isPasswordValid(password: String): Boolean {
        if (password.length < 8) return false
        if (!password.any { it.isDigit() }) return false
        if (!password.any { it.isUpperCase() }) return false
        if (!password.any { it.isLowerCase() }) return false
        return true
    }

    private fun submitForm() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        val action = SecondFragmentDirections.actionSecondToThird(
            email = email,
            password = password
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}