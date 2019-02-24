package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.Item
import net.rom.exchange.presentation.model.ItemExchangeView
import javax.inject.Inject

open class ItemExchangeMapper @Inject constructor() : Mapper<ItemExchangeView, Item> {
    override fun mapToView(type: Item): ItemExchangeView {
        return ItemExchangeView(
                name = type.name,
                seaPrice = type.sea.latest.toString(),
                globalPrice = type.global.latest.toString(),
                seaChange = type.sea.all.change.toString(),
                globalChange = type.global.all.change.toString()
        )
    }
}