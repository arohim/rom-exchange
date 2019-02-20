package kim.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class GlobalEntity(

        @field:SerializedName("all")
        val all: AllEntity? = null,

        @field:SerializedName("week")
        val week: WeekEntity? = null,

        @field:SerializedName("month")
        val month: MonthEntity? = null,

        @field:SerializedName("latest")
        val latest: Int? = null
)