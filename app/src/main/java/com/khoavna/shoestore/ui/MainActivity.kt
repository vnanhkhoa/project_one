package com.khoavna.shoestore.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.khoavna.shoestore.R
import com.khoavna.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var navController: NavController
    private val appBarConfig = AppBarConfiguration(
        setOf(R.id.loginFragment,R.id.onboardingFragment,R.id.listShoeFragment)
    )

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController
        navController.addOnDestinationChangedListener { _, des, _ ->
            when (des.id) {
                R.id.loginFragment,R.id.onboardingFragment -> {
                    viewModel.hideToolbar()
                }

                else -> {
                    viewModel.showToolBar()
                }
            }
        }
        setupActionBarWithNavController(navController,appBarConfig)

        initObserver()
    }

    private fun initObserver() {
        viewModel.toolbarVisibility.observe(this) {
            binding.toolbar.visibility = it
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}