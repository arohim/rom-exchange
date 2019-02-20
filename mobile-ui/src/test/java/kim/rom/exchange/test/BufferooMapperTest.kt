package kim.rom.exchange.test

import kim.rom.exchange.mapper.ROMExchangeItemMapper
import kim.rom.exchange.test.test.factory.BufferooFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class BufferooMapperTest {

    private lateinit var bufferooMapper: ROMExchangeItemMapper

    @Before
    fun setUp() {
        bufferooMapper = ROMExchangeItemMapper()
    }

    @Test
    fun mapToViewMapsData() {
        val bufferooView = BufferooFactory.makeBufferooView()
        val bufferooViewModel = bufferooMapper.mapToViewModel(bufferooView)

        assertEquals(bufferooView.name, bufferooViewModel.name)
        assertEquals(bufferooView.title, bufferooViewModel.price)
        assertEquals(bufferooView.avatar, bufferooViewModel.avatar)
    }

}