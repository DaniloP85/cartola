package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class GatoMestreModel(

    @SerializedName("media_pontos_mandante")
    val mediaPontosMandante: Double?,

    @SerializedName("media_pontos_visitante")
    val mediaPontosVisitante: Double?,

    @SerializedName("media_minutos_jogados")
    val mediaMinutosJogados: Double?,

    @SerializedName("minutos_jogados")
    val minutosJogados: Double?
)
