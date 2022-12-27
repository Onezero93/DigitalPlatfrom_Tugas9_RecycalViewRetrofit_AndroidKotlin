package com.example.tugas9.koneksi

import com.example.tugas9.Response
import com.example.tugas9.ResponseDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface apiendpoin {
    @GET("movie/popular?api_key=bc79104b108ca2dee02339203c934fd1&language=en-US&page=1")
    fun getvidio(): Call<Response>

    //source untuk detail
    @GET("movie/{movie_id}}?api_key=bc79104b108ca2dee02339203c934fd1&language=en-US")
    fun getDetail(
        @Path("movie_id") movie_id: String
    ): Call<ResponseDetail>
}