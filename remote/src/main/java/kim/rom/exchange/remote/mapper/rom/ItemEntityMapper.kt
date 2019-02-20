package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.data.model.rom.ItemEntity
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.ItemModel
import javax.inject.Inject

class ItemEntityMapper @Inject constructor(private val globalEntityMapper: GlobalEntityMapper, private val seaEntityMapper: SeaEntityMapper) : EntityMapper<ItemModel, ItemEntity> {
    override fun mapFromRemote(type: ItemModel): ItemEntity {
        return ItemEntity(
                image = type.image,
                name = type.name,
                global = type.global?.let { globalEntityMapper.mapFromRemote(it) },
                type = type.type,
                sea = type.sea?.let { seaEntityMapper.mapFromRemote(it) },
                globalSeaDiff = type.globalSeaDiff
        )
    }
}