package com.example.newsscrap.newsdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeFragment
import com.example.newsscrap.databinding.FragmentNewsDetailsBinding
import com.example.newsscrap.themes.MyAppTheme

class FragmentNewsDetails : ThemeFragment() {

    private lateinit var binding: FragmentNewsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailsBinding.inflate(inflater,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = FragmentNewsDetailsArgs.fromBundle(requireArguments())
        Log.i("ARGUMENTO GUAY", args.url.toString())
        binding.wvNoticia.loadUrl(args.url!!)
    }

    //Sincronizar los colores
    override fun syncTheme(appTheme: AppTheme) {
        val myAppTheme = appTheme as MyAppTheme
        context?.let {

            //Implementar el color del root
            binding.root.setBackgroundColor(myAppTheme.activityBackgroundColor(it))
        }
    }


}