package kim.rom.exchange.remote.mapper.rom

import kim.rom.exchange.domain.model.rom.All
import kim.rom.exchange.remote.mapper.EntityMapper
import kim.rom.exchange.remote.model.rom.AllModel
import javax.inject.Inject

class AllEntityMapper @Inject constructor(private val dataItemEntityMapper: DataItemEntityMapper) : EntityMapper<AllModel, All> {
    override fun mapFromRemote(type: AllModel): All {
        return All(
                data = type.data?.map { it.let { it1 -> dataItemEntityMapper.mapFromRemote(it1) } }
                        ?: listOf(),
                change = type.change ?: 0
        )
    }
}