package com.br.cartola.ui.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.cartola.R
import com.br.cartola.model.LigaModel
import com.br.cartola.model.LigasModel
import com.squareup.picasso.Picasso

class Adapter (private var list: List<LigaModel>): RecyclerView.Adapter<Adapter.viewHolder>() {
    inner class viewHolder (view: View): RecyclerView.ViewHolder(view) {
        private val flag = view.findViewById<ImageView>(R.id.timeBandeira)
        private val nome = view.findViewById<TextView>(R.id.nome)
        private val description = view.findViewById<TextView>(R.id.description)

        fun bind(ligaModel: LigaModel) {
            nome.text = ligaModel.nome
            description.text = ligaModel.descricao
            Picasso.get()
                .load(ligaModel.urlFlamulaPng)
                .into(flag);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.apply { bind(list[position]) }
    }

    override fun getItemCount() = list.size
}