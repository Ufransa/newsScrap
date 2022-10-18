package com.example.newsscrap.newssave

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsscrap.data.News
import com.example.newsscrap.databinding.ItemNewsSaveBinding

class NewsSaveAdapter(
    private val news: MutableList<News?>
) : RecyclerView.Adapter<NewsSaveAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemNewsSaveBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(new: News?) {
            with(binding){
                tvTituloNews.text = new?.titulo
                tvDescripcion.text = new?.descripcion
                Glide.with(tvDescripcion.context)
                    .load(new?.imagen)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imgNews)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsSaveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = news[position]
        holder.bind(new)
    }

    override fun getItemCount(): Int = news.size

    @SuppressLint("NotifyDataSetChanged")
    fun addNew(new: News) {
        news.add(new)
        notifyDataSetChanged()
    }
}