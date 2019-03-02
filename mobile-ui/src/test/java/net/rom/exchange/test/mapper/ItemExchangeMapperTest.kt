package net.rom.exchange.test.mapper

import net.rom.exchange.mapper.DataGraphViewModelMapper
import net.rom.exchange.mapper.ItemExchangeViewModelMapper
import net.rom.exchange.test.test.factory.ItemExchangeFactory
import org.joda.time.DateTimeUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ItemExchangeMapperTest {

    private lateinit var rOMExchangeItemMapper: ItemExchangeViewModelMapper

    @Before
    fun setUp() {
        DateTimeUtils.setCurrentMillisFixed(12345556666L)
        rOMExchangeItemMapper = ItemExchangeViewModelMapper(DataGraphViewModelMapper())
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