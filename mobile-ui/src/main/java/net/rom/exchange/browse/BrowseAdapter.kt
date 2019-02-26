package net.rom.exchange.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.rom.exchange.R
import net.rom.exchange.model.ItemExchangeViewModel
import javax.inject.Inject

class BrowseAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var isLoading: Boolean = false

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

//        Glide.with(holder.itemView.context)
//                .load(item.avatar)
//                .apply(RequestOptions.circleCropTransform())
//                .into(holder.iconImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_ITEM -> {
                val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_rom_exchange_item, parent, false)
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

    fun showProgress() {
        isLoading = true
        this.items.add(null)
        notifyItemChanged(itemCount)
    }

    fun hideProgress() {
        isLoading = false
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

        init {
//            iconImage = view.findViewById(R.id.icon_avatar)
            nameText = view.findViewById(R.id.text_name)
            textGlobalPrice = view.findViewById(R.id.text_global_price)
            textSeaPrice = view.findViewById(R.id.text_sea_price)
            textGlobalChange = view.findViewById(R.id.text_global_change)
            textSeaChange = view.findViewById(R.id.text_sea_change)
        }
    }

}