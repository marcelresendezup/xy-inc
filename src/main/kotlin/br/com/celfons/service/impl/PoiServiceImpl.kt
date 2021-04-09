package br.com.celfons.service.impl

import br.com.celfons.commons.BusinessException
import br.com.celfons.commons.toEntity
import br.com.celfons.commons.toResponse
import br.com.celfons.controller.request.PoiRequest
import br.com.celfons.controller.response.PoiResponse
import br.com.celfons.repository.PoiRepository
import br.com.celfons.service.PoiService
import org.springframework.stereotype.Service
import kotlin.math.hypot

@Service
class PoiServiceImpl(
    val repository: PoiRepository
) : PoiService {

    override fun create(request: PoiRequest): PoiResponse = repository.save(request.toEntity()).toResponse()

    override fun findAll(): List<PoiResponse> =
        repository.findAll().toResponse().also { if(it.isEmpty()) throw BusinessException("No have points yet") }

    override fun findByProximity(positionX: Int, positionY: Int, maxRange: Int): List<PoiResponse> =
        findAll().filter {
            hypot((it.positionX - positionX).toDouble(), (it.positionY - positionY).toDouble()) <= maxRange
        }.toList().also { if(it.isEmpty()) throw BusinessException("No have proximity points") }

}
