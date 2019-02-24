package net.rom.exchange.data.mapper

import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.mapper.rom.DataItemMapper
import net.rom.exchange.data.model.rom.DataItemEntity
import net.rom.exchange.domain.model.rom.DataItem
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class DataItemEntityMapperTest {

    private lateinit var dataItemMapper: DataItemMapper

    @Before
    fun setUp() {
        dataItemMapper = DataItemMapper()
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeDataItemEntity()

        // WHEN
        val dataItemEntity = dataItemMapper.mapFromEntity(data)

        // THEN
        assertDataItemEquality(data, dataItemEntity)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val data = ItemExchangeFactory.makeDataItem()

        // WHEN
        val dataItemEntity = dataItemMapper.mapToEntity(data)

        // THEN
        assertDataItemEquality(dataItemEntity, data)
    }

    private fun assertDataItemEquality(entity: DataItemEntity, data: DataItem) {
        assertEquals(entity.price, data.price)
        assertEquals(entity.time, data.time)
        assertEquals(entity.snap, data.snap)
    }
}