package net.rom.exchange.remote.mapper.rom

import net.rom.exchange.data.model.rom.AllEntity
import net.rom.exchange.remote.mapper.EntityMapper
import net.rom.exchange.remote.model.rom.AllModel
import javax.inject.Inject

class AllEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<AllModel, AllEntity> {
    override fun mapFromRemote(type: AllModel): AllEntity {
        return AllEntity(
                data = type.data?.map { it.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } }
                        ?: listOf(),
                change = type.change ?: 0.0
        )
    }
}