package org.rom.exchange.presentation.model

/**
 * Representation for a [ROMExchangeItemView] instance for this layers Model representation
 */
data class ROMExchangeItemView(val name: String,
                               val globalPrice: String,
                               val seaPrice: String,
                               val globalChange: String,
                               val seaChange: String)