package net.rom.exchange.test.test.factory

import net.rom.exchange.presentation.model.ItemExchangeView
import net.rom.exchange.test.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for ItemExchange related instances
 */
class ROMExchangeFactory {

    companion object Factory {

        fun makeROMExchangeItemView(): ItemExchangeView {
            return ItemExchangeView(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
        }
    }

}