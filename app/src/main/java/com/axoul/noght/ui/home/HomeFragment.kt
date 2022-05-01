package com.axoul.noght.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.axoul.noght.R
import com.axoul.noght.databinding.FragmentHomeBinding
import com.axoul.noght.ui.history.HistoryFragment
import com.axoul.noght.ui.settings.SettingsFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val bottomBar = requireActivity().findViewById<BottomAppBar>(R.id.bottomAppBar)
        bottomBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        bottomBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_history -> {
                    home2history()
                    true
                }
                R.id.navigation_settings -> {
                    home2settings()
                    true
                }
                else -> false
            }
        }

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            // TODO
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun home2history() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_view, HistoryFragment::class.java, null)
            .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
            .commit()
    }

    private fun home2settings() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_view, SettingsFragment::class.java, null)
            .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
            .commit()
    }
}