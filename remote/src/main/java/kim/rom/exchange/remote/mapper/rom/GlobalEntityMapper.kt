package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.data.model.rom.GlobalEntity
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.GlobalModel
import javax.inject.Inject

class GlobalEntityMapper @Inject constructor(
        private val allEntityMapper: AllEntityMapper,
        private val weekEntityMapper: WeekEntityMapper,
        private val monthEntityMapper: MonthEntityMapper
) : EntityMapper<GlobalModel, GlobalEntity> {
    override fun mapFromRemote(type: GlobalModel): GlobalEntity {
        return GlobalEntity(
                all = type.all?.let { allEntityMapper.mapFromRemote(it) },
                week = type.week?.let { weekEntityMapper.mapFromRemote(it) },
                month = type.month?.let { monthEntityMapper.mapFromRemote(it) },
                latest = type.latest
        )
    }
}