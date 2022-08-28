package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class TimeModel(

    @SerializedName("temporada_inicial")
    val temporadaInicial: Int,

    @SerializedName("cor_fundo_escudo")
    val corFundoEscudo: String,

    @SerializedName("cor_camisa")
    val corCamisa: String,

    @SerializedName("cor_borda_escudo")
    val corBordaEscudo: String,

    @SerializedName("foto_perfil")
    val fotoPerfil: String,

    @SerializedName("nome_cartola")
    val nomeCartola: String,

    @SerializedName("globo_id")
    val globoId: String,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("url_escudo_svg")
    val urlEscudoSvg: String,

    @SerializedName("url_escudo_png")
    val urlEscudoPng: String,

    @SerializedName("url_camisa_svg")
    val urlCamisaSvg: String,

    @SerializedName("url_camisa_png")
    val urlCamisaPng: String,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("cor_secundaria_estampa_escudo")
    val corSecundariaEstampaEscudo: String,

    @SerializedName("sorteio_pro_num")
    val sorteioProNum: Double?,

    @SerializedName("cor_primaria_estampa_camisa")
    val corprimariaEstampaCamisa: String,

    @SerializedName("cor_secundaria_estampa_camisa")
    val corSecundariaEstampaCamisa: String,

    @SerializedName("cor_primaria_estampa_escudo")
    val corPrimariaEstampaEscudo: String,

    @SerializedName("rodada_time_id")
    val rodadaTimeId: Int,

    @SerializedName("facebook_id")
    val facebook_id: String,

    @SerializedName("tipo_escudo")
    val tipoEscudo: Int,

    @SerializedName("time_id")
    val timeId: Int,

    @SerializedName("tipo_adorno")
    val tipoAdorno: Int,

    @SerializedName("esquema_id")
    val esquemaId: Int,

    @SerializedName("tipo_estampa_camisa")
    val tipoEstampaCamisa: Int,

    @SerializedName("tipo_estampa_escudo")
    val tipoEstampaEscudo: Int,

    @SerializedName("patrocinador1_id")
    val patrocinador1Id: Int,

    @SerializedName("clube_id")
    val clubeId: Int,

    @SerializedName("tipo_camisa")
    val tipoCamisa: Int,

    @SerializedName("patrocinador2_id")
    val patrocinador2Id: Int,

    @SerializedName("assinante")
    val assinante: Boolean,

    @SerializedName("simplificado")
    val simplificado: Boolean,

    @SerializedName("cadastro_completo")
    val cadastroCompleto: Boolean,

    @SerializedName("lgpd_removido")
    val lgpdRemovido: Boolean,

    @SerializedName("lgpd_quarentena")
    val lgpdQuarentena: Boolean
)
