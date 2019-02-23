package org.rom.exchange.data.mapper.rom

import org.rom.exchange.data.mapper.Mapper
import org.rom.exchange.data.model.rom.SeaEntity
import org.rom.exchange.domain.model.rom.Sea
import javax.inject.Inject

class SeaMapper @Inject constructor(
        private val allMapper: AllMapper,
        private val weekMapper: WeekMapper,
        private val monthMapper: MonthMapper
) : Mapper<SeaEntity, Sea> {
    override fun mapFromEntity(type: SeaEntity): Sea {
        return Sea(
                all = allMapper.mapFromEntity(type.all),
                week = weekMapper.mapFromEntity(type.week),
                month = monthMapper.mapFromEntity(type.month),
                latest = type.latest
        )
    }

    override fun mapToEntity(type: Sea): SeaEntity {
        return SeaEntity(
                all = allMapper.mapToEntity(type.all),
                week = weekMapper.mapToEntity(type.week),
                month = monthMapper.mapToEntity(type.month),
                latest = type.latest
        )
    }
}