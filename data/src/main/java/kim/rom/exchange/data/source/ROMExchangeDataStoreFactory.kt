package kim.rom.exchange.data.source

import kim.rom.exchange.data.repository.ROMExchangeDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
open class ROMExchangeDataStoreFactory @Inject constructor(private val romExchangeRemoteDataStore: ROMExchangeRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): ROMExchangeDataStore {
        return romExchangeRemoteDataStore
    }

}