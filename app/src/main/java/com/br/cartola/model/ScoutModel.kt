package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ScoutModel(

    @SerializedName("A")
    val a: Int,

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

    @SerializedName("G")
    val g: Int,

    @SerializedName("I")
    val i: Int,

    @SerializedName("PI")
    val p: Int,

    @SerializedName("FT")
    val ft: Int,

    @SerializedName("CA")
    val ca: Int,

    @SerializedName("CV")
    val cv: Int,

    @SerializedName("PC")
    val pc: Int,

    @SerializedName("SG")
    val sg: Int,

    @SerializedName("DE")
    val de: Int,

    @SerializedName("GS")
    val gs: Int,

    @SerializedName("PS")
    val ps: Int
)
