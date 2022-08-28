package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class RankingAtualModel(

    @SerializedName("ranking_id")
    val ranking_id: Int,

    @SerializedName("mes")
    val mes: Int,

    @SerializedName("posicao")
    val posicao: Int
)
