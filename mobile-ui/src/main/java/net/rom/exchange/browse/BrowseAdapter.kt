package net.rom.exchange.browse

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.LargeValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import net.rom.exchange.Constants.MONTHS
import net.rom.exchange.R
import net.rom.exchange.chart.ValueFormatter
import net.rom.exchange.model.ItemExchangeViewModel
import java.util.ArrayList
import javax.inject.Inject

class BrowseAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_ITEM = 1
    private val VIEW_PROG = 0

    private var items: MutableList<ItemExchangeViewModel?> = arrayListOf()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is ItemViewHolder) {
            holder.nameText.text = item?.name
            holder.textSeaPrice.text = item?.seaPrice
            holder.textGlobalPrice.text = item?.globalPrice
            holder.textSeaChange.text = item?.seaChange
            holder.textGlobalChange.text = item?.globalChange

            item?.let {
                setUpChartData(holder.chart, it)
            }

//        Glide.with(holder.itemView.context)
//                .load(item.avatar)
//                .apply(RequestOptions.circleCropTransform())
//                .into(holder.iconImage)
        }
    }

    private fun setUpChartData(chart: LineChart, item: ItemExchangeViewModel) {
        chart.description.isEnabled = false
        chart.setBackgroundColor(Color.WHITE)
        chart.setTouchEnabled(false)

        val leftAxis = chart.axisLeft
        leftAxis.setDrawGridLines(false)
        leftAxis.axisMinimum = 0f // this replaces setStartAtZero(true)
        leftAxis.valueFormatter = LargeValueFormatter()

        val rightAxis = chart.axisRight
        rightAxis.isEnabled = false

        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.axisMinimum = 0f
        xAxis.granularity = 1f
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return MONTHS[value.toInt() % MONTHS.size]
            }
        }

        val dataSets = ArrayList<ILineDataSet>()

        val seaGraph = LineDataSet(item.seaDataGraph, "Sea")
        seaGraph.lineWidth = 1F
        seaGraph.circleRadius = 3F
        val seaGraphColor = ColorTemplate.JOYFUL_COLORS[1]
        seaGraph.color = seaGraphColor
        seaGraph.setCircleColor(seaGraphColor)
        dataSets.add(seaGraph)

        val globalGraph = LineDataSet(item.globalDataGraph, "Global")
        globalGraph.lineWidth = 1F
        globalGraph.circleRadius = 3F
        val globalGraphColor = ColorTemplate.JOYFUL_COLORS[0]
        globalGraph.color = globalGraphColor
        globalGraph.setCircleColor(globalGraphColor)
        dataSets.add(globalGraph)

        val data = LineData(dataSets)
        data.setValueFormatter(LargeValueFormatter())
        chart.data = data
        chart.invalidate()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_ITEM -> {
                val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.view_browse_item_exchange, parent, false)
                return ItemViewHolder(itemView)
            }
            VIEW_PROG -> {
                val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.progress_bar, parent, false)
                return ProgressBarViewHolder(itemView)
            }
            else -> {
                val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.progress_bar, parent, false)
                return ProgressBarViewHolder(itemView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] != null) {
            VIEW_ITEM
        } else {
            VIEW_PROG
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitItems(items: List<ItemExchangeViewModel?>) {
        items.forEach {
            this.items.add(it)
            notifyItemInserted(itemCount)
        }
    }

    fun reset() {
        items.clear()
        notifyDataSetChanged()
    }

    fun showProgress() {
        this.items.add(null)
        notifyItemInserted(itemCount - 1)
    }

    fun hideProgress() {
        this.items.removeAt(itemCount - 1)
        notifyItemRemoved(itemCount)
    }

    inner class ProgressBarViewHolder(view: View) : RecyclerView.ViewHolder(view)

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        var iconImage: ImageView
        var nameText: TextView
        var textGlobalPrice: TextView
        var textSeaPrice: TextView
        var textGlobalChange: TextView
        var textSeaChange: TextView
        var chart: LineChart

        init {
//            iconImage = view.findViewById(R.id.icon_avatar)
            nameText = view.findViewById(R.id.text_name)
            textGlobalPrice = view.findViewById(R.id.text_global_price)
            textSeaPrice = view.findViewById(R.id.text_sea_price)
            textGlobalChange = view.findViewById(R.id.text_global_change)
            textSeaChange = view.findViewById(R.id.text_sea_change)
            chart = view.findViewById(R.id.chart)
        }

    }

}