package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class MeuTimeModel(

    @SerializedName("atletas")
    val atletas: AtletasModel,

    @SerializedName("reservas")
    val reservas: ReservasModel,

    @SerializedName("time")
    val time: TimeModel,

    @SerializedName("pontos_campeonato")
    val pontosCampeonato: Double,

    @SerializedName("capitao_id")
    val capitaoId: Double,

    @SerializedName("pontos")
    val pontos: Double,

    @SerializedName("esquema_id")
    val esquemaId: Int,

    @SerializedName("rodada_atual")
    val rodadaAtual: Int,

    @SerializedName("patrimonio")
    val patrimonio: Double,

    @SerializedName("valor_time")
    val valorTime: Double,

    @SerializedName("total_ligas")
    val totalLigas: Double,

    @SerializedName("total_ligas_matamata")
    val totalLigasMatamata: Int,

    @SerializedName("variacao_patrimonio")
    val variacaoPatrimonio: Double,

    @SerializedName("variacao_pontos")
    val variacaoPontos: Double,

    @SerializedName("servicos")
    val servicos: Objects,

    @SerializedName("ranking")
    val ranking: RankingModel
)
