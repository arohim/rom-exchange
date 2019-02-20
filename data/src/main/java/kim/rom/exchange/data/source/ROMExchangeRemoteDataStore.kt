package kim.rom.exchange.data.source

import io.reactivex.Single
import kim.rom.exchange.data.model.rom.ItemEntity
import kim.rom.exchange.data.repository.BufferooDataStore
import kim.rom.exchange.data.repository.ROMExchangeDataStore
import kim.rom.exchange.data.repository.ROMExchangeRemote
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class ROMExchangeRemoteDataStore @Inject constructor(private val romExchageRemote: ROMExchangeRemote) : ROMExchangeDataStore {
    override fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>> {
        return romExchageRemote.getItems(kw, exact, type, sort, sortDir, sortServer, sortRange, page)
    }
}