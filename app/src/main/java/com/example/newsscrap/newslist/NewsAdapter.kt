package com.example.newsscrap.newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.R
import com.example.newsscrap.data.News
import com.example.newsscrap.databinding.ItemNewsBinding


class NewsAdapter(
    private val news: List<News?>,
    private val listener: (String?) -> Unit
    ) :
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

        holder.itemView.setOnClickListener {
            listener(news?.url)
        }
    }


    override fun getItemCount(): Int = news.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemNewsBinding.bind(view)
        fun bind(news: News?) {
            binding.tvTituloNews.text = news?.titulo
            binding.tvDescripcionNews.text = news?.descripcion

        }
    }
}