package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class RankingModel(

    @SerializedName("atual")
    val ranking_id: RankingAtualModel,

    @SerializedName("anterior")
    val mes: RankingAtualModel,

    @SerializedName("melhor_ranking_id")
    val melhorRankingId: Int
)
