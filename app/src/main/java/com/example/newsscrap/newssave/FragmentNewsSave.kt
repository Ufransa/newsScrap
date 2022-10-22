package com.example.newsscrap.newssave


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.data.News
import com.example.newsscrap.data.NewsApplication
import com.example.newsscrap.databinding.FragmentNewsSaveBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//import org.jetbrains.anko.doAsync


class FragmentNewsSave : Fragment() {


    private lateinit var binding: FragmentNewsSaveBinding
    private lateinit var newsSaveAdapter: NewsSaveAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private var news: MutableList<News?> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsSaveBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        recogerArgumentos()
    }


    private fun recogerArgumentos() {
        CoroutineScope(Dispatchers.IO).launch {
            news = NewsApplication.database.NewsDao().getAllNews()
            activity?.runOnUiThread{
                newsSaveAdapter.addNews(news)
            }
        }
    }


    private fun initRecycler() {
        newsSaveAdapter = NewsSaveAdapter(news)  //TODO, añadir la lista sacada de los argumentos, crear boton guardar para ello
        linearLayoutManager = LinearLayoutManager(activity)
        binding.rvNewsSave.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = newsSaveAdapter
        }
    }

}