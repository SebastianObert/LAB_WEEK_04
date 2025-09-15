package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// Kunci untuk mengirim dan menerima data
private const val TAB_CONTENT = "TAB_CONTENT"

class CafeDetailFragment : Fragment() {
    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Saat fragment dibuat, ia akan memeriksa apakah ada data yang dikirimkan
        // kepadanya dengan kunci "TAB_CONTENT".
        arguments?.let {
            content = it.getString(TAB_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Memuat layout yang sudah kita perbarui
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Setelah layout siap, tampilkan data yang sudah diterima ke dalam TextView
        view.findViewById<TextView>(R.id.content_description)?.text = content
    }

    companion object {
        // Ini adalah metode "pabrik" yang aman untuk membuat fragment ini.
        // CafeAdapter akan memanggil fungsi ini untuk membuat fragment
        // sambil mengirimkan data deskripsi.
        fun newInstance(content: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_CONTENT, content)
                }
            }
    }
}