package net.rom.exchange.remote.mapper

import net.rom.exchange.remote.factory.ROMExchangeFactory
import net.rom.exchange.remote.mapper.rom.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ItemEntityMapperTest {

    private lateinit var itemEntityMapper: ItemEntityMapper

    @Before
    fun setUp() {
        itemEntityMapper = ItemEntityMapper(
                globalEntityMapper = GlobalEntityMapper(
                        allEntityMapper = AllEntityMapper(DataItemEntityMapper()),
                        weekEntityMapper = WeekEntityMapper(DataItemEntityMapper()),
                        monthEntityMapper = MonthEntityMapper(DataItemEntityMapper())
                ),
                seaEntityMapper = SeaEntityMapper(
                        allEntityMapper = AllEntityMapper(DataItemEntityMapper()),
                        weekEntityMapper = WeekEntityMapper(DataItemEntityMapper()),
                        monthEntityMapper = MonthEntityMapper(DataItemEntityMapper()
                        )

                )
        )
    }

    @Test
    fun mapFromRemoteMapsData() {
        val itemModel = ROMExchangeFactory.makeItemModel()
        val itemEntity = itemEntityMapper.mapFromRemote(itemModel)

        assertEquals(itemModel.image, itemEntity.image)
        assertEquals(itemModel.name, itemEntity.name)
        assertEquals(itemModel.type, itemEntity.type)
        assertEquals(itemModel.globalSeaDiff, itemEntity.globalSeaDiff)
    }

}