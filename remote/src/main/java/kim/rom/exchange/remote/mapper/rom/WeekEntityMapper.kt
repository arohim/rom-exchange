package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.Week
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.WeekModel
import javax.inject.Inject

class WeekEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<WeekModel, Week> {
    override fun mapFromRemote(type: WeekModel): Week {
        return Week(
                data = type.data?.map { it.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } }
                        ?: listOf(),
                change = type.change ?: 0
        )
    }
}