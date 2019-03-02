package net.rom.exchange.presentation.model.rom


/**
 * Representation for a [ItemExchangeView] instance for this layers Model representation
 */
data class ItemExchangeView(val image: Any, val name: String, val global: GlobalView, val type: Int,
                            val sea: SeaView, val globalSeaDiff: Double)