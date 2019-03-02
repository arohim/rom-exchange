package net.rom.exchange.test.test.factory

import net.rom.exchange.presentation.model.rom.DataItemView
import net.rom.exchange.test.test.factory.DataFactory.Factory.randomInt

/**
 * Factory class for DataGraphFactory related instances
 */
class DataGraphFactory {

    companion object Factory {

        fun makeDataGraphView(): DataItemView {
            return DataItemView(randomInt(), "2019-01-23T21:44:03Z", false)
        }
    }

}