package br.com.celfons.service

import br.com.celfons.controller.request.PoiRequest
import br.com.celfons.controller.response.PoiResponse

interface PoiService {

    fun create(request: PoiRequest): PoiResponse

    fun findAll(): List<PoiResponse>

    fun findByProximity(positionX: Int, positionY: Int, maxRange: Int): List<PoiResponse>

}
