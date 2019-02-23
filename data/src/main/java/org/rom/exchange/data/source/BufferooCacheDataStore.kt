package org.rom.exchange.data.source

import io.reactivex.Completable
import io.reactivex.Single
import org.rom.exchange.data.model.BufferooEntity
import org.rom.exchange.data.repository.BufferooCache
import org.rom.exchange.data.repository.BufferooDataStore
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the local data source
 */
open class BufferooCacheDataStore @Inject constructor(private val bufferooCache: BufferooCache) :
        BufferooDataStore {

    /**
     * Clear all Bufferoos from the cache
     */
    override fun clearBufferoos(): Completable {
        return bufferooCache.clearBufferoos()
    }

    /**
     * Save a given [List] of [BufferooEntity] instances to the cache
     */
    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        return bufferooCache.saveBufferoos(bufferoos)
                .doOnComplete {
                    bufferooCache.setLastCacheTime(System.currentTimeMillis())
                }
    }

    /**
     * Retrieve a list of [BufferooEntity] instance from the cache
     */
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooCache.getBufferoos()
    }

}