package kim.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class WeekEntity(

        @field:SerializedName("data")
        val data: List<DataItemEntity?>? = null,

        @field:SerializedName("change")
        val change: Int? = null
)