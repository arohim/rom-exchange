package kim.rom.exchange.data

import io.reactivex.Single
import kim.rom.exchange.data.mapper.rom.ItemMapper
import kim.rom.exchange.data.source.ROMExchangeDataStoreFactory
import kim.rom.exchange.domain.model.rom.Item
import kim.rom.exchange.domain.repository.BufferooRepository
import kim.rom.exchange.domain.repository.ROMExchangeRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [BufferooRepository] interface for communicating to and from
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