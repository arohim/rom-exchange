package net.rom.exchange.remote

import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemExchangeEntity
import net.rom.exchange.data.repository.ItemExchangeRemote
import net.rom.exchange.remote.mapper.rom.ItemEntityMapper
import javax.inject.Inject

class ItemExchangeRemoteImpl @Inject constructor(private val romExchangeService: ItemExchangeService,
                                                 private val entityMapper: ItemEntityMapper) : ItemExchangeRemote {
    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemExchangeEntity>> {
        return romExchangeService.getItems(
                kw = kw,
                exact = exact,
                type = type,
                sort = sort,
                sortDir = sortDir,
                sortRange = sortRange,
                page = page
        ).map {
            it.map { listItem ->
                entityMapper.mapFromRemote(listItem)
            }
        }
    }
}