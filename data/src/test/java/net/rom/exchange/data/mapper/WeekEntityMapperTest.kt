package net.rom.exchange.data.mapper

import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.mapper.rom.DataItemMapper
import net.rom.exchange.data.mapper.rom.WeekMapper
import net.rom.exchange.data.model.rom.WeekEntity
import net.rom.exchange.domain.model.rom.Week
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class WeekEntityMapperTest {

    private lateinit var weekMapper: WeekMapper

    @Before
    fun setUp() {
        weekMapper = WeekMapper(DataItemMapper())
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeWeekEntity()

        // WHEN
        val entity = weekMapper.mapFromEntity(data)

        // THEN
        assertDataEquality(data, entity)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val dataItem = ItemExchangeFactory.makeWeek()

        // WHEN
        val dataItemEntity = weekMapper.mapToEntity(dataItem)

        // THEN
        assertDataEquality(dataItemEntity, dataItem)
    }

    private fun assertDataEquality(entity: WeekEntity, data: Week) {
        assertEquals(entity.data.size, data.data.size)
        assertEquals(entity.change, data.change)
    }
}