package net.rom.exchange.presentation.factory

import net.rom.exchange.domain.factory.DataFactory
import java.util.concurrent.ThreadLocalRandom

/**
 * Factory class for data instances
 */
class DataFactory {

    companion object Factory {

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }

        fun randomDouble(): Double {
            return DataFactory.randomInt().toDouble()
        }

        fun randomInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
        }

    }

}