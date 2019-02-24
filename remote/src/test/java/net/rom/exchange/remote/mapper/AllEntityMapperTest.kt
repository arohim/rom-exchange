package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ItemExchangeFactory
import net.rom.exchange.remote.mapper.rom.AllEntityMapper
import net.rom.exchange.remote.mapper.rom.DataItemEntityMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class AllEntityMapperTest {

    private lateinit var allEntityMapper: AllEntityMapper

    @Before
    fun setUp() {
        allEntityMapper = AllEntityMapper(DataItemEntityMapper())
    }

    @Test
    fun mapFromRemoteMapsData() {
        val allModel = ItemExchangeFactory.makeAllModel()
        val allEntity = allEntityMapper.mapFromRemote(allModel)

        assertEquals(allModel.data?.size, allEntity.data.size)
        assertEquals(allModel.change, allEntity.change)
    }

}