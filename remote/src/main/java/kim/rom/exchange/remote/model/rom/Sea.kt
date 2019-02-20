package kim.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Sea(

	@field:SerializedName("all")
	val all: All? = null,

	@field:SerializedName("week")
	val week: Week? = null,

	@field:SerializedName("month")
	val month: Month? = null,

	@field:SerializedName("latest")
	val latest: Int? = null
)