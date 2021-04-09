package br.com.celfons.controller

import br.com.celfons.controller.request.PoiRequest
import br.com.celfons.controller.response.PoiResponse
import br.com.celfons.domain.PoiEntity
import br.com.celfons.service.PoiService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/pois"])
class PoiController(
    private val service: PoiService
) {

    @PostMapping
    fun create(@RequestBody request: PoiRequest): PoiResponse = service.create(request)

    @GetMapping
    fun findAll(): List<PoiResponse> = service.findAll()

    @GetMapping("/findByProximity")
    fun findByProximity(
        @RequestParam positionX: Int,
        @RequestParam positionY: Int,
        @RequestParam maxRange: Int
    ): List<PoiResponse> = service.findByProximity(positionX, positionY, maxRange)

}
