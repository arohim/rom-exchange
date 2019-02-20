package kim.rom.exchange.remote

import io.reactivex.Single
import kim.rom.exchange.data.model.BufferooEntity
import kim.rom.exchange.data.repository.BufferooRemote
import kim.rom.exchange.remote.mapper.BufferooEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class BufferooRemoteImpl @Inject constructor(private val bufferooService: BufferooService,
                                             private val entityMapper: BufferooEntityMapper) :
        BufferooRemote {

    /**
     * Retrieve a list of [BufferooEntity] instances from the [BufferooService].
     */
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooService.getBufferoos()
                .map {
                    it.team.map { listItem ->
                        entityMapper.mapFromRemote(listItem)
                    }
                }
    }

}