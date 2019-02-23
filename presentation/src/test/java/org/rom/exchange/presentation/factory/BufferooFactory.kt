package org.rom.exchange.presentation.factory

import org.rom.exchange.domain.model.Bufferoo
import org.rom.exchange.presentation.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooList(count: Int): List<Bufferoo> {
            val bufferoos = mutableListOf<Bufferoo>()
            repeat(count) {
                bufferoos.add(makeBufferooModel())
            }
            return bufferoos
        }

        fun makeBufferooModel(): Bufferoo {
            return Bufferoo(randomUuid(), randomUuid(), randomUuid())
        }

    }

}