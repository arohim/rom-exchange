package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ItemExchangeFactory
import net.rom.exchange.remote.mapper.rom.DataItemEntityMapper
import net.rom.exchange.remote.mapper.rom.WeekEntityMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class WeekEntityMapperTest {

    private lateinit var weekItemMapper: WeekEntityMapper

    @Before
    fun setUp() {
        weekItemMapper = WeekEntityMapper(DataItemEntityMapper())
    }

    @Test
    fun mapFromRemoteMapsData() {
        val weekItemModel = ItemExchangeFactory.makeWeekModel()
        val weekItemEntity = weekItemMapper.mapFromRemote(weekItemModel)

        assertEquals(weekItemModel.data?.size, weekItemEntity.data.size)
        assertEquals(weekItemModel.change, weekItemEntity.change)
    }

}