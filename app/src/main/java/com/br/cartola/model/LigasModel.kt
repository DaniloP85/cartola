package com.br.cartola.model

import com.google.gson.annotations.SerializedName

data class LigasModel(

    @SerializedName("ligas")
    val ligas: List<LigaModel>
)