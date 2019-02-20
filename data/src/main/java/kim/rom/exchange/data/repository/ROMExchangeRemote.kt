package kim.rom.exchange.data.repository

import io.reactivex.Single
import kim.rom.exchange.data.model.rom.ItemEntity

interface ROMExchangeRemote {

    fun getItems(exact: Boolean, type: Int, sort: String, sortDir: String, page: Int): Single<List<ItemEntity>>
}