package org.rom.exchange.data.mapper.rom

import org.rom.exchange.data.mapper.Mapper
import org.rom.exchange.data.model.rom.DataItemEntity
import org.rom.exchange.domain.model.rom.DataItem
import javax.inject.Inject

class DataItemMapper @Inject constructor() : Mapper<DataItemEntity, DataItem> {
    override fun mapFromEntity(type: DataItemEntity): DataItem {
        return DataItem(price = type.price, time = type.time, snap = type.snap)
    }

    override fun mapToEntity(type: DataItem): DataItemEntity {
        return DataItemEntity(price = type.price, time = type.time, snap = type.snap)
    }
}