package net.rom.exchange.presentation.factory

import net.rom.exchange.domain.factory.DataFactory
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.presentation.factory.DataFactory.Factory.randomDouble
import net.rom.exchange.presentation.factory.DataFactory.Factory.randomInt
import net.rom.exchange.presentation.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for ItemExchange related instances
 */
class ItemExchangeFactory {

    companion object Factory {

        fun makeItemExchangeList(count: Int): List<ItemExchange> {
            val itemExchanges = mutableListOf<ItemExchange>()
            repeat(count) {
                itemExchanges.add(makeItemExchange())
            }
            return itemExchanges
        }

        fun makeItemExchange(): ItemExchange {
            return ItemExchange(
                    image = randomUuid(),
                    name = randomUuid(),
                    globalSeaDiff = randomDouble(),
                    sea = makeSea(),
                    global = makeGlobal(),
                    type = randomInt()
            )
        }

        fun makeDataItem(): DataItem {
            return DataItem(
                    price = DataFactory.randomInt(),
                    time = DataFactory.randomUuid(),
                    snap = DataFactory.randomBoolean()
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
                    change = DataFactory.randomDouble()
            )
        }

        fun makeMonth(): Month {
            return Month(
                    data = makeDataItemList(2),
                    change = DataFactory.randomDouble()
            )
        }

        fun makeAll(): All {
            return All(
                    data = makeDataItemList(2),
                    change = DataFactory.randomDouble()
            )
        }

        fun makeSea(): Sea {
            return Sea(
                    makeAll(),
                    makeWeek(),
                    makeMonth(),
                    DataFactory.randomInt()
            )
        }

        fun makeGlobal(): Global {
            return Global(
                    makeAll(),
                    makeWeek(),
                    makeMonth(),
                    DataFactory.randomInt()
            )
        }

        fun makeItem(): ItemExchange {
            return ItemExchange(
                    image = DataFactory.randomUuid(),
                    name = DataFactory.randomUuid(),
                    global = makeGlobal(),
                    sea = makeSea(),
                    type = DataFactory.randomInt(),
                    globalSeaDiff = DataFactory.randomDouble()
            )
        }
    }
}