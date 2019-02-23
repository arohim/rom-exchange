package net.rom.exchange.data.source

import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemEntity
import net.rom.exchange.data.repository.ROMExchangeDataStore
import net.rom.exchange.data.repository.ROMExchangeRemote
import javax.inject.Inject

/**
 * Implementation of the [ROMExchangeDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class ROMExchangeRemoteDataStore @Inject constructor(private val romExchangeRemote: ROMExchangeRemote) : ROMExchangeDataStore {
    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>> {
        return romExchangeRemote.getItems(kw, exact, type, sort, sortDir, sortServer, sortRange, page)
    }
}