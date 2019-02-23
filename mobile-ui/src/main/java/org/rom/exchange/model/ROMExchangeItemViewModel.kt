package org.rom.exchange.model

/**
 * Representation for a [ROMExchangeItemViewModel] fetched from an external layer data source
 */
class ROMExchangeItemViewModel(
        val name: String,
        val globalPrice: String,
        val seaPrice: String,
        val globalChange: String,
        val seaChange: String
)