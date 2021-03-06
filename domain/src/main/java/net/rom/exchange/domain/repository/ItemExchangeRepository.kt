package net.rom.exchange.domain.repository

import io.reactivex.Single
import net.rom.exchange.domain.model.rom.ItemExchange

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface ItemExchangeRepository {

    fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemExchange>>

}