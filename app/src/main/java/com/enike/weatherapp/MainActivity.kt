package com.enike.weatherapp

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.GravityCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.enike.weatherapp.databinding.ActivityMainBinding
import com.enike.weatherapp.ui.home.HomeFragmentDirections
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navController: NavController
    lateinit var drawer: DrawerLayout
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawer = binding.drawerLayout

        // to find the nav controller from the nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController


        //for appbar
        setSupportActionBar(binding.toolbar)

        binding.navView.setNavigationItemSelectedListener(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.homeFragment), binding.drawerLayout)
        setupActionBarWithNavController(navController, drawer)
        setupWithNavController(binding.toolbar, navController, appBarConfiguration)
        setupWithNavController(binding.navView, navController)
        binding.toolbar.overflowIcon = AppCompatResources.getDrawable(this, R.drawable.ic_menu_bar)
        NavigationUI.setupActionBarWithNavController(this, navController)
        AppBarConfiguration(navController.graph, drawer)
        setupWithNavController(binding.navView, navController)

        setupNavigation()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_menu -> {
                findNavController(R.id.nav_host_fragment_container).navigate(R.id.searchFragment)
                true
            }
            else -> false
        }
    }

    private fun setupNavigation() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashScreenFragment -> {
                    supportActionBar?.hide()
                    drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                R.id.homeFragment -> {
                    supportActionBar?.show()
                    binding.toolbar.setNavigationIcon(R.drawable.ic_menu_bar)
                    drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                R.id.searchFragment -> {
                    supportActionBar?.hide()
                }
                else -> {
                    binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                    supportActionBar?.hide()
                    drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}