package net.rom.exchange.domain.factory

import net.rom.exchange.domain.factory.DataFactory.Factory.randomBoolean
import net.rom.exchange.domain.factory.DataFactory.Factory.randomDouble
import net.rom.exchange.domain.factory.DataFactory.Factory.randomInt
import net.rom.exchange.domain.factory.DataFactory.Factory.randomUuid
import net.rom.exchange.domain.model.rom.*

/**
 * Factory class for Bufferoo related instances
 */
class ItemExchangeFactory {

    companion object Factory {

        fun makeDataItem(): DataItem {
            return DataItem(
                    price = randomInt(),
                    time = randomUuid(),
                    snap = randomBoolean()
            )
        }

        fun makeDataItemList(count: Int): List<DataItem> {
            val dataItems = mutableListOf<DataItem>()
            repeat(count) {
                dataItems.add(makeDataItem())
            }
            return dataItems
        }

        fun makeWeek(): Week {
            return Week(
                    data = makeDataItemList(2),
                    change = randomDouble()
            )
        }

        fun makeMonth(): Month {
            return Month(
                    data = makeDataItemList(2),
                    change = randomDouble()
            )
        }

        fun makeAll(): All {
            return All(
                    data = makeDataItemList(2),
                    change = randomDouble()
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

        fun makeGlobal(): Global {
            return Global(
                    makeAll(),
                    makeWeek(),
                    makeMonth(),
                    randomInt()
            )
        }

        fun makeItem(): ItemExchange {
            return ItemExchange(
                    image = randomUuid(),
                    name = randomUuid(),
                    global = makeGlobal(),
                    sea = makeSea(),
                    type = randomInt(),
                    globalSeaDiff = randomDouble()
            )
        }

        fun makeItemList(count: Int): List<ItemExchange> {
            val data = mutableListOf<ItemExchange>()
            repeat(count) {
                data.add(makeItem())
            }
            return data
        }

    }

}