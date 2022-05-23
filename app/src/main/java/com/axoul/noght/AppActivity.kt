package com.axoul.noght

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BasicGridItem
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.bottomsheets.gridItems
import com.axoul.noght.databinding.ActivityAppBinding
import com.axoul.noght.ui.home.HomeFragment
import com.axoul.noght.utils.toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AppActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAppBinding
    private lateinit var fab: FloatingActionButton
    private val items = listOf(
        BasicGridItem(R.drawable.ic_home_black_24dp, "Home"),
        BasicGridItem(R.drawable.ic_history_24, "History"),
        BasicGridItem(R.drawable.ic_settings_24, "Settings"),
        BasicGridItem(R.drawable.ic_baseline_bedtime_24, "Bedtime")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isLargeLayout = resources.getBoolean(R.bool.large_layout)
        fab = binding.fab
        fab.setOnClickListener {
            /*
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
           */
            MaterialDialog(this, BottomSheet()).show {
                gridItems(items) { _, index, item ->
                    toast("Selected item ${item.title} at index $index")
                }

                title(R.string.new_dream)
                cornerRadius(16f)
                positiveButton(R.string.add_category)

            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.nav_view, HomeFragment::class.java, null).commit()
    }
}