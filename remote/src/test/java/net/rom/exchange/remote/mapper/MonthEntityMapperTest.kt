package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ROMExchangeFactory
import net.rom.exchange.remote.mapper.rom.DataItemEntityMapper
import net.rom.exchange.remote.mapper.rom.MonthEntityMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MonthEntityMapperTest {

    private lateinit var monthEntityMapper: MonthEntityMapper

    @Before
    fun setUp() {
        monthEntityMapper = MonthEntityMapper(DataItemEntityMapper())
    }

    @Test
    fun mapFromRemoteMapsData() {
        val monthModel = ROMExchangeFactory.makeMonthModel()
        val monthEntity = monthEntityMapper.mapFromRemote(monthModel)

        assertEquals(monthModel.data?.size, monthEntity.data.size)
        assertEquals(monthModel.change, monthEntity.change)
    }

}