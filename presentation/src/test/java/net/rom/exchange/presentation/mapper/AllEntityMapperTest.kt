package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.All
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.rom.AllViewMapper
import net.rom.exchange.presentation.mapper.rom.DataItemViewMapper
import net.rom.exchange.presentation.model.rom.AllView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AllEntityMapperTest {

    private lateinit var allViewMapper: AllViewMapper

    @Before
    fun setUp() {
        allViewMapper = AllViewMapper(DataItemViewMapper())
    }

    @Test
    fun mapFromDataMapsView() {
        // GIVEN
        val domain = ItemExchangeFactory.makeAll()

        // WHEN
        val view = allViewMapper.mapToView(domain)

        // THEN
        assertDataEquality(domain, view)
    }

    private fun assertDataEquality(domain: All, view: AllView) {
        assertEquals(domain.data.size, view.data.size)
        assertEquals(domain.change, view.change, 0.0)
    }
}