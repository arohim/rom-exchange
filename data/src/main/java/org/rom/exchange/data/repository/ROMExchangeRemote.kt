package org.rom.exchange.data.repository

import io.reactivex.Single
import org.rom.exchange.data.model.rom.ItemEntity

interface ROMExchangeRemote {

    fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>>
}