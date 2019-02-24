package net.rom.exchange.data.mapper

import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.mapper.rom.*
import net.rom.exchange.data.model.rom.GlobalEntity
import net.rom.exchange.domain.model.rom.Global
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class GlobalEntityMapperTest {

    private lateinit var globalMapper: GlobalMapper

    @Before
    fun setUp() {
        val dataItemMapper = DataItemMapper()
        globalMapper = GlobalMapper(
                allMapper = AllMapper(dataItemMapper),
                weekMapper = WeekMapper(dataItemMapper),
                monthMapper = MonthMapper(dataItemMapper)
        )
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val entity = ItemExchangeFactory.makeGlobalEntity()

        // WHEN
        val data = globalMapper.mapFromEntity(entity)

        // THEN
        assertDataEquality(entity, data)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeGlobal()

        // WHEN
        val entity = globalMapper.mapToEntity(data)

        // THEN
        assertDataEquality(entity, data)
    }

    private fun assertDataEquality(entity: GlobalEntity, data: Global) {
        assertEquals(data.all.data.size, entity.all.data.size)
        assertEquals(data.week.data.size, entity.week.data.size)
        assertEquals(data.month.data.size, entity.month.data.size)
        assertEquals(data.latest, entity.latest)
    }
}