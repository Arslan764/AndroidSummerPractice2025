package com.example.summerpractice2025.homework_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.SummerPractice2025.homework_1.databinding.FragmentMainBinding
import com.example.summerpractice2025.homework_2.data.DataGenerator
import com.example.summerpractice2025.homework_2.data.DataModel
import com.example.summerpractice2025.homework_2.adapters.ItemsAdapter


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemsAdapter
    private val items = mutableListOf<DataModel>()

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

        items.addAll(DataGenerator.generateData((5..15).random()))

        adapter = ItemsAdapter().apply {
            updateData(items)
            setOnItemClickListener { item ->
                openDetailFragment(item)
            }
            setOnImageClickListener { position ->
                changeImage(position)
            }
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MainFragment.adapter
            setHasFixedSize(true)
        }
    }

    private fun changeImage(position: Int) {
        val newImageUrl = DataGenerator.imageUrls.random()
        items[position].imageUrl = newImageUrl
        adapter.notifyItemChanged(position)
    }

    private fun openDetailFragment(item: DataModel) {
        findNavController().navigate(
            MainFragmentDirections.actionMainToDetail(
                item.title,
                item.description,
                item.imageUrl
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}