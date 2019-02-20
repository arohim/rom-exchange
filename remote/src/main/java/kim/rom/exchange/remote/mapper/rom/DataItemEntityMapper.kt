package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.data.model.rom.DataItemEntity
import kim.rom.exchange.domain.model.rom.DataItem
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.DataItemModel
import javax.inject.Inject

class DataItemEntityMapper @Inject constructor() : EntityMapper<DataItemModel, DataItemEntity> {
    override fun mapFromRemote(type: DataItemModel): DataItemEntity {
        return DataItemEntity(price = type.price ?: 0, time = type.time ?: "", snap = type.snap
                ?: false)
    }
}