package net.rom.exchange.data.source

import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemEntity
import net.rom.exchange.data.repository.ItemExchangeDataStore
import net.rom.exchange.data.repository.ItemExchangeRemote
import javax.inject.Inject

/**
 * Implementation of the [ItemExchangeDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class ItemExchangeRemoteDataStore @Inject constructor(private val itemExchangeRemote: ItemExchangeRemote) : ItemExchangeDataStore {
    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>> {
        return itemExchangeRemote.getItems(kw, exact, type, sort, sortDir, sortServer, sortRange, page)
    }
}