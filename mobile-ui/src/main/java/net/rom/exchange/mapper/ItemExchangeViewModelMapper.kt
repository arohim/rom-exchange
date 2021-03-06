package net.rom.exchange.mapper

import com.github.mikephil.charting.formatter.PercentFormatter
import net.rom.exchange.formater.ZenyFormatter
import net.rom.exchange.model.ItemExchangeViewModel
import net.rom.exchange.presentation.model.rom.ItemExchangeView
import javax.inject.Inject

/**
 * Map a [ItemExchangeView] to and from a [ItemExchangeViewModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class ItemExchangeViewModelMapper @Inject constructor(private val dataGraphViewModelMapper: DataGraphViewModelMapper) : Mapper<ItemExchangeViewModel, ItemExchangeView> {
    override fun mapToViewModel(type: ItemExchangeView): ItemExchangeViewModel {
        return ItemExchangeViewModel(
                name = type.name,
                globalPrice = ZenyFormatter.makeZeny(type.global.latest),
                seaPrice = ZenyFormatter.makeZeny(type.sea.latest),
                globalChange = PercentFormatter().getFormattedValue(type.global.all.change.toFloat(), null),
                seaChange = PercentFormatter().getFormattedValue(type.sea.all.change.toFloat(), null),
                seaDataSet = type.sea.all.data.map { dataGraphViewModelMapper.mapToView(it) }.distinctBy { it.x }, //TODO: select only the highest price of the month
                globalDataSet = type.global.all.data.map { dataGraphViewModelMapper.mapToView(it) }.distinctBy { it.x }  //TODO: select only the highest price of the month
        )
    }
}