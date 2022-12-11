package com.example.newsscrap.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeFragment
import com.dolatkia.animatedThemeManager.ThemeManager
import com.example.newsscrap.R
import com.example.newsscrap.databinding.FragmentSettingsBinding
import com.example.newsscrap.themes.DarkTheme
import com.example.newsscrap.themes.DefaultTheme
import com.example.newsscrap.themes.MyAppTheme
import com.example.newsscrap.themes.PinkTheme
import java.util.*


class FragmentSettings : ThemeFragment() {

    private lateinit var binding: FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        changeOfTheme()
        switchOnClick()

        super.onViewCreated(view, savedInstanceState)

    }

    //Actualizar recursos al hacer click en el switch de cambio de idioma
    @Suppress("DEPRECATION")
    private fun updateResourse(language: String) {

        val recursos = resources
        val displayMetrics = resources.displayMetrics
        val config = resources.configuration

        config.setLocale(Locale(language))
        resources.updateConfiguration(config, displayMetrics)
        config.locale = Locale(language)
        resources.updateConfiguration(config, displayMetrics)

        binding.sLan.text = recursos.getString(R.string.selectedLenguaje)
        binding.tvSettings.text = recursos.getString(R.string.Ajustes)
        binding.tvTheme.text = recursos.getString(R.string.Theme)
        binding.tvTittleLanguaje.text = recursos.getString(R.string.Languaje)
        binding.tvbase.text = recursos.getString(R.string.btbase)
        binding.tvdark.text = recursos.getString(R.string.btoscuro)
        binding.tvPink.text = recursos.getString(R.string.btrosa)


    }

    //Cambio de idioma con switch
    private fun switchOnClick() {
        binding.sLan.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                updateResourse("es")
            } else {
                updateResourse("en")
            }
        }
    }

    //Funcion para sincronizar los temas entre pantallas
    override fun syncTheme(appTheme: AppTheme) {

        val myAppTheme = appTheme as MyAppTheme
        context?.let {

            //implementar color background
            binding.root.setBackgroundColor(myAppTheme.activityBackgroundColor(it))

            //implementar color texto
            binding.tvSettings.setTextColor(myAppTheme.activityTextColor(it))
            binding.tvTittleLanguaje.setTextColor(myAppTheme.activityTextColor(it))
            binding.tvTheme.setTextColor(myAppTheme.activityTextColor(it))
            binding.sLan.setTextColor(myAppTheme.activityTextColor(it))

            //implementar color tarjetas
            binding.btbase.setCardBackgroundColor(appTheme.activityThemeButtonColor(it))
            binding.btdark.setCardBackgroundColor(appTheme.activityThemeButtonColor(it))
            binding.btPink.setCardBackgroundColor(appTheme.activityThemeButtonColor(it))
            binding.cvLanguaje.setCardBackgroundColor(appTheme.activityThemeButtonColor(it))
            binding.cvTheme.setCardBackgroundColor(appTheme.activityThemeButtonColor(it))

            //implementar cambio de imagenes
            binding.ivQuote.setImageResource(myAppTheme.activityImageQuote(it))
            binding.ivTrazado.setImageResource(myAppTheme.activityImageTrazado(it))

        }

        //Sincronizar el color de la barra de estado
        syncStatusBarIconColors(appTheme)
    }

    private fun changeOfTheme() {
        //Boton rosa cambio de tema
        binding.btPink.setOnClickListener {
            ThemeManager.instance.changeTheme(PinkTheme(), it)

        }

        //Boton cambio de tema a base
        binding.btbase.setOnClickListener {
            ThemeManager.instance.changeTheme(DefaultTheme(), it)
        }

        //Boton dark cambio de tema
        binding.btdark.setOnClickListener {
            ThemeManager.instance.changeTheme(DarkTheme(), it)
        }

    }

    //Sincronizar los colores
    private fun syncStatusBarIconColors(theme: MyAppTheme) {
        activity?.let {
            ThemeManager.instance.syncStatusBarIconsColorWithBackground(
                it,
                theme.activityBackgroundColor(it)
            )
        }
        activity?.let {
            ThemeManager.instance.syncNavigationBarButtonsColorWithBackground(
                it,
                theme.activityBackgroundColor(it)
            )
        }
    }
}


