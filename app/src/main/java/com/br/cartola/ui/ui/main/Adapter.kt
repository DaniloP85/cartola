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
        private val imagem = view.findViewById<ImageView>(R.id.slug)
        private val description = view.findViewById<TextView>(R.id.description)

        fun bind(ligaModel: LigaModel) {
            description.text = ligaModel.nome
            Picasso.get()
                .load(ligaModel.imagem)
                .into(imagem);

            description.setOnClickListener {
                // carregar os times da liga
            }
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