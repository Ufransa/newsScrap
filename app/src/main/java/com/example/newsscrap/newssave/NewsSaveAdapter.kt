package com.example.newsscrap.newssave

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsscrap.data.News
import com.example.newsscrap.data.NewsApplication
import com.example.newsscrap.databinding.ItemNewsBinding
import com.example.newsscrap.databinding.ItemNewsSaveBinding

class NewsSaveAdapter(
    private var news     : MutableList<News?>,
    private val listener : (String?) -> Unit
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
        fun binding():ItemNewsSaveBinding = binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsSaveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = news[position]
        val binding = holder.binding()
        holder.bind(new)
        holder.itemView.setOnClickListener {
            listener(new?.url)
        }
        binding.btnBorrar.setOnClickListener {
            Thread{
                NewsApplication.database.NewsDao().deleteNew(new)
            }.start()
        }

    }

    override fun getItemCount(): Int = news.size

    @SuppressLint("NotifyDataSetChanged")
    fun addNews(news: MutableList<News?>) {
        this.news = news
        notifyDataSetChanged()
    }
}