package ru.veyvolopayli.fragmentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import ru.veyvolopayli.fragmentsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.selectedItemId = R.id.homeFragment

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.searchFragment -> replaceFragment(SearchFragment())
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.settingsFragment -> replaceFragment(SettingsFragment())
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()

    }
}