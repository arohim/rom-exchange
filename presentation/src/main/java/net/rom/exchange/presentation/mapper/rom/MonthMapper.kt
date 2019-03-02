package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.presentation.model.rom.MonthView
import net.rom.exchange.domain.model.rom.Month
import net.rom.exchange.presentation.mapper.Mapper
import javax.inject.Inject

class MonthMapper @Inject constructor(private val dataItemMapper: DataItemMapper) : Mapper<MonthView, Month> {
    override fun mapToView(type: Month): MonthView {
        return MonthView(
                data = type.data.map { dataItemMapper.mapToView(it) },
                change = type.change
        )
    }
}