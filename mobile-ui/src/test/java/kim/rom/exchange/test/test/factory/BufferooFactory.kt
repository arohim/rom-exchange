package kim.rom.exchange.test.test.factory

import kim.rom.exchange.presentation.model.BufferooView
import kim.rom.exchange.test.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}