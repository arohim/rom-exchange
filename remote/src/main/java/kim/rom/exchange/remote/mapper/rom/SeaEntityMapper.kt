package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.All
import kim.rom.exchange.domain.model.rom.Month
import kim.rom.exchange.domain.model.rom.Sea
import kim.rom.exchange.domain.model.rom.Week
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.SeaModel
import javax.inject.Inject

class SeaEntityMapper @Inject constructor(
        private val allEntityMapper: AllEntityMapper,
        private val weekEntityMapper: WeekEntityMapper,
        private val monthEntityMapper: MonthEntityMapper
) : EntityMapper<SeaModel, Sea> {
    override fun mapFromRemote(type: SeaModel): Sea {
        return Sea(
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