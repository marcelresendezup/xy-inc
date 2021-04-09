package br.com.celfons.controller.response

data class PoiResponse(
    val id: Long,
    val name: String,
    val positionX: Int,
    val positionY: Int
)
