package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.data.mapper.rom.GlobalMapper
import kim.rom.exchange.data.mapper.rom.SeaMapper
import kim.rom.exchange.data.model.rom.*
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.ItemModel
import javax.inject.Inject

class ItemEntityMapper @Inject constructor(private val globalEntityMapper: GlobalEntityMapper, private val seaEntityMapper: SeaEntityMapper) : EntityMapper<ItemModel, ItemEntity> {
    override fun mapFromRemote(type: ItemModel): ItemEntity {
        return ItemEntity(
                image = type.image ?: Any(),
                name = type.name ?: "",
                global = type.global?.let { globalEntityMapper.mapFromRemote(it) }
                        ?: GlobalEntity(AllEntity(listOf(), 0), WeekEntity(listOf(), 0), MonthEntity(listOf(), 0), 0),
                type = type.type ?: 0,
                sea = type.sea?.let { seaEntityMapper.mapFromRemote(it) }
                        ?: SeaEntity(AllEntity(listOf(), 0), WeekEntity(listOf(), 0), MonthEntity(listOf(), 0), 0),
                globalSeaDiff = type.globalSeaDiff ?: 0
        )
    }
}