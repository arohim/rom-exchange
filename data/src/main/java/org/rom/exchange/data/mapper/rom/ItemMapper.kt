package org.rom.exchange.data.mapper.rom

import org.rom.exchange.data.mapper.Mapper
import org.rom.exchange.data.model.rom.*
import org.rom.exchange.domain.model.rom.Item
import javax.inject.Inject

class ItemMapper @Inject constructor(private val globalMapper: GlobalMapper, private val seaMapper: SeaMapper) : Mapper<ItemEntity, Item> {
    override fun mapFromEntity(type: ItemEntity): Item {
        return Item(
                image = type.image,
                name = type.name,
                global = globalMapper.mapFromEntity(type.global),
                type = type.type,
                sea = seaMapper.mapFromEntity(type.sea),
                globalSeaDiff = type.globalSeaDiff
        )
    }

    override fun mapToEntity(type: Item): ItemEntity {
        return ItemEntity(
                image = type.image,
                name = type.name,
                global = globalMapper.mapToEntity(type.global),
                type = type.type,
                sea = seaMapper.mapToEntity(type.sea),
                globalSeaDiff = type.globalSeaDiff
        )
    }
}