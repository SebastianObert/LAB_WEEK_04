package com.example.lab_week_04

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val resources: Resources) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        val content = when (position) {
            0 -> resources.getString(R.string.starbucks_desc)
            1 -> resources.getString(R.string.janjijiwa_desc)
            2 -> resources.getString(R.string.kopikenangan_desc)
            else -> ""
        }
        return CafeDetailFragment.newInstance(content)
    }
}