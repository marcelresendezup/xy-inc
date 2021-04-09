import br.com.celfons.XyIncApplication
import br.com.celfons.commons.BusinessException
import br.com.celfons.domain.PoiEntity
import br.com.celfons.repository.PoiRepository
import br.com.celfons.service.PoiService
import br.com.celfons.service.impl.PoiServiceImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [XyIncApplication::class])
class PoiTest {

    final var repository: PoiRepository = Mockito.mock(PoiRepository::class.java)

    @InjectMocks
    var service: PoiService = PoiServiceImpl(repository)

    @Test
    fun findByProximity() {
        val poiEntity = PoiEntity(1, "test", 0, 0)
        Mockito.`when`(repository.findAll()).thenReturn(listOf(poiEntity))
        val pois = service.findByProximity(0,0,0)
        assertNotNull(pois)
        assertEquals(1, pois.size)
        assertEquals(poiEntity.name, pois[0].name)
    }

    @Test
    fun findByProximityIsEmpty() {
        val poiEntity = PoiEntity(1, "test", 50, 50)
        Mockito.`when`(repository.findAll()).thenReturn(listOf(poiEntity))
        val exception = assertThrows(BusinessException::class.java) {
            service.findByProximity(0,0,0)
        }
        assertEquals("No have proximity points", exception.message)
    }

}