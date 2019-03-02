package net.rom.exchange.mapper

import com.github.mikephil.charting.data.Entry
import net.rom.exchange.presentation.mapper.Mapper
import net.rom.exchange.presentation.model.rom.DataItemView
import org.joda.time.DateTime
import org.joda.time.DateTimeFieldType
import javax.inject.Inject

open class DataGraphViewModelMapper @Inject constructor() : Mapper<Entry, DataItemView> {
    override fun mapToView(type: DataItemView): Entry {
        val index = getIndex(type.time)
        return Entry(index.toFloat(), type.price.toFloat())
    }

    private fun getIndex(time: String): Int {
        val dateTime = DateTime(time)
        return dateTime.get(DateTimeFieldType.monthOfYear()) - 1
    }
}