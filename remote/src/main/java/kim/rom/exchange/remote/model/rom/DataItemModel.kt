package kim.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DataItemModel(

        @field:SerializedName("price")
        val price: Int? = null,

        @field:SerializedName("time")
        val time: String? = null,

        @field:SerializedName("snap")
        val snap: Boolean? = null
)