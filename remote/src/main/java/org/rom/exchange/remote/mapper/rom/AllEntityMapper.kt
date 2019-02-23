package org.rom.exchange.remote.mapper.rom

import org.rom.exchange.data.model.rom.AllEntity
import org.rom.exchange.remote.mapper.EntityMapper
import org.rom.exchange.remote.model.rom.AllModel
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