package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.domain.model.rom.Global
import net.rom.exchange.presentation.mapper.Mapper
import net.rom.exchange.presentation.model.rom.GlobalView
import javax.inject.Inject

class GlobalViewMapper @Inject constructor(
        private val allMapper: AllMapper,
        private val weekMapper: WeekMapper,
        private val monthMapper: MonthMapper
) : Mapper<GlobalView, Global> {
    override fun mapToView(type: Global): GlobalView {
        return GlobalView(
                all = allMapper.mapToView(type.all),
                week = weekMapper.mapToView(type.week),
                month = monthMapper.mapToView(type.month),
                latest = type.latest
        )
    }
}