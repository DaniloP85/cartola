package com.br.cartola.ui.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.cartola.databinding.TabBinding
import com.br.cartola.model.LigaModel
import com.br.cartola.model.LigasModel
import com.br.cartola.ui.viewmodel.LigasCartolaViewModel
import org.koin.android.ext.android.inject

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: TabBinding? = null

    private val viewModel: LigasCartolaViewModel by inject()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }

        val saudacaoPersistencia = this.activity?.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        var token = saudacaoPersistencia?.getString("token", "")

        viewModel.getMinhasLigasApi(token)
    }

    //TODO: trocar aqui as telas, alguma forma criar dinamicamente
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TabBinding.inflate(inflater, container, false)
        val root = binding.root

        viewModel.ligas.observe(this, Observer {
            val recyclerView: RecyclerView = binding.recycler
            val layoutManager = LinearLayoutManager(requireContext())
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = Adapter(it.ligas)
        })

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getMinhasLigas(tokenezed: String) {
        viewModel.getMinhasLigasApi(tokenezed)
    }
}