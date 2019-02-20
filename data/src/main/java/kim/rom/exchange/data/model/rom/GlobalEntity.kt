package kim.rom.exchange.data.model.rom

import kim.rom.exchange.domain.model.rom.All
import kim.rom.exchange.domain.model.rom.Month
import kim.rom.exchange.domain.model.rom.Week

data class GlobalEntity(val all: All, val week: Week, val month: Month, val latest: Int)