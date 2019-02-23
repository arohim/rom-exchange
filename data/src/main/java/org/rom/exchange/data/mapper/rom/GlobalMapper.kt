package org.rom.exchange.data.mapper.rom

import org.rom.exchange.data.mapper.Mapper
import org.rom.exchange.data.model.rom.GlobalEntity
import org.rom.exchange.domain.model.rom.Global
import javax.inject.Inject

class GlobalMapper @Inject constructor(
        private val allMapper: AllMapper,
        private val weekMapper: WeekMapper,
        private val monthMapper: MonthMapper
) : Mapper<GlobalEntity, Global> {
    override fun mapFromEntity(type: GlobalEntity): Global {
        return Global(
                all = allMapper.mapFromEntity(type.all),
                week = weekMapper.mapFromEntity(type.week),
                month = monthMapper.mapFromEntity(type.month),
                latest = type.latest
        )
    }

    override fun mapToEntity(type: Global): GlobalEntity {
        return GlobalEntity(
                all = allMapper.mapToEntity(type.all),
                week = weekMapper.mapToEntity(type.week),
                month = monthMapper.mapToEntity(type.month),
                latest = type.latest
        )
    }
}