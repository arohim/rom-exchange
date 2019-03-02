package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.Global
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.rom.*
import net.rom.exchange.presentation.model.rom.GlobalView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GlobalEntityMapperTest {

    private lateinit var globalMapper: GlobalViewMapper

    @Before
    fun setUp() {
        val dataItemViewMapper = DataItemViewMapper()
        globalMapper = GlobalViewMapper(
                allMapper = AllViewMapper(dataItemViewMapper),
                weekMapper = WeekViewMapper(dataItemViewMapper),
                monthMapper = MonthViewMapper(dataItemViewMapper)
        )
    }

    @Test
    fun mapFromEntityMapsData() {
        // GIVEN
        val domain = ItemExchangeFactory.makeGlobal()

        // WHEN
        val view = globalMapper.mapToView(domain)

        // THEN
        assertDataEquality(domain, view)
    }

    private fun assertDataEquality(domain: Global, view: GlobalView) {
        assertEquals(view.all.data.size, domain.all.data.size)
        assertEquals(view.week.data.size, domain.week.data.size)
        assertEquals(view.month.data.size, domain.month.data.size)
        assertEquals(view.latest, domain.latest)
    }
}