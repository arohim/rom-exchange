package net.rom.exchange.data

import io.reactivex.Single
import net.rom.exchange.data.mapper.rom.ItemExchangeMapper
import net.rom.exchange.data.source.ItemExchangeDataStoreFactory
import net.rom.exchange.domain.model.rom.ItemExchange
import net.rom.exchange.domain.repository.ItemExchangeRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [ItemExchangeRepository] interface for communicating to and from
 * data sources
 */
class ItemExchangeDataRepository @Inject constructor(private val factory: ItemExchangeDataStoreFactory,
                                                     private val itemMapper: ItemExchangeMapper) :
        ItemExchangeRepository {

    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemExchange>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getItems(
                kw = kw,
                exact = exact,
                type = type,
                sort = sort,
                sortDir = sortDir,
                sortServer = sortServer,
                sortRange = sortRange,
                page = page
        ).map {
            it.map { itemEntity ->
                itemMapper.mapFromEntity(itemEntity)
            }
        }
    }

}