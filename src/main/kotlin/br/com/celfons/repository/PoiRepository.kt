package br.com.celfons.repository

import br.com.celfons.domain.PoiEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PoiRepository : JpaRepository<PoiEntity, Long>
