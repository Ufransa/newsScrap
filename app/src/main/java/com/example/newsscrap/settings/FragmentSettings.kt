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

    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchOnClick()
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
    
}


