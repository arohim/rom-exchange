package net.rom.exchange.mapper

import net.rom.exchange.model.ItemExchangeViewModel
import net.rom.exchange.presentation.model.rom.ItemExchangeView
import javax.inject.Inject

/**
 * Map a [ItemExchangeView] to and from a [ItemExchangeViewModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class ItemExchangeMapper @Inject constructor() : Mapper<ItemExchangeViewModel, ItemExchangeView> {
    override fun mapToViewModel(type: ItemExchangeView): ItemExchangeViewModel {
        return ItemExchangeViewModel(
                name = type.name,
                globalPrice = "${type.global.latest}z",
                seaPrice = "${type.sea.latest}z",
                globalChange = "${type.global.all.change}%",
                seaChange = "${type.sea.all.change}%"
        )
    }
}