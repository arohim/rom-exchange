package net.rom.exchange.data.mapper

import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.mapper.rom.DataItemMapper
import net.rom.exchange.data.mapper.rom.MonthMapper
import net.rom.exchange.data.model.rom.MonthEntity
import net.rom.exchange.domain.model.rom.Month
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MonthEntityMapperTest {

    private lateinit var monthMapper: MonthMapper

    @Before
    fun setUp() {
        monthMapper = MonthMapper(DataItemMapper())
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeMonthEntity()

        // WHEN
        val entity = monthMapper.mapFromEntity(data)

        // THEN
        assertDataEquality(data, entity)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val dataItem = ItemExchangeFactory.makeMonth()

        // WHEN
        val dataItemEntity = monthMapper.mapToEntity(dataItem)

        // THEN
        assertDataEquality(dataItemEntity, dataItem)
    }

    private fun assertDataEquality(entity: MonthEntity, data: Month) {
        assertEquals(entity.data.size, data.data.size)
        assertEquals(entity.change, data.change)
    }
}