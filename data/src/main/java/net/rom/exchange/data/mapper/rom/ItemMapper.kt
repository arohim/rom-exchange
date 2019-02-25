package net.rom.exchange.data.mapper.rom

import net.rom.exchange.data.mapper.Mapper
import net.rom.exchange.data.model.rom.ItemExchangeEntity
import net.rom.exchange.domain.model.rom.ItemExchange
import javax.inject.Inject

class ItemMapper @Inject constructor(private val globalMapper: GlobalMapper, private val seaMapper: SeaMapper) : Mapper<ItemExchangeEntity, ItemExchange> {
    override fun mapFromEntity(type: ItemExchangeEntity): ItemExchange {
        return ItemExchange(
                image = type.image,
                name = type.name,
                global = globalMapper.mapFromEntity(type.global),
                type = type.type,
                sea = seaMapper.mapFromEntity(type.sea),
                globalSeaDiff = type.globalSeaDiff
        )
    }

    override fun mapToEntity(type: ItemExchange): ItemExchangeEntity {
        return ItemExchangeEntity(
                image = type.image,
                name = type.name,
                global = globalMapper.mapToEntity(type.global),
                type = type.type,
                sea = seaMapper.mapToEntity(type.sea),
                globalSeaDiff = type.globalSeaDiff
        )
    }
}