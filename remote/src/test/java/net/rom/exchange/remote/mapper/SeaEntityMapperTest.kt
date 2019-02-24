package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ItemExchangeFactory
import net.rom.exchange.remote.mapper.rom.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class SeaEntityMapperTest {

    private lateinit var seaEntityMapper: SeaEntityMapper

    @Before
    fun setUp() {
        seaEntityMapper = SeaEntityMapper(
                allEntityMapper = AllEntityMapper(DataItemEntityMapper()),
                weekEntityMapper = WeekEntityMapper(DataItemEntityMapper()),
                monthEntityMapper = MonthEntityMapper(DataItemEntityMapper())
        )
    }

    @Test
    fun mapFromRemoteMapsData() {
        val seaModel = ItemExchangeFactory.makeSeaModel()
        val seaEntity = seaEntityMapper.mapFromRemote(seaModel)

        assertEquals(seaModel.all?.data?.size, seaEntity.all.data.size)
        assertEquals(seaModel.week?.data?.size, seaEntity.week.data.size)
        assertEquals(seaModel.month?.data?.size, seaEntity.month.data.size)
        assertEquals(seaModel.latest, seaEntity.latest)
    }

}