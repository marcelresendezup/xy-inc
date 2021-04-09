package br.com.celfons.commons

import br.com.celfons.controller.request.PoiRequest
import br.com.celfons.controller.response.PoiResponse
import br.com.celfons.domain.PoiEntity

fun PoiRequest.toEntity(): PoiEntity = PoiEntity(
    name = name,
    positionX = positionX,
    positionY = positionY
)

fun PoiEntity.toResponse(): PoiResponse = PoiResponse(
    id = id!!,
    name = name,
    positionX = positionX,
    positionY = positionY
)

fun List<PoiEntity>.toResponse(): List<PoiResponse> = this.map {
    PoiResponse(
        id = it.id!!,
        name = it.name,
        positionX = it.positionX,
        positionY = it.positionY
    )
}
