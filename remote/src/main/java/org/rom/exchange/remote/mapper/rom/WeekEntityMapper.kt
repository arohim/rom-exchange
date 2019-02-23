package org.rom.exchange.remote.mapper.rom

import org.rom.exchange.data.model.rom.WeekEntity
import org.rom.exchange.remote.mapper.EntityMapper
import org.rom.exchange.remote.model.rom.WeekModel
import javax.inject.Inject

class WeekEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<WeekModel, WeekEntity> {
    override fun mapFromRemote(type: WeekModel): WeekEntity {
        return WeekEntity(
                data = type.data?.map { it.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } }
                        ?: listOf(),
                change = type.change ?: 0.0
        )
    }
}