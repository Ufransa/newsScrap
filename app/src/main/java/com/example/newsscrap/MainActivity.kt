package com.example.newsscrap

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.newsscrap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupBottomNav()
        setUpDrawerToggle()

    }

    private fun setUpDrawerToggle(){
        toggle = ActionBarDrawerToggle(this, mBinding.drawerLayout, R.string.open, R.string.close)
        mBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mBinding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.NewsListFragment)
            }
                R.id.nav_library -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.fragmentNewsSave)
                }
                R.id.nav_settings -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.settingsFragment)
                }
            }
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupBottomNav(){
        mBinding.bottomNavigation.setOnItemSelectedListener {
            findNavController(R.id.nav_host_fragment).navigateUp()
            when(it.itemId){
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


//    private fun setupTopNav(){
//
//    }


}