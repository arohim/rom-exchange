package net.rom.exchange.test.test.factory

import net.rom.exchange.presentation.model.rom.*
import net.rom.exchange.test.test.factory.DataFactory.Factory.randomDouble
import net.rom.exchange.test.test.factory.DataFactory.Factory.randomInt
import net.rom.exchange.test.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for GetItemExchange related instances
 */
class ItemExchangeFactory {

    companion object Factory {

        fun makeItemExchangeItemView(): ItemExchangeView {
            return ItemExchangeView(
                    randomUuid(),
                    randomUuid(),
                    makeGlobalView(),
                    randomInt(),
                    makeSeaView(),
                    randomDouble()
            )
        }


        fun makeDataItemView(): DataItemView {
            return DataItemView(
                    price = DataFactory.randomInt(),
                    time = DataFactory.randomUuid(),
                    snap = DataFactory.randomBoolean()
            )
        }

        fun makeDataItemViewList(count: Int): List<DataItemView> {
            val dataItems = mutableListOf<DataItemView>()
            repeat(count) {
                dataItems.add(makeDataItemView())
            }
            return dataItems
        }

        fun makeWeekView(): WeekView {
            return WeekView(
                    data = makeDataItemViewList(2),
                    change = DataFactory.randomDouble()
            )
        }

        fun makeMonthView(): MonthView {
            return MonthView(
                    data = makeDataItemViewList(2),
                    change = DataFactory.randomDouble()
            )
        }

        fun makeAllView(): AllView {
            return AllView(
                    data = makeDataItemViewList(2),
                    change = DataFactory.randomDouble()
            )
        }

        fun makeSeaView(): SeaView {
            return SeaView(
                    makeAllView(),
                    makeWeekView(),
                    makeMonthView(),
                    DataFactory.randomInt()
            )
        }

        fun makeGlobalView(): GlobalView {
            return GlobalView(
                    makeAllView(),
                    makeWeekView(),
                    makeMonthView(),
                    DataFactory.randomInt()
            )
        }

        fun makeItemView(): ItemExchangeView {
            return ItemExchangeView(
                    image = DataFactory.randomUuid(),
                    name = DataFactory.randomUuid(),
                    global = makeGlobalView(),
                    sea = makeSeaView(),
                    type = DataFactory.randomInt(),
                    globalSeaDiff = DataFactory.randomDouble()
            )
        }

        fun makeItemList(count: Int): List<ItemExchangeView> {
            val data = mutableListOf<ItemExchangeView>()
            repeat(count) {
                data.add(makeItemView())
            }
            return data
        }

    }

}