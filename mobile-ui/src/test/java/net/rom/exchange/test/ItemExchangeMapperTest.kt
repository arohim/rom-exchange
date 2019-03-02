package net.rom.exchange.test

import net.rom.exchange.mapper.ItemExchangeMapper
import net.rom.exchange.test.test.factory.ItemExchangeFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ItemExchangeMapperTest {

    private lateinit var rOMExchangeItemMapper: ItemExchangeMapper

    @Before
    fun setUp() {
        rOMExchangeItemMapper = ItemExchangeMapper()
    }

    @Test
    fun mapToViewMapsData() {
        val romExchangeItem = ItemExchangeFactory.makeItemExchangeItemView()
        val romExchangeViewModel = rOMExchangeItemMapper.mapToViewModel(romExchangeItem)

        assertEquals(romExchangeItem.name, romExchangeViewModel.name)
        assertEquals("${romExchangeItem.sea.latest}z", romExchangeViewModel.seaPrice)
        assertEquals("${romExchangeItem.sea.all.change}%", romExchangeViewModel.seaChange)
        assertEquals("${romExchangeItem.global.all.change}%", romExchangeViewModel.globalChange)
        assertEquals("${romExchangeItem.global.latest}z", romExchangeViewModel.globalPrice)
    }

}