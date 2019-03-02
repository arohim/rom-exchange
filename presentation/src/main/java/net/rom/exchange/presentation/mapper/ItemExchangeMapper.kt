package net.rom.exchange.presentation.mapper

import net.rom.exchange.domain.model.rom.ItemExchange
import net.rom.exchange.presentation.model.ItemExchangeView
import javax.inject.Inject

open class ItemExchangeMapper @Inject constructor() : Mapper<ItemExchangeView, ItemExchange> {
    override fun mapToView(type: ItemExchange): ItemExchangeView {
        return ItemExchangeView(
                image = type.image,
                name = type.name,
                sea = type.sea,
                global = type.global,
                type = type.type,
                globalSeaDiff = type.globalSeaDiff
        )
    }
}