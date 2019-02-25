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
        assertEquals("${romExchangeItem.seaPrice}z", romExchangeViewModel.seaPrice)
        assertEquals("${romExchangeItem.seaChange}%", romExchangeViewModel.seaChange)
        assertEquals("${romExchangeItem.globalChange}%", romExchangeViewModel.globalChange)
        assertEquals("${romExchangeItem.globalPrice}z", romExchangeViewModel.globalPrice)
    }

}