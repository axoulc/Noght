package com.axoul.noght

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.axoul.noght.databinding.ActivityAppBinding
import com.axoul.noght.ui.home.HomeFragment
import com.google.android.material.bottomappbar.BottomAppBar

class AppActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.nav_view, HomeFragment::class.java, null).commit()
    }
}