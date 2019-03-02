package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.domain.model.rom.ItemExchange
import net.rom.exchange.presentation.mapper.Mapper
import net.rom.exchange.presentation.model.rom.ItemExchangeView
import javax.inject.Inject

open class ItemExchangeMapper @Inject constructor(val seaViewMapper: SeaViewMapper, val globalViewMapper: GlobalViewMapper) : Mapper<ItemExchangeView, ItemExchange> {
    override fun mapToView(type: ItemExchange): ItemExchangeView {
        return ItemExchangeView(
                image = type.image,
                name = type.name,
                sea = seaViewMapper.mapToView(type.sea),
                global = globalViewMapper.mapToView(type.global),
                type = type.type,
                globalSeaDiff = type.globalSeaDiff
        )
    }
}