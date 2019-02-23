package net.rom.exchange.remote.factory

import net.rom.exchange.remote.factory.DataFactory.Factory.randomUuid
import net.rom.exchange.remote.BufferooService
import net.rom.exchange.remote.factory.DataFactory.Factory.randomBoolean
import net.rom.exchange.remote.factory.DataFactory.Factory.randomInt
import net.rom.exchange.remote.model.BufferooModel
import net.rom.exchange.remote.model.rom.DataItemModel

/**
 * Factory class for Bufferoo related instances
 */
class ROMExchangeFactory {

    companion object Factory {

        fun makeBufferooResponse(): BufferooService.BufferooResponse {
            val bufferooResponse = BufferooService.BufferooResponse()
            bufferooResponse.team = makeBufferooModelList(5)
            return bufferooResponse
        }

        fun makeBufferooModelList(count: Int): List<BufferooModel> {
            val bufferooEntities = mutableListOf<BufferooModel>()
            repeat(count) {
                bufferooEntities.add(makeBufferooModel())
            }
            return bufferooEntities
        }

        fun makeBufferooModel(): BufferooModel {
            return BufferooModel(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeDataItemModel(): DataItemModel {
            return DataItemModel(
                    price = randomInt(),
                    time = randomUuid(),
                    snap = randomBoolean()
            )
        }

    }

}