package net.rom.exchange.data.repository

import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemEntity

/**
 * Interface defining methods for the data operations related to Bufferroos.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface ROMExchangeDataStore {

    fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>>

}