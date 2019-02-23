package org.rom.exchange.domain.model.rom

data class Item(val image: Any, val name: String, val global: Global, val type: Int, val sea: Sea, val globalSeaDiff: Double)