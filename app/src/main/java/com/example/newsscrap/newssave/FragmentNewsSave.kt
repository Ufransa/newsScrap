package com.example.newsscrap.newssave


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.data.News
import com.example.newsscrap.databinding.FragmentNewsSaveBinding

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

        //TODO Bug argumentos nulos
        val titulo = arguments?.getString("titulo","")
        val descripcion = arguments?.getString("descripcion","")
        val url = arguments?.getString("url","")
        val imagen = arguments?.getString("imagen","")

        Log.i("NOOOticia", titulo.toString())
        Log.i("NOOOticia", titulo.toString())
        Log.i("NOOOticia",titulo.toString())
        Log.i("NOOOticia", titulo.toString())
        val new = News(titulo, descripcion, url, imagen)
        newsSaveAdapter.addNew(new)

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