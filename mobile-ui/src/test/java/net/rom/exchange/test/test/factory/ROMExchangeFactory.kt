package net.rom.exchange.test.test.factory

import net.rom.exchange.presentation.model.ROMExchangeItemView
import net.rom.exchange.test.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for ROMExchange related instances
 */
class ROMExchangeFactory {

    companion object Factory {

        fun makeROMExchangeItemView(): ROMExchangeItemView {
            return ROMExchangeItemView(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
        }
    }

}