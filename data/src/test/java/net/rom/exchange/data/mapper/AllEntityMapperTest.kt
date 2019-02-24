package net.rom.exchange.data.mapper

import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.mapper.rom.AllMapper
import net.rom.exchange.data.mapper.rom.DataItemMapper
import net.rom.exchange.data.model.rom.AllEntity
import net.rom.exchange.domain.model.rom.All
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class AllEntityMapperTest {

    private lateinit var allMapper: AllMapper

    @Before
    fun setUp() {
        allMapper = AllMapper(DataItemMapper())
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeAllEntity()

        // WHEN
        val entity = allMapper.mapFromEntity(data)

        // THEN
        assertDataEquality(data, entity)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val dataItem = ItemExchangeFactory.makeAll()

        // WHEN
        val dataItemEntity = allMapper.mapToEntity(dataItem)

        // THEN
        assertDataEquality(dataItemEntity, dataItem)
    }

    private fun assertDataEquality(entity: AllEntity, data: All) {
        assertEquals(entity.data.size, data.data.size)
        assertEquals(entity.change, data.change)
    }
}