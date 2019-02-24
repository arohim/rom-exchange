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
        val entity = ItemExchangeFactory.makeMonthEntity()

        // WHEN
        val data = monthMapper.mapFromEntity(entity)

        // THEN
        assertDataEquality(entity, data)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeMonth()

        // WHEN
        val entity = monthMapper.mapToEntity(data)

        // THEN
        assertDataEquality(entity, data)
    }

    private fun assertDataEquality(entity: MonthEntity, data: Month) {
        assertEquals(entity.data.size, data.data.size)
        assertEquals(entity.change, data.change)
    }
}