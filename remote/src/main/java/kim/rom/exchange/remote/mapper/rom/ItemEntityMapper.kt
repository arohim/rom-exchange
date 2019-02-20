package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.*
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.ItemModel
import javax.inject.Inject

class ItemEntityMapper @Inject constructor(private val globalEntityMapper: GlobalEntityMapper, private val seaEntityMapper: SeaEntityMapper) : EntityMapper<ItemModel, Item> {
    override fun mapFromRemote(type: ItemModel): Item {
        return Item(
                image = type.image ?: Any(),
                name = type.name ?: "",
                global = type.global?.let { globalEntityMapper.mapFromRemote(it) }
                        ?: Global(All(listOf(), 0), Week(listOf(), 0), Month(listOf(), 0), 0),
                type = type.type ?: 0,
                sea = type.sea?.let { seaEntityMapper.mapFromRemote(it) }
                        ?: Sea(All(listOf(), 0), Week(listOf(), 0), Month(listOf(), 0), 0),
                globalSeaDiff = type.globalSeaDiff ?: 0
        )
    }
}