package com.example.newsscrap


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeActivity
import com.example.newsscrap.databinding.ActivityMainBinding
import com.example.newsscrap.themes.DefaultTheme
import com.example.newsscrap.themes.MyAppTheme

class MainActivity : ThemeActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bottomNavigation.itemIconTintList = null
        setupBottomNav()
        setUpDrawerToggle()

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.logo_azul_horizontal_250)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        setContentView(binding.root)
    }

    //Funcion para implementar el menu lateral (Settings)
    private fun setUpDrawerToggle() {
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.Open, R.string.Close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.sideNavView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_settings -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.settingsFragment)
                    binding.drawerLayout.closeDrawers()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        (toggle.onOptionsItemSelected(item))
        return super.onOptionsItemSelected(item)
    }

    //Funcion para implementar el menu de abajo (listado/favoritos)
    private fun setupBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener {
            findNavController(R.id.nav_host_fragment).navigateUp()
            when (it.itemId) {
                R.id.nav_home -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.NewsListFragment)
                }
                R.id.nav_library -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.fragmentNewsSave)
                }
            }
            true
        }
    }

    //Sincronizar los colores
    override fun syncTheme(appTheme: AppTheme) {

        val myAppTheme = appTheme as MyAppTheme
        this.let {
            //implementar color background
            binding.root.setBackgroundColor(myAppTheme.activityBackgroundColor(it))
            binding.bottomNavigation.setBackgroundColor(myAppTheme.activityBackgroundColor(it))
            binding.sideNavView.setBackgroundColor(myAppTheme.activityBackgroundColor(it))

            //implementar color actionbar
            val actionBar: ActionBar? = supportActionBar
            actionBar?.setBackgroundDrawable(myAppTheme.activityActionBar(it))
            actionBar?.setLogo(myAppTheme.activityActionBarLogo(it))
        }
    }

    //Implementar tema al iniciar la app
    override fun getStartTheme(): AppTheme {
        return DefaultTheme()
    }

}