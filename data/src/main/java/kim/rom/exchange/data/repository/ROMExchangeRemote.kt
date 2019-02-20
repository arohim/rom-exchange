package kim.rom.exchange.data.repository

import io.reactivex.Single
import kim.rom.exchange.data.model.rom.ItemEntity
import kim.rom.exchange.domain.model.rom.Item

interface ROMExchangeRemote {

    fun getItems(kw: String, exact: Boolean, type: Int, sort: String, sortDir: String, page: Int): Single<List<ItemEntity>>
}