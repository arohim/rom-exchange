package net.rom.exchange.remote.mapper.rom

import net.rom.exchange.data.model.rom.AllEntity
import net.rom.exchange.data.model.rom.MonthEntity
import net.rom.exchange.data.model.rom.SeaEntity
import net.rom.exchange.data.model.rom.WeekEntity
import net.rom.exchange.remote.mapper.EntityMapper
import net.rom.exchange.remote.model.rom.SeaModel
import javax.inject.Inject

class SeaEntityMapper @Inject constructor(
        private val allEntityMapper: AllEntityMapper,
        private val weekEntityMapper: WeekEntityMapper,
        private val monthEntityMapper: MonthEntityMapper
) : EntityMapper<SeaModel, SeaEntity> {
    override fun mapFromRemote(type: SeaModel): SeaEntity {
        return SeaEntity(
                all = type.all?.let { allEntityMapper.mapFromRemote(it) }
                        ?: AllEntity(listOf(), 0.0),
                week = type.week?.let { weekEntityMapper.mapFromRemote(it) }
                        ?: WeekEntity(listOf(), 0.0),
                month = type.month?.let { monthEntityMapper.mapFromRemote(it) }
                        ?: MonthEntity(listOf(), 0.0),
                latest = type.latest ?: 0
        )
    }
}