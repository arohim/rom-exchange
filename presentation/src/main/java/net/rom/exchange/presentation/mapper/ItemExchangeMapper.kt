package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.ItemExchange
import net.rom.exchange.presentation.model.ItemExchangeView
import javax.inject.Inject

open class ItemExchangeMapper @Inject constructor() : Mapper<ItemExchangeView, ItemExchange> {
    override fun mapToView(type: ItemExchange): ItemExchangeView {
        return ItemExchangeView(
                name = type.name,
                seaPrice = type.sea.latest.toString(),
                globalPrice = type.global.latest.toString(),
                seaChange = type.sea.all.change.toString(),
                globalChange = type.global.all.change.toString()
        )
    }
}