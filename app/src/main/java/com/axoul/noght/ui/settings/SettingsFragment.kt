package com.axoul.noght.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.axoul.noght.R
import com.axoul.noght.ui.history.HistoryFragment
import com.axoul.noght.ui.home.HomeFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val bottomBar = requireActivity().findViewById<BottomAppBar>(R.id.bottomAppBar)
        bottomBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        bottomBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_history -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_view, HistoryFragment::class.java, null)
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
                        .commit()
                    true
                }

                R.id.navigation_home -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_view, HomeFragment::class.java, null)
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}