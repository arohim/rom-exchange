package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.data.model.rom.AllEntity
import kim.rom.exchange.data.model.rom.DataItemEntity
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.AllModel
import kim.rom.exchange.remote.model.rom.DataItemModel
import javax.inject.Inject

class AllEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<AllModel, AllEntity> {
    override fun mapFromRemote(type: AllModel): AllEntity {
        return AllEntity(
                data = type.data?.map { it?.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } },
                change = type.change
        )
    }
}