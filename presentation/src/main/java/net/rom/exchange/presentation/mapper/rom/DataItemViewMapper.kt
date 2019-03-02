package net.rom.exchange.presentation.mapper.rom

import net.rom.exchange.domain.model.rom.DataItem
import net.rom.exchange.presentation.mapper.Mapper
import net.rom.exchange.presentation.model.rom.DataItemView
import javax.inject.Inject

class DataItemViewMapper @Inject constructor() : Mapper<DataItemView, DataItem> {
    override fun mapToView(type: DataItem): DataItemView {
        return DataItemView(price = type.price, time = type.time, snap = type.snap)
    }
}