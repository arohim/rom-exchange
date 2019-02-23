package org.rom.exchange.data.source

import io.reactivex.Completable
import io.reactivex.Single
import org.rom.exchange.data.model.BufferooEntity
import org.rom.exchange.data.repository.BufferooDataStore
import org.rom.exchange.data.repository.BufferooRemote
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class BufferooRemoteDataStore @Inject constructor(private val bufferooRemote: BufferooRemote) :
        BufferooDataStore {

    override fun clearBufferoos(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooRemote.getBufferoos()
    }

}