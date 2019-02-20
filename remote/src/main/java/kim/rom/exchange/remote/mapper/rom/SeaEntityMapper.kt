package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.data.model.rom.SeaEntity
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.SeaModel
import javax.inject.Inject

class SeaEntityMapper @Inject constructor(
        private val allEntityMapper: AllEntityMapper,
        private val weekEntityMapper: WeekEntityMapper,
        private val monthEntityMapper: MonthEntityMapper
) : EntityMapper<SeaModel, SeaEntity> {
    override fun mapFromRemote(type: SeaModel): SeaEntity {
        return SeaEntity(
                all = type.all?.let { allEntityMapper.mapFromRemote(it) },
                week = type.week?.let { weekEntityMapper.mapFromRemote(it) },
                month = type.month?.let { monthEntityMapper.mapFromRemote(it) },
                latest = type.latest
        )
    }
}