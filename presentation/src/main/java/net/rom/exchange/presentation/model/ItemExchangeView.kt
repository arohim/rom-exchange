package net.rom.exchange.presentation.model

import net.rom.exchange.domain.model.rom.Global
import net.rom.exchange.domain.model.rom.Sea

/**
 * Representation for a [ItemExchangeView] instance for this layers Model representation
 */
data class ItemExchangeView(val image: Any, val name: String, val global: Global, val type: Int,
                            val sea: Sea, val globalSeaDiff: Double)