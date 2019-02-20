package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.DataItem
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.DataItemModel
import javax.inject.Inject

class DataItemEntityMapper @Inject constructor() : EntityMapper<DataItemModel, DataItem> {
    override fun mapFromRemote(type: DataItemModel): DataItem {
        return DataItem(price = type.price ?: 0, time = type.time ?: "", snap = type.snap
                ?: false)
    }
}