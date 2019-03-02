package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.Week
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.rom.DataItemViewMapper
import net.rom.exchange.presentation.mapper.rom.WeekViewMapper
import net.rom.exchange.presentation.model.rom.WeekView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeekEntityMapperTest {

    private lateinit var weekViewMapper: WeekViewMapper

    @Before
    fun setUp() {
        weekViewMapper = WeekViewMapper(DataItemViewMapper())
    }

    @Test
    fun mapFromDataMapsView() {
        // GIVEN
        val domain = ItemExchangeFactory.makeWeek()

        // WHEN
        val view = weekViewMapper.mapToView(domain)

        // THEN
        assertDataEquality(domain, view)
    }

    private fun assertDataEquality(domain: Week, view: WeekView) {
        assertEquals(domain.data.size, view.data.size)
        assertEquals(domain.change, view.change, 0.0)
    }
}