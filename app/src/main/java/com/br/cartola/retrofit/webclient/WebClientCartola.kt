package com.br.cartola.retrofit.webclient

import com.br.cartola.retrofit.AppRetrofit
import com.br.cartola.retrofit.service.CartolaService

class WebClientCartola(
    private val services: CartolaService = AppRetrofit().services
) {

    suspend fun getMinhasLigas(token: String) = services.getMinhasLigas(token).body()
}