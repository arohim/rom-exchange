package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.Month
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.rom.DataItemViewMapper
import net.rom.exchange.presentation.mapper.rom.MonthViewMapper
import net.rom.exchange.presentation.model.rom.MonthView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MonthEntityMapperTest {

    private lateinit var monthViewMapper: MonthViewMapper

    @Before
    fun setUp() {
        monthViewMapper = MonthViewMapper(DataItemViewMapper())
    }

    @Test
    fun mapFromDataMapsView() {
        // GIVEN
        val domain = ItemExchangeFactory.makeMonth()

        // WHEN
        val view = monthViewMapper.mapToView(domain)

        // THEN
        assertDataEquality(domain, view)
    }

    private fun assertDataEquality(domain: Month, view: MonthView) {
        assertEquals(domain.data.size, view.data.size)
        assertEquals(domain.change, view.change, 0.0)
    }
}