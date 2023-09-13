package com.example.hojeeuvoumotorista.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hojeeuvoumotorista.R
import com.example.hojeeuvoumotorista.databinding.ActivityMainBinding
import com.example.hojeeuvoumotorista.ui.fragment.MapaFragment
import com.example.hojeeuvoumotorista.ui.fragment.VansFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupBottomNavigation()

        // Instancie as fragments
        val vanFragment = VansFragment()
        val mapaFragment = MapaFragment()

        loadFragment(vanFragment)

    }

    private fun setupBottomNavigation(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment: Fragment? = when (item.itemId) {
                R.id.nav_van -> VansFragment()
                R.id.nav_mapa -> MapaFragment()
                else -> null
            }
            if (fragment != null) {
                loadFragment(fragment)
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}