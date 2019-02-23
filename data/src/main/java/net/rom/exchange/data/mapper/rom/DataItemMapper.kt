package net.rom.exchange.data.mapper.rom

import net.rom.exchange.data.mapper.Mapper
import net.rom.exchange.data.model.rom.DataItemEntity
import net.rom.exchange.domain.model.rom.DataItem
import javax.inject.Inject

class DataItemMapper @Inject constructor() : Mapper<DataItemEntity, DataItem> {
    override fun mapFromEntity(type: DataItemEntity): DataItem {
        return DataItem(price = type.price, time = type.time, snap = type.snap)
    }

    override fun mapToEntity(type: DataItem): DataItemEntity {
        return DataItemEntity(price = type.price, time = type.time, snap = type.snap)
    }
}