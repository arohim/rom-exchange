package net.rom.exchange.presentation.model

/**
 * Representation for a [ItemExchangeView] instance for this layers Model representation
 */
data class ItemExchangeView(val name: String,
                            val globalPrice: String,
                            val seaPrice: String,
                            val globalChange: String,
                            val seaChange: String)