package net.rom.exchange.chart

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.LargeValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import net.rom.exchange.Constants
import net.rom.exchange.formater.ValueFormatter
import java.util.ArrayList

class ExchangeChart : LineChart {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(context, attributeSet, defStyle) {
        setUpChart()
    }

    private fun setUpChart() {
        description.isEnabled = false
        setBackgroundColor(Color.WHITE)
        setTouchEnabled(false)

        axisLeft.setDrawGridLines(false)
        axisLeft.axisMinimum = 0f // this replaces setStartAtZero(true)
        axisLeft.valueFormatter = LargeValueFormatter()

        axisRight.isEnabled = false

        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.axisMinimum = 0f
        xAxis.granularity = 1f
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return Constants.MONTHS[value.toInt() % Constants.MONTHS.size]
            }
        }
    }

    fun setExchangeData(seaDataGraph: List<Entry>, globalDataGraph: List<Entry>) {
        val dataSets = ArrayList<ILineDataSet>()

        val seaGraph = LineDataSet(seaDataGraph, "Sea")
        seaGraph.lineWidth = 1F
        seaGraph.circleRadius = 3F
        val seaGraphColor = ColorTemplate.JOYFUL_COLORS[1]
        seaGraph.color = seaGraphColor
        seaGraph.setCircleColor(seaGraphColor)
        dataSets.add(seaGraph)

        val globalGraph = LineDataSet(globalDataGraph, "Global")
        globalGraph.lineWidth = 1F
        globalGraph.circleRadius = 3F
        val globalGraphColor = ColorTemplate.JOYFUL_COLORS[0]
        globalGraph.color = globalGraphColor
        globalGraph.setCircleColor(globalGraphColor)
        dataSets.add(globalGraph)

        val lineData = LineData(dataSets)
        lineData.setValueFormatter(LargeValueFormatter())
        data = lineData
        invalidate()
    }
}