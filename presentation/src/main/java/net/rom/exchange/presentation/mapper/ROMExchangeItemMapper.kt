package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.Item
import net.rom.exchange.presentation.model.ROMExchangeItemView
import javax.inject.Inject

open class ROMExchangeItemMapper @Inject constructor() : Mapper<ROMExchangeItemView, Item> {
    override fun mapToView(type: Item): ROMExchangeItemView {
        return ROMExchangeItemView(
                name = type.name,
                seaPrice = type.sea.latest.toString(),
                globalPrice = type.global.latest.toString(),
                seaChange = type.sea.all.change.toString(),
                globalChange = type.global.all.change.toString()
        )
    }
}