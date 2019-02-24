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
        val dataItem = ItemExchangeFactory.makeDataItemEntity()

        // WHEN
        val dataItemEntity = dataItemMapper.mapFromEntity(dataItem)

        // THEN
        assertDataItemEquality(dataItem, dataItemEntity)
    }

    @Test
    fun mapToEntityMapsData() {
        // GIVEN
        val dataItem = ItemExchangeFactory.makeDataItem()

        // WHEN
        val dataItemEntity = dataItemMapper.mapToEntity(dataItem)

        // THEN
        assertDataItemEquality(dataItemEntity, dataItem)
    }

    private fun assertDataItemEquality(dataItemEntity: DataItemEntity, dataItem: DataItem) {
        assertEquals(dataItemEntity.price, dataItem.price)
        assertEquals(dataItemEntity.time, dataItem.time)
        assertEquals(dataItemEntity.snap, dataItem.snap)
    }
}