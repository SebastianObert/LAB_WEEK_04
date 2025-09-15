package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {

    // Fungsi ini dipanggil untuk membuat tampilan (layout) dari fragment.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Memuat layout dari file fragment_cafe.xml, yang berisi TabLayout dan ViewPager2.
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    // Fungsi ini dipanggil setelah layout fragment berhasil dibuat.
    // Di sinilah kita menghubungkan semua logika.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Menemukan komponen UI dari layout berdasarkan ID-nya.
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        // 2. Membuat instance dari CafeAdapter.
        //    PENTING: Kita mengirimkan 'childFragmentManager', 'lifecycle', dan 'resources'.
        //    'resources' dibutuhkan oleh adapter untuk mengambil teks deskripsi dari strings.xml.
        val adapter = CafeAdapter(childFragmentManager, lifecycle, resources)

        // 3. Menetapkan adapter yang sudah kita buat ke ViewPager2.
        //    Mulai dari sini, ViewPager2 akan menggunakan adapter ini untuk mengisi kontennya.
        viewPager.adapter = adapter

        // 4. Menggunakan TabLayoutMediator untuk menyinkronkan TabLayout dengan ViewPager2.
        //    Ini adalah "lem" yang membuat klik pada tab akan menggeser ViewPager,
        //    dan geseran pada ViewPager akan memilih tab yang benar.
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Untuk setiap tab, atur teks judulnya berdasarkan daftar TABS_FIXED
            // yang ada di CafeAdapter.kt.
            tab.text = resources.getString(TABS_FIXED[position])
        }.attach() // Jangan lupa memanggil .attach() untuk mengaktifkan mediator.
    }
}