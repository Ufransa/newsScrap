package com.example.newsscrap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.newsscrap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupBottomNav()
    }

    private fun setupBottomNav(){
        mBinding.bottomNavigation.setOnItemSelectedListener {
            findNavController(R.id.nav_host_fragment).navigateUp()
            when(it.itemId){
                R.id.home -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.NewsListFragment)
                }
                R.id.library -> {
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