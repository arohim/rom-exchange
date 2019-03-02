package net.rom.exchange.mapper

import net.rom.exchange.domain.model.rom.DataItem
import net.rom.exchange.presentation.mapper.Mapper
import net.rom.exchange.presentation.model.DataGraphView
import org.joda.time.DateTime
import org.joda.time.DateTimeFieldType
import javax.inject.Inject

open class DataGraphMapper @Inject constructor() : Mapper<DataGraphView, DataItem> {
    override fun mapToView(type: DataItem): DataGraphView {
        val index = getIndex(type.time)
        return DataGraphView(index = index, price = type.price)
    }

    private fun getIndex(time: String): Int {
        val dateTime = DateTime(time)
        return dateTime.get(DateTimeFieldType.monthOfYear()) - 1
    }
}