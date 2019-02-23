package org.rom.exchange.remote.mapper.rom

import org.rom.exchange.data.model.rom.DataItemEntity
import org.rom.exchange.remote.mapper.EntityMapper
import org.rom.exchange.remote.model.rom.DataItemModel
import javax.inject.Inject

class DataItemEntityMapper @Inject constructor() : EntityMapper<DataItemModel, DataItemEntity> {
    override fun mapFromRemote(type: DataItemModel): DataItemEntity {
        return DataItemEntity(price = type.price ?: 0, time = type.time ?: "", snap = type.snap?: false)
    }
}