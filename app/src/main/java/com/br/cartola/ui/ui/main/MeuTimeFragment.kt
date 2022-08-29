package com.br.cartola.ui.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.cartola.databinding.TabBinding
import com.br.cartola.ui.viewmodel.MeuTimeCartolaViewModel
import org.koin.android.ext.android.inject

class MeuTimeFragment : Fragment() {
    private var _binding: TabBinding? = null

    private val viewMeuTimeModel: MeuTimeCartolaViewModel by inject()

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saudacaoPersistencia = this.activity?.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        var token = saudacaoPersistencia?.getString("token", "").toString()

        viewMeuTimeModel.getMeuTimeApi(token)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TabBinding.inflate(inflater, container, false)
        val root = binding.root

        viewMeuTimeModel.meuTime.observe(this, Observer {

            val recyclerView: RecyclerView = binding.recycler
            val layoutManager = LinearLayoutManager(requireContext())
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = MeuTimeAdapter(it.atletas)

        })

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MeuTimeFragment()
    }
}