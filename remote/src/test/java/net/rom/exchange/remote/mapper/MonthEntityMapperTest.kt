package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ROMExchangeFactory
import net.rom.exchange.remote.mapper.rom.DataItemEntityMapper
import net.rom.exchange.remote.mapper.rom.WeekEntityMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MonthEntityMapperTest {

    private lateinit var weekItemMapper: WeekEntityMapper

    @Before
    fun setUp() {
        weekItemMapper = WeekEntityMapper(DataItemEntityMapper())
    }

    @Test
    fun mapFromRemoteMapsData() {
        val dataItemModel = ROMExchangeFactory.makeWeekModel()
        val dataItemEntity = weekItemMapper.mapFromRemote(dataItemModel)

        assertEquals(dataItemModel.data?.size, dataItemEntity.data.size)
        assertEquals(dataItemModel.change, dataItemEntity.change)
    }

}