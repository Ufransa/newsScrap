package com.example.newsscrap.newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.R
import com.example.newsscrap.data.Results
import com.example.newsscrap.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter(private val news: List<Results?>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = news[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int = news.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemNewsBinding.bind(view)

        fun bind(news: Results?) {
            binding.tvTituloNews.text = news?.titulo
            binding.tvDescripcionNews.text = news?.descripcion
            Picasso.get()
                .load(news?.imagen)
                .into(binding.ivNews)
        }
    }
}