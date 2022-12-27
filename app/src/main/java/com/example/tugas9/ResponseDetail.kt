package com.example.tugas9

import com.google.gson.annotations.SerializedName

data class ResponseDetail(
    @SerializedName("overview") val overview: String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("release_date") val release_date:String,
    @SerializedName("title") val title:String
)
