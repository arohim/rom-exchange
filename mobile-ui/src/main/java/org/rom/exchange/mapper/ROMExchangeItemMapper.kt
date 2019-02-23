package org.rom.exchange.mapper

import org.rom.exchange.presentation.model.BufferooView
import org.rom.exchange.model.ROMExchangeItemViewModel
import org.rom.exchange.presentation.model.ROMExchangeItemView
import javax.inject.Inject

/**
 * Map a [BufferooView] to and from a [ROMExchangeItemViewModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class ROMExchangeItemMapper @Inject constructor() : Mapper<ROMExchangeItemViewModel, ROMExchangeItemView> {
    override fun mapToViewModel(type: ROMExchangeItemView): ROMExchangeItemViewModel {
        return ROMExchangeItemViewModel(
                name = type.name,
                globalPrice = "${type.globalPrice}z",
                seaPrice = "${type.seaPrice}z",
                globalChange = "${type.globalChange}%",
                seaChange = "${type.seaChange}%"
        )
    }
}