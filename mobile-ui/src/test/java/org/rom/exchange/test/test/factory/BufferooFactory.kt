package org.rom.exchange.test.test.factory

import org.rom.exchange.presentation.model.BufferooView
import org.rom.exchange.test.test.factory.DataFactory.Factory.randomUuid

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