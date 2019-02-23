package net.rom.exchange.remote.mapper.rom

import net.rom.exchange.data.model.rom.MonthEntity
import net.rom.exchange.remote.mapper.EntityMapper
import net.rom.exchange.remote.model.rom.MonthModel
import javax.inject.Inject

class MonthEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<MonthModel, MonthEntity> {
    override fun mapFromRemote(type: MonthModel): MonthEntity {
        return MonthEntity(
                data = type.data?.map { it.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } }
                        ?: listOf(),
                change = type.change ?: 0.0
        )
    }
}