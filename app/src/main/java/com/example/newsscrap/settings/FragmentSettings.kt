package com.example.newsscrap.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsscrap.databinding.FragmentSettingsBinding
import java.util.*

class FragmentSettings : Fragment(){

    private lateinit var binding: FragmentSettingsBinding

    //TODO: Cambio de Layout 3
    //private lateinit var listbinding: FragmentNewsListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchOnClick()

        //TODO: Para implementar cuando sea funcional
        // Cambio de Layout 2

        // changeLayout()
    }

    private fun updateResourse(language: String) {
        val res = resources
        val displayMetrics = res.displayMetrics
        val config = resources.configuration

        config.setLocale(Locale(language))
        res.updateConfiguration(config, displayMetrics)
        // config.locale = Locale(language)
        // resources.updateConfiguration(config, displayMetrics)
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


    //Cambio de disposición de la información
    //TODO: Aun no funcional Cambio de Layout 1
    /*private fun changeLayout(){
        binding.rgLayout.setOnClickListener(){
            if(binding.rbGrid.isChecked){
                listbinding.rvNewsList.layoutManager = GridLayoutManager(context, 3)
            } else {
                listbinding.rvNewsList.layoutManager = LinearLayoutManager(context)
            }
        }
    }*/
}