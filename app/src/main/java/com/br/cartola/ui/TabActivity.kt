package com.br.cartola.ui

import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.br.cartola.databinding.ActivityTabBinding
import com.br.cartola.model.TimesModel
import com.br.cartola.ui.ui.main.SectionsPagerAdapter
import com.br.cartola.ui.viewmodel.TimesCartolaViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.android.ext.android.inject

class TabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBinding

    private val viewModel: TimesCartolaViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saudacaoPersistencia = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        val token = saudacaoPersistencia.getString("token", "")

        if (token.isNullOrEmpty()) {
            getLigas(token.toString())
        }

        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter


        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    private fun getLigas(tokenezed: String) : TimesModel? {
        return viewModel.getTimesApi(tokenezed)
    }


}