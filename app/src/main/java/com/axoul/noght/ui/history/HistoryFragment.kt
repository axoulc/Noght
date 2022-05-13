package com.axoul.noght.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.axoul.noght.R
import com.axoul.noght.databinding.FragmentHistoryBinding
import com.axoul.noght.ui.home.HomeFragment
import com.axoul.noght.ui.settings.SettingsFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val bottomBar = requireActivity().findViewById<BottomAppBar>(R.id.bottomAppBar)
        bottomBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        bottomBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_settings -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_view, SettingsFragment::class.java, null)
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

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}