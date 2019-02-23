package org.rom.exchange.data

import io.reactivex.Completable
import io.reactivex.Single
import org.rom.exchange.data.mapper.BufferooMapper
import org.rom.exchange.data.model.BufferooEntity
import org.rom.exchange.data.source.BufferooDataStoreFactory
import org.rom.exchange.data.source.BufferooRemoteDataStore
import org.rom.exchange.domain.model.Bufferoo
import org.rom.exchange.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [BufferooRepository] interface for communicating to and from
 * data sources
 */
class BufferooDataRepository @Inject constructor(private val factory: BufferooDataStoreFactory,
                                                 private val bufferooMapper: BufferooMapper) :
        BufferooRepository {

    override fun clearBufferoos(): Completable {
        return factory.retrieveCacheDataStore().clearBufferoos()
    }

    override fun saveBufferoos(bufferoos: List<Bufferoo>): Completable {
        val bufferooEntities = bufferoos.map { bufferooMapper.mapToEntity(it) }
        return saveBufferooEntities(bufferooEntities)
    }

    private fun saveBufferooEntities(bufferoos: List<BufferooEntity>): Completable {
        return factory.retrieveCacheDataStore().saveBufferoos(bufferoos)
    }

    override fun getBufferoos(): Single<List<Bufferoo>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getBufferoos()
                .flatMap {
                    if (dataStore is BufferooRemoteDataStore) {
                        saveBufferooEntities(it).toSingle { it }
                    } else {
                        Single.just(it)
                    }
                }
                .map { list ->
                    list.map { listItem ->
                        bufferooMapper.mapFromEntity(listItem)
                    }
                }
    }

}