package net.rom.exchange.data

import io.reactivex.Single
import net.rom.exchange.data.mapper.rom.ItemMapper
import net.rom.exchange.data.source.ROMExchangeDataStoreFactory
import net.rom.exchange.domain.model.rom.Item
import net.rom.exchange.domain.repository.ROMExchangeRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [ROMExchangeRepository] interface for communicating to and from
 * data sources
 */
class ROMExchangeDataRepository @Inject constructor(private val factory: ROMExchangeDataStoreFactory,
                                                    private val itemMapper: ItemMapper) :
        ROMExchangeRepository {

    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<Item>> {
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