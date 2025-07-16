package com.example.summerpractice2025.homework_2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.SummerPractice2025.homework_1.R
import com.example.summerpractice2025.homework_2.data.DataModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    private var items = emptyList<DataModel>()
    private var onItemClick: ((DataModel) -> Unit)? = null
    private var onImageClick: ((Int) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.itemImage)
        val title: TextView = view.findViewById(R.id.itemTitle)
        val description: TextView = view.findViewById(R.id.itemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.title.text = item.title
        holder.description.text = item.description

        Glide.with(holder.itemView)
            .load(item.imageUrl)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }

        holder.image.setOnClickListener {
            onImageClick?.invoke(position)
        }
    }

    override fun getItemCount() = items.size

    fun updateData(newItems: List<DataModel>) {
        items = newItems.toList()
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (DataModel) -> Unit) {
        onItemClick = listener
    }

    fun setOnImageClickListener(listener: (Int) -> Unit) {
        onImageClick = listener
    }
}