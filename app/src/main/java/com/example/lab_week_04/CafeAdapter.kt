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

// Adapter sekarang membutuhkan 'Resources' untuk mengambil string deskripsi
class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val resources: Resources) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    // FUNGSI INI SEKARANG MENJADI "CERDAS"
    override fun createFragment(position: Int): Fragment {
        // Tentukan konten mana yang akan ditampilkan berdasarkan posisi tab
        val content = when (position) {
            0 -> resources.getString(R.string.starbucks_desc)    // Untuk tab pertama
            1 -> resources.getString(R.string.janjijiwa_desc)     // Untuk tab kedua
            2 -> resources.getString(R.string.kopikenangan_desc)    // Untuk tab ketiga
            else -> ""
        }
        // Panggil metode pabrik 'newInstance' untuk membuat fragment sambil MENGIRIMKAN KONTEN
        return CafeDetailFragment.newInstance(content)
    }
}