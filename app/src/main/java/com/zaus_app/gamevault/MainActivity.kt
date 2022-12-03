package com.zaus_app.gamevault

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.zaus_app.gamevault.databinding.ActivityMainBinding
import com.zaus_app.gamevault.view.FavoritesFragment
import com.zaus_app.gamevault.view.HomeFragment
import com.zaus_app.gamevault.view.NewsFragment
import com.zaus_app.gamevault.view.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
    }

    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .commit()
    }
    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it) {
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    window.statusBarColor = ContextCompat.getColor(this,R.color.colorFragmentHome)
                    binding.bottomNavigation.setBackgroundResource(R.drawable.home_fragment_background)
                    changeFragment( fragment?: HomeFragment(), tag)
                }
                R.id.favorites -> {
                    val tag = "favorites"
                    val fragment = checkFragmentExistence(tag)
                    window.statusBarColor = ContextCompat.getColor(this,R.color.colorFragmentFavorites)
                    binding.bottomNavigation.setBackgroundResource(R.drawable.favorites_fragment_background)
                    changeFragment( fragment?: FavoritesFragment(), tag)
                }
                R.id.news -> {
                    val tag = "news"
                    val fragment = checkFragmentExistence(tag)
                    window.statusBarColor = ContextCompat.getColor(this,R.color.colorFragmentNews)
                    binding.bottomNavigation.setBackgroundResource(R.drawable.news_fragment_background)
                    changeFragment( fragment?: NewsFragment(), tag)
                }
                R.id.settings -> {
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    window.statusBarColor = ContextCompat.getColor(this,R.color.colorFragmentSettings)
                    binding.bottomNavigation.setBackgroundResource(R.drawable.settings_fragment_background)
                    changeFragment( fragment?: SettingsFragment(), tag)
                }
            }
        }
        binding.bottomNavigation.setItemSelected(R.id.home)
    }
}