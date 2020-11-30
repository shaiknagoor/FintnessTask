package com.live.fintnesstask.models

data class Result(
    val banner: List<String>,
    val cupons: List<Cupon>,
    val decription_image: String,
    val description_body: String,
    val description_title: String,
    val latitudes: String,
    val longitude: String
)