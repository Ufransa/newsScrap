package com.example.newsscrap.newssave


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeFragment
import com.example.newsscrap.data.News
import com.example.newsscrap.data.NewsApplication
import com.example.newsscrap.databinding.FragmentNewsSaveBinding
import com.example.newsscrap.themes.MyAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentNewsSave : ThemeFragment() {

    private lateinit var binding: FragmentNewsSaveBinding
    private lateinit var newsSaveAdapter: NewsSaveAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private var news: MutableList<News?> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsSaveBinding.inflate(inflater, container, false)
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
            activity?.runOnUiThread {
                newsSaveAdapter.addNews(news)
            }
        }
    }


    private fun initRecycler() {
        newsSaveAdapter = NewsSaveAdapter(
            news,
            ::listener
        )
        linearLayoutManager = LinearLayoutManager(activity)
        binding.rvNewsSave.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = newsSaveAdapter
        }
    }


    private fun listener(url: String?) {
        findNavController()
            .navigate(FragmentNewsSaveDirections.actionFragmentNewsSaveToNewsDetailsFragment(url))
    }

    // Funcionality change of theme
    override fun syncTheme(appTheme: AppTheme) {
        val myAppTheme = appTheme as MyAppTheme
        context?.let {

            //set background color
            binding.root.setBackgroundColor(myAppTheme.activityBackgroundColor(it))

        }
    }
}