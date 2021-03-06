package net.rom.exchange.remote.mapper.rom

import net.rom.exchange.data.model.rom.AllEntity
import net.rom.exchange.data.model.rom.GlobalEntity
import net.rom.exchange.data.model.rom.MonthEntity
import net.rom.exchange.data.model.rom.WeekEntity
import net.rom.exchange.remote.mapper.EntityMapper
import net.rom.exchange.remote.model.rom.GlobalModel
import javax.inject.Inject

class GlobalEntityMapper @Inject constructor(
        private val allEntityMapper: AllEntityMapper,
        private val weekEntityMapper: WeekEntityMapper,
        private val monthEntityMapper: MonthEntityMapper
) : EntityMapper<GlobalModel, GlobalEntity> {
    override fun mapFromRemote(type: GlobalModel): GlobalEntity {
        return GlobalEntity(
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