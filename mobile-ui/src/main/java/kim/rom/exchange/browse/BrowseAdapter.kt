package kim.rom.exchange.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kim.rom.exchange.R
import kim.rom.exchange.model.ROMExchangeItemViewModel
import javax.inject.Inject

class BrowseAdapter @Inject constructor() : RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    var items: List<ROMExchangeItemViewModel> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameText.text = item.name
        holder.textSeaPrice.text = item.price

//        Glide.with(holder.itemView.context)
//                .load(item.avatar)
//                .apply(RequestOptions.circleCropTransform())
//                .into(holder.iconImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_rom_exchange_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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