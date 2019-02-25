package net.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ItemExchangeModel(

        @field:SerializedName("image")
        val image: Any? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("global")
        val global: GlobalModel? = null,

        @field:SerializedName("type")
        val type: Int? = null,

        @field:SerializedName("sea")
        val sea: SeaModel? = null,

        @field:SerializedName("global_sea_diff")
        val globalSeaDiff: Double? = null
)