package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.All
import kim.rom.exchange.domain.model.rom.Global
import kim.rom.exchange.domain.model.rom.Month
import kim.rom.exchange.domain.model.rom.Week
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.GlobalModel
import javax.inject.Inject

class GlobalEntityMapper @Inject constructor(
        private val allEntityMapper: AllEntityMapper,
        private val weekEntityMapper: WeekEntityMapper,
        private val monthEntityMapper: MonthEntityMapper
) : EntityMapper<GlobalModel, Global> {
    override fun mapFromRemote(type: GlobalModel): Global {
        return Global(
                all = type.all?.let { allEntityMapper.mapFromRemote(it) }
                        ?: All(listOf(), 0),
                week = type.week?.let { weekEntityMapper.mapFromRemote(it) }
                        ?: Week(listOf(), 0),
                month = type.month?.let { monthEntityMapper.mapFromRemote(it) }
                        ?: Month(listOf(), 0),
                latest = type.latest ?: 0
        )
    }
}