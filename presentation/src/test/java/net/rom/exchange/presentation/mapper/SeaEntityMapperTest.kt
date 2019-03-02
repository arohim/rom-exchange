package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.Sea
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.rom.*
import net.rom.exchange.presentation.model.rom.SeaView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SeaEntityMapperTest {

    private lateinit var seaViewMapper: SeaViewMapper

    @Before
    fun setUp() {
        val dataItemViewMapper = DataItemViewMapper()
        seaViewMapper = SeaViewMapper(
                allMapper = AllViewMapper(dataItemViewMapper),
                weekMapper = WeekViewMapper(dataItemViewMapper),
                monthMapper = MonthViewMapper(dataItemViewMapper)
        )
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val domain = ItemExchangeFactory.makeSea()

        // WHEN
        val view = seaViewMapper.mapToView(domain)

        // THEN
        assertDataEquality(view, domain)
    }

    private fun assertDataEquality(view: SeaView, domain: Sea) {
        assertEquals(domain.all.data.size, view.all.data.size)
        assertEquals(domain.week.data.size, view.week.data.size)
        assertEquals(domain.month.data.size, view.month.data.size)
        assertEquals(domain.latest, view.latest)
    }
}