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
import com.br.cartola.ui.viewmodel.MeuTimeCartolaViewModel
import org.koin.android.ext.android.inject

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private var _binding: TabBinding? = null

    private val viewModel: LigasCartolaViewModel by inject()
//    private val viewMeuTimeModel: MeuTimeCartolaViewModel by inject()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saudacaoPersistencia = this.activity?.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        var token = saudacaoPersistencia?.getString("token", "")

        //viewMeuTimeModel.getMeuTimeApi(token)
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
}