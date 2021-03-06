package net.rom.exchange.remote.mapper.rom

import net.rom.exchange.data.model.rom.*
import net.rom.exchange.remote.mapper.EntityMapper
import net.rom.exchange.remote.model.rom.ItemExchangeModel
import javax.inject.Inject

open class ItemEntityMapper @Inject constructor(private val globalEntityMapper: GlobalEntityMapper, private val seaEntityMapper: SeaEntityMapper) : EntityMapper<ItemExchangeModel, ItemExchangeEntity> {
    override fun mapFromRemote(type: ItemExchangeModel): ItemExchangeEntity {
        return ItemExchangeEntity(
                image = type.image ?: Any(),
                name = type.name ?: "",
                global = type.global?.let { globalEntityMapper.mapFromRemote(it) }
                        ?: GlobalEntity(AllEntity(listOf(), 0.0), WeekEntity(listOf(), 0.0), MonthEntity(listOf(), 0.0), 0),
                type = type.type ?: 0,
                sea = type.sea?.let { seaEntityMapper.mapFromRemote(it) }
                        ?: SeaEntity(AllEntity(listOf(), 0.0), WeekEntity(listOf(), 0.0), MonthEntity(listOf(), 0.0), 0),
                globalSeaDiff = type.globalSeaDiff ?: 0.0
        )
    }
}