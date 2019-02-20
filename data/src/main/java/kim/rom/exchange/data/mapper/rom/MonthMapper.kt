package kim.rom.exchange.data.mapper.rom

import kim.rom.exchange.data.mapper.Mapper
import kim.rom.exchange.data.model.rom.MonthEntity
import kim.rom.exchange.domain.model.rom.Month
import javax.inject.Inject

class MonthMapper @Inject constructor(private val dataItemMapper: DataItemMapper) : Mapper<MonthEntity, Month> {
    override fun mapFromEntity(type: MonthEntity): Month {
        return Month(
                data = type.data.map { dataItemMapper.mapFromEntity(it) },
                change = type.change
        )
    }

    override fun mapToEntity(type: Month): MonthEntity {
        return MonthEntity(
                data = type.data.map { dataItemMapper.mapToEntity(it) },
                change = type.change
        )
    }
}