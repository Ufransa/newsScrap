package com.example.newsscrap.newslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.R
import com.example.newsscrap.data.Results

class Adapter (
    private var news: MutableList<Results?>,
    private val newsDetails: (Results?) -> Unit) :

        RecyclerView.Adapter<Adapter.ViewHolder>() {

            class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_news, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = news[position]
        holder.itemView.setOnClickListener {
            newsDetails(news)
        }
    }

    override fun getItemCount(): Int = news.size

    @SuppressLint("NotifyDataChanged")
    fun getNews(news: MutableList<Results?>) {
        this.news = news
        notifyDataSetChanged()
    }
}