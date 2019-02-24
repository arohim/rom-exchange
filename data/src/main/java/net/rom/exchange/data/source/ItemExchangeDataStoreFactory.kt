package net.rom.exchange.data.source

import net.rom.exchange.data.repository.ItemExchangeDataStore
import javax.inject.Inject

/**
 * Create an instance of a ItemExchangeRemoteDataStore
 */
open class ItemExchangeDataStoreFactory @Inject constructor(private val itemExchangeRemoteDataStore: ItemExchangeRemoteDataStore) {

    open fun retrieveDataStore(): ItemExchangeDataStore {
        return itemExchangeRemoteDataStore
    }

}