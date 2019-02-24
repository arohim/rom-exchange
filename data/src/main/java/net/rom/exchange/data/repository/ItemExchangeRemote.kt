package net.rom.exchange.data.repository

import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemEntity

interface ItemExchangeRemote {

    fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, sortServer: String, sortRange: String, page: Int): Single<List<ItemEntity>>
}