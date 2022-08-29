package com.br.cartola.ui.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.cartola.R
import com.br.cartola.model.AtletaModel
import com.br.cartola.model.AtletasModel
import com.br.cartola.model.MeuTimeModel
import com.squareup.picasso.Picasso

class MeuTimeAdapter(private val obj: List<AtletaModel>): RecyclerView.Adapter<MeuTimeAdapter.MeuTimeViewholder>() {
    inner class MeuTimeViewholder(view: View): RecyclerView.ViewHolder(view) {
        private val photo = view.findViewById<ImageView>(R.id.fotoAtleta)
        private val nome = view.findViewById<TextView>(R.id.nomeAtleta)
        private val description = view.findViewById<TextView>(R.id.descriptionAtleta)

        fun bind(meuTimeModel: AtletaModel) {
            nome.text = meuTimeModel.apelido
            description.text = "Média: " + meuTimeModel.mediaNum.toString() + " | $" + meuTimeModel.precoNum.toString() + " | Jogos: " + meuTimeModel.jogosNum.toString()
            Picasso.get()
                .load(meuTimeModel.foto.toString().replace("FORMATO", "140x140"))
                .into(photo);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuTimeViewholder {
        return MeuTimeViewholder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_meutime, parent, false))
    }

    override fun onBindViewHolder(holder: MeuTimeViewholder, position: Int) {
        holder.apply { bind(obj[position]) }
    }

    override fun getItemCount() = obj.size;
}