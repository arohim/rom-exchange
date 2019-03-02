package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.DataItem
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.rom.DataItemViewMapper
import net.rom.exchange.presentation.model.rom.DataItemView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DataItemViewMapperTest {

    private lateinit var dataItemMapper: DataItemViewMapper

    @Before
    fun setUp() {
        dataItemMapper = DataItemViewMapper()
    }

    @Test
    fun mapFromDataMapsView() {
        // GIVEN
        val domain = ItemExchangeFactory.makeDataItem()

        // WHEN
        val view = dataItemMapper.mapToView(domain)

        // THEN
        assertDataItemEquality(domain, view)
    }

    private fun assertDataItemEquality(domain: DataItem, view: DataItemView) {
        assertEquals(domain.price, view.price)
        assertEquals(domain.time, view.time)
        assertEquals(domain.snap, view.snap)
    }
}