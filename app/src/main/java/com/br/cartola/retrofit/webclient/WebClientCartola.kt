package com.br.cartola.retrofit.webclient

import com.br.cartola.retrofit.AppRetrofit
import com.br.cartola.retrofit.service.CartolaService

class WebClientCartola(
    private val services: CartolaService = AppRetrofit().services
) {

    suspend fun getTimes(token: String?) = services.getTimes(token).body()

}