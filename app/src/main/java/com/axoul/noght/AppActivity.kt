package com.axoul.noght

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentTransaction
import com.axoul.noght.databinding.ActivityAppBinding
import com.axoul.noght.ui.DreamDialog
import com.axoul.noght.ui.home.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AppActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAppBinding
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isLargeLayout = resources.getBoolean(R.bool.large_layout)
        fab = binding.fab
        fab.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val newFragment = DreamDialog()
            if (isLargeLayout) {
                newFragment.show(fragmentManager, "dialog")
            } else {
                val transaction = fragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction
                    .add(android.R.id.content, newFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.nav_view, HomeFragment::class.java, null).commit()
    }
}