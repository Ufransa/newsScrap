package com.example.newsscrap.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsscrap.databinding.FragmentNewsListBinding
import com.example.newsscrap.databinding.FragmentSettingsBinding
import com.example.newsscrap.newslist.NewsListAdapter
import java.util.*

class FragmentSettings : Fragment(){

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var listBinding: FragmentNewsListBinding
    private lateinit var newsAdapter: NewsListAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchOnClick()
        // TODO: implementar cambio de layout
        //changeToGridLayout()
    }

    @Suppress("DEPRECATION")
    private fun updateResourse(language: String) {
        val displayMetrics = resources.displayMetrics
        val config = resources.configuration

        config.setLocale(Locale(language))
        resources.updateConfiguration(config, displayMetrics)
    }

    //Cambio de idioma con switch
    private fun switchOnClick(){
        binding.sLan.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked){
                updateResourse("en")
            } else {
                updateResourse("es")
            }
        }
    }

    // TODO: implementar cambio de layout
     private fun onCheckedChanged(){
    }

}