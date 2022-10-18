package com.example.newsscrap.newslist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.R
import com.example.newsscrap.data.News
import com.example.newsscrap.databinding.ItemNewsBinding


class NewsListAdapter(
    private val news: List<News?>,
    private val listener: (String?) -> Unit,
    private val guardarNews: (News?) -> Unit
    ) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = news[position]
        val binding = holder.binding()
        holder.bind(new)

        holder.itemView.setOnClickListener {
            listener(new?.url)
        }

        binding.imgGuardar.setOnClickListener {
            guardarNews(new)
        }
    }


    override fun getItemCount(): Int = news.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemNewsBinding.bind(view)
        fun bind(news: News?) {
            binding.tvTituloNews.text = news?.titulo
            binding.tvDescripcionNews.text = news?.descripcion
        }
        fun binding(): ItemNewsBinding{
            return binding
        }

    }
}