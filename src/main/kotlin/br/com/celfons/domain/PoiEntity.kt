package br.com.celfons.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "poi")
data class PoiEntity(
    @Id val id: Long? = 1,
    val name: String,
    val positionX: Int,
    val positionY: Int
)
