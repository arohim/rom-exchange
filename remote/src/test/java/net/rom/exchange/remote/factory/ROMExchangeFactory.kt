package net.rom.exchange.remote.factory

import net.rom.exchange.remote.factory.DataFactory.Factory.randomUuid
import net.rom.exchange.remote.BufferooService
import net.rom.exchange.remote.ROMExchangeService
import net.rom.exchange.remote.factory.DataFactory.Factory.randomBoolean
import net.rom.exchange.remote.factory.DataFactory.Factory.randomDouble
import net.rom.exchange.remote.factory.DataFactory.Factory.randomInt
import net.rom.exchange.remote.model.BufferooModel
import net.rom.exchange.remote.model.rom.*

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

        fun makeROMExchangeResponse(): ROMExchangeService.ROMExchangeResponse {
            val response = ROMExchangeService.ROMExchangeResponse()
            response.team = makeROMExchangeModelList(5)
            return response
        }

        private fun makeROMExchangeModelList(count: Int): List<ItemModel> {
            val entities = mutableListOf<ItemModel>()
            repeat(count) {
                entities.add(makeItemModel())
            }
            return entities
        }

        fun makeDataItemModel(): DataItemModel {
            return DataItemModel(
                    price = randomInt(),
                    time = randomUuid(),
                    snap = randomBoolean()
            )
        }

        fun makeDataItemModelList(count: Int): List<DataItemModel> {
            val dataItemEntities = mutableListOf<DataItemModel>()
            repeat(count) {
                dataItemEntities.add(makeDataItemModel())
            }
            return dataItemEntities
        }

        fun makeWeekModel(): WeekModel {
            return WeekModel(
                    data = makeDataItemModelList(2),
                    change = randomDouble()
            )
        }

        fun makeMonthModel(): MonthModel {
            return MonthModel(
                    data = makeDataItemModelList(2),
                    change = randomDouble()
            )
        }

        fun makeAllModel(): AllModel {
            return AllModel(
                    data = makeDataItemModelList(2),
                    change = randomDouble()
            )
        }

        fun makeSeaModel(): SeaModel {
            return SeaModel(
                    makeAllModel(),
                    makeWeekModel(),
                    makeMonthModel(),
                    randomInt()
            )
        }

        fun makeGlobalModel(): GlobalModel {
            return GlobalModel(
                    makeAllModel(),
                    makeWeekModel(),
                    makeMonthModel(),
                    randomInt()
            )
        }

        fun makeItemModel(): ItemModel {
            return ItemModel(
                    image = randomUuid(),
                    name = randomUuid(),
                    global = makeGlobalModel(),
                    sea = makeSeaModel(),
                    type = randomInt(),
                    globalSeaDiff = randomDouble()
            )
        }


    }

}