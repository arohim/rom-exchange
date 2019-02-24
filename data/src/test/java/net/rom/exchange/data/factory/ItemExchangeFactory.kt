package net.rom.exchange.data.factory

import net.rom.exchange.data.factory.DataFactory.Factory.randomBoolean
import net.rom.exchange.data.factory.DataFactory.Factory.randomDouble
import net.rom.exchange.data.factory.DataFactory.Factory.randomInt
import net.rom.exchange.data.factory.DataFactory.Factory.randomUuid
import net.rom.exchange.data.model.rom.*
import net.rom.exchange.domain.model.rom.*

/**
 * Factory class for Bufferoo related instances
 */
class ItemExchangeFactory {

    companion object Factory {

        fun makeDataItemEntity(): DataItemEntity {
            return DataItemEntity(
                    price = randomInt(),
                    time = randomUuid(),
                    snap = randomBoolean()
            )
        }

        fun makeDataItem(): DataItem {
            return DataItem(
                    price = randomInt(),
                    time = randomUuid(),
                    snap = randomBoolean()
            )
        }

        fun makeDataItemEntityList(count: Int): List<DataItemEntity> {
            val dataItemEntities = mutableListOf<DataItemEntity>()
            repeat(count) {
                dataItemEntities.add(makeDataItemEntity())
            }
            return dataItemEntities
        }

        fun makeDataItemList(count: Int): List<DataItem> {
            val dataItems = mutableListOf<DataItem>()
            repeat(count) {
                dataItems.add(makeDataItem())
            }
            return dataItems
        }

        fun makeWeekEntity(): WeekEntity {
            return WeekEntity(
                    data = makeDataItemEntityList(2),
                    change = randomDouble()
            )
        }

        fun makeWeek(): Week {
            return Week(
                    data = makeDataItemList(2),
                    change = randomDouble()
            )
        }

        fun makeMonthEntity(): MonthEntity {
            return MonthEntity(
                    data = makeDataItemEntityList(2),
                    change = randomDouble()
            )
        }

        fun makeMonth(): Month {
            return Month(
                    data = makeDataItemList(2),
                    change = randomDouble()
            )
        }

        fun makeAllEntity(): AllEntity {
            return AllEntity(
                    data = makeDataItemEntityList(2),
                    change = randomDouble()
            )
        }

        fun makeAll(): All {
            return All(
                    data = makeDataItemList(2),
                    change = randomDouble()
            )
        }

        fun makeSeaEntity(): SeaEntity {
            return SeaEntity(
                    makeAllEntity(),
                    makeWeekEntity(),
                    makeMonthEntity(),
                    randomInt()
            )
        }

        fun makeSea(): Sea {
            return Sea(
                    makeAll(),
                    makeWeek(),
                    makeMonth(),
                    randomInt()
            )
        }

        fun makeGlobalEntity(): GlobalEntity {
            return GlobalEntity(
                    makeAllEntity(),
                    makeWeekEntity(),
                    makeMonthEntity(),
                    randomInt()
            )
        }

        fun makeGlobal(): Global {
            return Global(
                    makeAll(),
                    makeWeek(),
                    makeMonth(),
                    randomInt()
            )
        }


        fun makeItemEntity(): ItemEntity {
            return ItemEntity(
                    image = randomUuid(),
                    name = randomUuid(),
                    global = makeGlobalEntity(),
                    sea = makeSeaEntity(),
                    type = randomInt(),
                    globalSeaDiff = randomDouble()
            )
        }

        fun makeItem(): Item {
            return Item(
                    image = randomUuid(),
                    name = randomUuid(),
                    global = makeGlobal(),
                    sea = makeSea(),
                    type = randomInt(),
                    globalSeaDiff = randomDouble()
            )
        }

    }

}