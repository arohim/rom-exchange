package kim.rom.exchange.data.mapper.rom

import kim.rom.exchange.data.mapper.Mapper
import kim.rom.exchange.data.model.rom.AllEntity
import kim.rom.exchange.domain.model.rom.All
import javax.inject.Inject

class AllMapper @Inject constructor(private val dataItemMapper: DataItemMapper) : Mapper<AllEntity, All> {
    override fun mapFromEntity(type: AllEntity): All {
        return All(
                data = type.data.map { dataItemMapper.mapFromEntity(it) },
                change = type.change
        )
    }

    override fun mapToEntity(type: All): AllEntity {
        return AllEntity(
                data = type.data.map { dataItemMapper.mapToEntity(it) },
                change = type.change
        )
    }
}