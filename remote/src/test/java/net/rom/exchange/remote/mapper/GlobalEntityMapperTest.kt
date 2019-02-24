package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ItemExchangeFactory
import net.rom.exchange.remote.mapper.rom.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class GlobalEntityMapperTest {

    private lateinit var globalEntityMapper: GlobalEntityMapper

    @Before
    fun setUp() {
        globalEntityMapper = GlobalEntityMapper(
                allEntityMapper = AllEntityMapper(DataItemEntityMapper()),
                weekEntityMapper = WeekEntityMapper(DataItemEntityMapper()),
                monthEntityMapper = MonthEntityMapper(DataItemEntityMapper())
        )
    }

    @Test
    fun mapFromRemoteMapsData() {
        val globalModel = ItemExchangeFactory.makeGlobalModel()
        val globalEntity = globalEntityMapper.mapFromRemote(globalModel)

        assertEquals(globalModel.all?.data?.size, globalEntity.all.data.size)
        assertEquals(globalModel.week?.data?.size, globalEntity.week.data.size)
        assertEquals(globalModel.month?.data?.size, globalEntity.month.data.size)
        assertEquals(globalModel.latest, globalEntity.latest)
    }

}