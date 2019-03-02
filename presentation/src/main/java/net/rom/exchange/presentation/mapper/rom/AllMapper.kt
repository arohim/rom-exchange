package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.presentation.model.rom.AllView
import net.rom.exchange.domain.model.rom.All
import net.rom.exchange.presentation.mapper.Mapper
import javax.inject.Inject

class AllMapper @Inject constructor(private val dataItemMapper: DataItemMapper) : Mapper<AllView, All> {
    override fun mapToView(type: All): AllView {
        return AllView(
                data = type.data.map { dataItemMapper.mapToView(it) },
                change = type.change
        )
    }
}