package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.Month
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.MonthModel
import javax.inject.Inject

class MonthEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<MonthModel, Month> {
    override fun mapFromRemote(type: MonthModel): Month {
        return Month(
                data = type.data?.map { it.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } }
                        ?: listOf(),
                change = type.change ?: 0
        )
    }
}