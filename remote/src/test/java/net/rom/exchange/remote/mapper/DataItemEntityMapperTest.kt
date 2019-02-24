package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ItemExchangeFactory
import net.rom.exchange.remote.mapper.rom.DataItemEntityMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class DataItemEntityMapperTest {

    private lateinit var dataItemEntityMapper: DataItemEntityMapper

    @Before
    fun setUp() {
        dataItemEntityMapper = DataItemEntityMapper()
    }

    @Test
    fun mapFromRemoteMapsData() {
        val dataItemModel = ItemExchangeFactory.makeDataItemModel()
        val dataItemEntity = dataItemEntityMapper.mapFromRemote(dataItemModel)

        assertEquals(dataItemModel.price, dataItemEntity.price)
        assertEquals(dataItemModel.time, dataItemEntity.time)
        assertEquals(dataItemModel.snap, dataItemEntity.snap)
    }

}