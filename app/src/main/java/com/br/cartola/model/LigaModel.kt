package com.br.cartola.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class LigaModel(

    @SerializedName("liga_id")
    val ligaId: Integer,

    @SerializedName("time_dono_id")
    val timeDonoId: Objects,

    @SerializedName("clube_id")
    val clubeId: Objects,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("descricao")
    val descricao: String,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("tipo")
    val tipo: String,

    @SerializedName("mata_mata")
    val mataMata: String,

    @SerializedName("editorial")
    val editorial: Boolean,

    @SerializedName("patrocinador")
    val patrocinador: Boolean,

    @SerializedName("criacao")
    val criacao: String,

    @SerializedName("sem_capitao")
    val semCapitao: Boolean,

    @SerializedName("tipo_flamula")
    val tipoFlamula: Integer,

    @SerializedName("tipo_estampa_flamula")
    val tipoEstampaFlamula: Object,

    @SerializedName("tipo_adorno_flamula")
    val tipoAdornoFlamula: Object,

    @SerializedName("cor_primaria_estampa_flamula")
    val corPrimariaEstampaFlamula: String,

    @SerializedName("cor_secundaria_estampa_flamula")
    val corSecundariaEstampaFlamula: String,

    @SerializedName("cor_borda_flamula")
    val corBordaFlamula: Object,

    @SerializedName("cor_fundo_flamula")
    val corFundoFlamula: Object,

    @SerializedName("url_flamula_svg")
    val urlFlamulaSvg: String,

    @SerializedName("url_flamula_png")
    val urlFlamulaPng: String,

    @SerializedName("tipo_trofeu")
    val tipoTrofeu: Object,

    @SerializedName("cor_trofeu")
    val corTrofeu: Object,

    @SerializedName("url_trofeu_svg")
    val urlTrofeuSvg: Object,

    @SerializedName("url_trofeu_png")
    val urlTrofeuPng: Object,

    @SerializedName("inicio_rodada")
    val inicioRodada: Integer,

    @SerializedName("fim_rodada")
    val fimRodada: Object,

    @SerializedName("quantidade_times")
    val quantidadeTimes: Object,

    @SerializedName("sorteada")
    val sorteada: Boolean,

    @SerializedName("imagem")
    val imagem: String,

    @SerializedName("mes_ranking_num")
    val mesRankingNum: Integer,

    @SerializedName("mes_variacao_num")
    val mesVariacaoNum: Integer,

    @SerializedName("camp_ranking_num")
    val campRankingNum: Integer,

    @SerializedName("camp_variacao_num")
    val campVariacaoNum: Integer,

    @SerializedName("capitao_ranking_num")
    val capitaoRankingNum: Object,
    @SerializedName("capitao_variacao_num")
    val capitaoVariacaoNum: Object,

    @SerializedName("total_times_liga")
    val totalTimesLiga: Integer,

    @SerializedName("vagas_restantes")
    val vagasRestantes: Object,

    @SerializedName("total_amigos_na_liga")
    val totalAmigosNaLiga: Integer
)
