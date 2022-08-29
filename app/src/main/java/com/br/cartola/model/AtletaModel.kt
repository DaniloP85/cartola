package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class AtletaModel(

//    @SerializedName("scout")
//    val scout: ScoutModel,

    @SerializedName("atleta_id")
    val atletaId: Int,

    @SerializedName("rodada_id")
    val rodadaId: Int,

    @SerializedName("posicao_id")
    val posicaoId: Int,

    @SerializedName("status_id")
    val statusId: String,

    @SerializedName("pontos_num")
    val pontosNum: Double,

    @SerializedName("preco_num")
    val precoNum: Double,

    @SerializedName("variacao_num")
    val variacaoNum: Double,

    @SerializedName("media_num")
    val mediaNum: Double,

    @SerializedName("jogos_num")
    val jogosNum: Int,

    @SerializedName("minimo_para_valorizar")
    val minimoParaValorizar: Double,

//    @SerializedName("gato_mestre")
//    val gatoMestre: GatoMestreModel,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("apelido")
    val apelido: String,

    @SerializedName("apelido_abreviado")
    val apelidoAbreviado: String,

    @SerializedName("cor_primaria_estampa_flamula")
    val corPrimariaEstampaFlamula: String,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("foto")
    val foto: String
)
