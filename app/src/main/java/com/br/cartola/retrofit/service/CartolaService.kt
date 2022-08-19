package com.br.cartola.retrofit.service

import com.br.cartola.model.TimesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CartolaService {

    @GET("ligas")
    suspend fun getTimes(
        @Header("X-GLB-Token") token: String?
    ) : Response<TimesModel>

}