package org.rom.exchange.remote.model.rom

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class GlobalModel(

        @field:SerializedName("all")
        val all: AllModel? = null,

        @field:SerializedName("week")
        val week: WeekModel? = null,

        @field:SerializedName("month")
        val month: MonthModel? = null,

        @field:SerializedName("latest")
        val latest: Int? = null
)