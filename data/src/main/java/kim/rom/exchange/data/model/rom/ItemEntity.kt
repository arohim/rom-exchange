package kim.rom.exchange.data.model.rom

import kim.rom.exchange.domain.model.rom.Global
import kim.rom.exchange.domain.model.rom.Sea

data class ItemEntity(val image: Any, val name: String, val global: Global, val type: Int, val sea: Sea, val globalSeaDiff: Int)