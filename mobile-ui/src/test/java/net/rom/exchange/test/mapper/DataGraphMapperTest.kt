package net.rom.exchange.test.mapper

import net.rom.exchange.mapper.DataGraphViewModelMapper
import net.rom.exchange.test.test.factory.DataGraphFactory
import org.joda.time.DateTimeUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class DataGraphMapperTest {

    private lateinit var dataGraphMapper: DataGraphViewModelMapper

    @Before
    fun setUp() {
        DateTimeUtils.setCurrentMillisFixed(12345556666L)
        dataGraphMapper = DataGraphViewModelMapper()
    }

    @Test
    fun mapToViewMapsData() {
        val dataGraphFactory = DataGraphFactory.makeDataGraphView()
        val viewModel = dataGraphMapper.mapToView(dataGraphFactory)

        assertEquals(0.0F, viewModel.x)
        assertEquals(dataGraphFactory.price.toFloat(), viewModel.y)
    }

}