package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.domain.model.rom.Sea
import net.rom.exchange.presentation.mapper.Mapper
import net.rom.exchange.presentation.model.rom.SeaView
import javax.inject.Inject

class SeaViewMapper @Inject constructor(
        private val allMapper: AllMapper,
        private val weekMapper: WeekMapper,
        private val monthMapper: MonthMapper
) : Mapper<SeaView, Sea> {
    override fun mapToView(type: Sea): SeaView {
        return SeaView(
                all = allMapper.mapToView(type.all),
                week = weekMapper.mapToView(type.week),
                month = monthMapper.mapToView(type.month),
                latest = type.latest
        )
    }
}