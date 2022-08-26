package com.br.cartola.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.br.cartola.databinding.ActivityTabBinding
import com.br.cartola.model.LigasModel
import com.br.cartola.ui.ui.main.SectionsPagerAdapter
import com.br.cartola.ui.viewmodel.LigasCartolaViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.android.ext.android.inject

class TabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBinding

    private val viewModel: LigasCartolaViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val saudacaoPersistencia = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)
//        var token = saudacaoPersistencia.getString("token", "")
//
////        if (token.isNotEmpty()) {
//            getMinhasLigas(token.toString())
////        }

        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

//    private fun getMinhasLigas(tokenezed: String) : LigasModel? {
//        return viewModel.getMinhasLigasApi(tokenezed)
//    }


}