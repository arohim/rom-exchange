package net.rom.exchange.model

import com.github.mikephil.charting.data.Entry

/**
 * Representation for a [ItemExchangeViewModel] fetched from an external layer data source
 */
class ItemExchangeViewModel(
        val name: String,
        val globalPrice: String,
        val seaPrice: String,
        val globalChange: String,
        val seaChange: String,
        val seaDataGraph: List<Entry>,
        val globalDataGraph: List<Entry>
)