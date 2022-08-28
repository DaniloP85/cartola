package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ScoutModel(

    @SerializedName("CA")
    val ca: Int,

    @SerializedName("DS")
    val ds: Int,

    @SerializedName("FC")
    val fc: Int,

    @SerializedName("FD")
    val fd: Int,

    @SerializedName("FF")
    val ff: Int,

    @SerializedName("FS")
    val fs: Int,

    @SerializedName("PI")
    val pi: Int
)
