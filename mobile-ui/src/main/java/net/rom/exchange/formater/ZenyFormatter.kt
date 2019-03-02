package net.rom.exchange.formater

import com.github.mikephil.charting.formatter.LargeValueFormatter

object ZenyFormatter {
    private var suffix = " Z"

    fun makeZeny(number: Int): String {
        return LargeValueFormatter().getFormattedValue(number.toFloat(), null) + suffix
    }
}