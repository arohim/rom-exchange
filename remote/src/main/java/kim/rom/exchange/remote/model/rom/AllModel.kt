package kim.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AllModel(

		@field:SerializedName("data")
	val data: List<DataItemModel?>? = null,

		@field:SerializedName("change")
	val change: Int? = null
)