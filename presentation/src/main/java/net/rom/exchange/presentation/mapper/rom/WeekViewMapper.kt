package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.presentation.model.rom.WeekView
import net.rom.exchange.domain.model.rom.Week
import net.rom.exchange.presentation.mapper.Mapper
import javax.inject.Inject

class WeekViewMapper @Inject constructor(private val dataItemMapper: DataItemViewMapper) : Mapper<WeekView, Week> {
    override fun mapToView(type: Week): WeekView {
        return WeekView(
                data = type.data.map { dataItemMapper.mapToView(it) },
                change = type.change
        )
    }
}