package kim.rom.exchange.mapper

import kim.rom.exchange.presentation.model.BufferooView
import kim.rom.exchange.model.ROMExchangeItemViewModel
import kim.rom.exchange.presentation.model.ROMExchangeItemView
import javax.inject.Inject

/**
 * Map a [BufferooView] to and from a [ROMExchangeItemViewModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class ROMExchangeItemMapper @Inject constructor() : Mapper<ROMExchangeItemViewModel, ROMExchangeItemView> {
    override fun mapToViewModel(type: ROMExchangeItemView): ROMExchangeItemViewModel {
        return ROMExchangeItemViewModel(type.name, type.title, type.avatar)
    }
}