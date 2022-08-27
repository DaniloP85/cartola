package com.br.cartola.repository

import com.br.cartola.retrofit.webclient.WebClientCartola

class RepositotyCartola(
    private val webClientCartola: WebClientCartola
) {

    suspend fun getMinhasLigasApi(token: String?) = webClientCartola.getMinhasLigas(token.toString())

    suspend fun getMeuTimeApi(token: String?) = webClientCartola.getMeuTime(token.toString())

}