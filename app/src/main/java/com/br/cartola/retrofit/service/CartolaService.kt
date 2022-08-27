package com.br.cartola.retrofit.service

import com.br.cartola.model.LigasModel
import com.br.cartola.model.MeuTimeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CartolaService {

    @GET("ligas")
    suspend fun getMinhasLigas(
        @Header("X-GLB-Token") token: String?
    ) : Response<LigasModel>

    @GET("time")
    suspend fun getMeutime(
        @Header("X-GLB-Token") token: String?
    ) : Response<MeuTimeModel>

}