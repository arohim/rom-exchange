package net.rom.exchange.data.mapper

import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.mapper.rom.*
import net.rom.exchange.data.model.rom.SeaEntity
import net.rom.exchange.domain.model.rom.Sea
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class SeaEntityMapperTest {

    private lateinit var seaMapper: SeaMapper

    @Before
    fun setUp() {
        val dataItemMapper = DataItemMapper()
        seaMapper = SeaMapper(
                allMapper = AllMapper(dataItemMapper),
                weekMapper = WeekMapper(dataItemMapper),
                monthMapper = MonthMapper(dataItemMapper)
        )
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val entity = ItemExchangeFactory.makeSeaEntity()

        // WHEN
        val data = seaMapper.mapFromEntity(entity)

        // THEN
        assertDataEquality(entity, data)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeSea()

        // WHEN
        val entity = seaMapper.mapToEntity(data)

        // THEN
        assertDataEquality(entity, data)
    }

    private fun assertDataEquality(entity: SeaEntity, data: Sea) {
        assertEquals(data.all.data.size, entity.all.data.size)
        assertEquals(data.week.data.size, entity.week.data.size)
        assertEquals(data.month.data.size, entity.month.data.size)
        assertEquals(data.latest, entity.latest)
    }
}