package net.rom.exchange.model

/**
 * Representation for a [ItemExchangeViewModel] fetched from an external layer data source
 */
class ItemExchangeViewModel(
        val name: String,
        val globalPrice: String,
        val seaPrice: String,
        val globalChange: String,
        val seaChange: String
)