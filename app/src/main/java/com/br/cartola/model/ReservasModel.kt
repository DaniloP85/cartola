package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ReservasModel(
    @SerializedName("reservas")
    val reservas: List<AtletaModel>
)
