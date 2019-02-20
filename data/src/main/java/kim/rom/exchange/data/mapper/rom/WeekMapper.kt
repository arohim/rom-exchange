package kim.rom.exchange.data.mapper.rom

import kim.rom.exchange.data.mapper.Mapper
import kim.rom.exchange.data.model.rom.WeekEntity
import kim.rom.exchange.domain.model.rom.Week
import javax.inject.Inject

class WeekMapper @Inject constructor(private val dataItemMapper: DataItemMapper) : Mapper<WeekEntity, Week> {
    override fun mapFromEntity(type: WeekEntity): Week {
        return Week(
                data = type.data.map { dataItemMapper.mapFromEntity(it) },
                change = type.change
        )
    }

    override fun mapToEntity(type: Week): WeekEntity {
        return WeekEntity(
                data = type.data.map { dataItemMapper.mapToEntity(it) },
                change = type.change
        )
    }
}