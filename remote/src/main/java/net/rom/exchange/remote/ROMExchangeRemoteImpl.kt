package net.rom.exchange.remote

import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemEntity
import net.rom.exchange.data.repository.ROMExchangeRemote
import net.rom.exchange.remote.mapper.rom.ItemEntityMapper
import javax.inject.Inject

class ROMExchangeRemoteImpl @Inject constructor(private val romExchangeService: ROMExchangeService,
                                                private val entityMapper: ItemEntityMapper) : ROMExchangeRemote {
    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>> {
        return romExchangeService.getItems(
                kw = kw,
                exact = exact,
                type = type,
                sort = sort,
                sortDir = sortDir,
                page = page
        ).map {
            it.map { listItem ->
                entityMapper.mapFromRemote(listItem)
            }
        }
    }
}