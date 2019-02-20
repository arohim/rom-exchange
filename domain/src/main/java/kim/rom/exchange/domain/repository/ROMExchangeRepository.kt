package kim.rom.exchange.domain.repository

import io.reactivex.Single
import kim.rom.exchange.domain.model.Bufferoo

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface ROMExchangeRepository {

    fun getItems(): Single<List<Bufferoo>>

}