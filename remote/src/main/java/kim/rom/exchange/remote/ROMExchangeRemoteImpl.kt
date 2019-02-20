package kim.rom.exchange.remote

import io.reactivex.Single
import kim.rom.exchange.data.model.rom.ItemEntity
import kim.rom.exchange.data.repository.BufferooRemote
import kim.rom.exchange.data.repository.ROMExchangeRemote
import kim.rom.exchange.remote.mapper.rom.ItemEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class ROMExchangeRemoteImpl @Inject constructor(private val romExchangeService: ROMExchangeService,
                                                private val entityMapper: ItemEntityMapper) :
        ROMExchangeRemote {

    override fun getItems(exact: Boolean, type: Int, sort: String, sortDir: String, page: Int): Single<List<ItemEntity>> {
        return romExchangeService.getItems(
                exact = exact,
                type = type,
                sort = sort,
                sortDir = sortDir,
                page = page
        ).map {
            it.team.map { listItem ->
                entityMapper.mapFromRemote(listItem)
            }
        }
    }
}